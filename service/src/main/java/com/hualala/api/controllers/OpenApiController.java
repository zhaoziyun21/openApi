package com.hualala.api.controllers;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hualala.api.HttpClient;
import com.hualala.api.config.ResponseAdapter;
import com.hualala.api.exception.ResponseCodeEnum;
import com.hualala.api.model.TblClient;
import com.hualala.api.model.TblXfx;
import com.hualala.api.service.TblClientService;
import com.hualala.api.service.TblXfxService;
import com.hualala.api.utils.SignUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


@Controller
@RequestMapping("/openApi")
@ConfigurationProperties(prefix="openapi")
@Data
@Slf4j
public class OpenApiController {
    public static final Logger logger = LoggerFactory.getLogger(OpenApiController.class);
    @Autowired
    private ResponseAdapter responseAdapter;
    @Autowired
    private TblClientService tblClientService;
    @Autowired
    private TblXfxService tblXfxService;
    @Autowired
    HttpClient httpClient;

    private String sKey;
    private String url;
    private String signKey;

     /**
      * 获取新分享的参数，入库，
     * @param map
      *
      *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getXFXClientParams.ajax", method = RequestMethod.POST, produces="application/json")
    @ResponseBody
//    public Object getXFXClientParams(@RequestParam(name = "clientId") String clientId
//            ,@RequestParam(name = "mobile") String mobile
//             ,@RequestParam(name = "productId") String productId) {
    public Object getXFXClientParams(@RequestBody HashMap<String, String> map ) {
        String clientId = map.get("clientId");
        String mobile = map.get("mobile");
        String productId = map.get("productId");
        Map<String,Object> result = new HashMap<>();
        try{
            logger.info("clientId:"+clientId+";mobile:"+mobile+";productId:"+productId);
            //参数入库
            TblXfx xfx = new TblXfx();
            xfx.setClientId(clientId);
            xfx.setMobile(mobile);
            xfx.setProductId(productId);
            xfx.setStatus("0");
            tblXfxService.save(xfx);

        }catch (DuplicateKeyException e){
            logger.error("获取数据时DuplicateKeyException异常："+ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ResponseCodeEnum.DUPLICATE_IN_DB.getCode(),ResponseCodeEnum.DUPLICATE_IN_DB.getReason());
        }catch (Exception e){
            logger.error("获取数据时处理异常："+ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ResponseCodeEnum.DUPLICATE_IN_DB.getCode(),ResponseCodeEnum.DUPLICATE_IN_DB.getReason());
        }


        return  responseAdapter.success(result);
    }

    /**
     * 获取新分享的数据，入库，
     * 然后去调用他们的接口获取客户资源，入库
     * @param clientId
     *
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/getXFXClientInfo.ajax", method = RequestMethod.GET)
    @ResponseBody
    public Object getXFXClientInfo(@RequestParam(name = "clientId") String clientId
            ,@RequestParam(name = "mobile") String mobile
            ,@RequestParam(name = "productId") String productId) {
        Map<String,Object> result = new HashMap<>();
        try{
            String sign = SignUtils.xfxSignMethod(clientId, productId,signKey);
            logger.info("clientId:"+clientId+";mobile:"+mobile+";productId:"+productId);

            Map<String, String> params= new HashMap<>();
            params.put("clientId",clientId);
            params.put("productId",productId);
            params.put("dataType","1");
            params.put("sign",sign);
            //发送http请求并返回结果
            String resp = httpClient.get(url, params);
            logger.info("客户数据is "+resp);
//          String  resp = httpClient.client(prodUrl, method, params);
//            resp = "{\"data\":\'{\"accumulationfund\":0,\"age\":28,\"birthdate\":\"1980-08-01\",\"city\":\"上海市\",\"creditCard\":1,\"expectation\":5.0,\"haveCar\":1,\"haveHouse\":1,\"idCard\":\"Kqnj1tfB3skpSOq8KSsjAeANOmW0SSgqoUbJ70EDvfY=\",\"insure\":1,\"mobile\":\"fPoskxKdE7uqzb/0lXxbyg==\",\"name\":\"7fFNh98Am2LdlayvpWek1Q==\",\"province\":\"上海市\",\"sex\":2,\"wagePayment\":1,\"weiLiDai\":1}\',\"code\": \"200\",\"msg\": \"OK\"}";
            JSONObject jsonObject = JSON.parseObject(resp);
            String data = (String) jsonObject.get("data");
            String msg = (String) jsonObject.get("msg");
            JSONObject clientInfo = JSON.parseObject(data);
            if(clientInfo != null){
                //入库
                TblClient client = new TblClient();
                client.setClientName(SignUtils.decrypt(clientInfo.get("name").toString(), sKey));
                client.setIdCard(SignUtils.decrypt(clientInfo.get("idCard").toString(), sKey));
                client.setClientTel(SignUtils.decrypt(clientInfo.get("mobile").toString(), sKey));
                client.setBirthdate(clientInfo.get("birthdate").toString());
                client.setSex(clientInfo.get("sex").toString());
                client.setCity(clientInfo.get("city").toString());
                client.setApplyAmount(new BigDecimal(clientInfo.get("expectation").toString()));
                client.setAge(Integer.parseInt(clientInfo.get("age").toString()));
                client.setProvince(clientInfo.get("province").toString());
                client.setSalaryType(clientInfo.get("wagePayment").toString());
                client.setHaveHouse(clientInfo.get("haveHouse").toString());
                client.setHaveCar(clientInfo.get("haveCar").toString());
                if(Integer.parseInt(clientInfo.get("accumulationfund").toString()) > 0){
                    client.setIsGjj(1);
                }
                if(Integer.parseInt(clientInfo.get("accumulationfund").toString()) == 2){
                    client.setGjjYears("36个月");
                }

                if(Integer.parseInt(clientInfo.get("insure").toString()) > 0){
                    client.setHaveInsure("1");
                }

                if(Integer.parseInt(clientInfo.get("insure").toString()) == 2){
                    client.setInsureBillMonthPay(new BigDecimal("24"));
                }
                client.setCreditCard(clientInfo.get("accumulationfund").toString());
                client.setIsParticleLoan(Integer.parseInt(clientInfo.get("weiLiDai").toString()));
                client.setCreateTime(new Date());
                tblClientService.save(client,clientId,mobile,productId);
            }else{
                return responseAdapter.failure(msg);
            }

        }catch (Exception e){
            logger.error("获取数据处理时异常,clientId:"+clientId);
            return responseAdapter.failure("获取数据处理时异常");
        }


        result.put("code",200);
        result.put("msg","成功");
        return  responseAdapter.success(result);
    }

    /**
     * roomID生成  jsonp实现
     * @param userID
     * @return
     * @throws IOException
     */
    @RequestMapping("/genRoomIDUpgrade.ajax")
    @ResponseBody
    public Object genRoomIDForJsonp(@RequestParam(name = "userID") String userID,@RequestParam(name = "meetingID") String meetingID,String callback) {
        Map<String,Object> result = new HashMap<>();
        result.put("roomID","");
        result.put("groupID","");
        return callback+"("+responseAdapter.success(result)+")";
    }
}



