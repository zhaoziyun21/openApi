package com.hualala.api.controllers;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hualala.api.HttpClient;
import com.hualala.api.config.ResponseAdapter;
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
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;


@Controller
@RequestMapping("/openApi")
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


     /**
      * 获取新分享的参数，入库，
     * @param clientId
      *
      *
     * @return
     * @throws IOException
     */
    @RequestMapping("/getXFXClientParams.ajax")
    @ResponseBody
    public Object getXFXClientParams(@RequestParam(name = "clientId") String clientId
            ,@RequestParam(name = "mobile") String mobile
             ,@RequestParam(name = "productId") String productId) {
        Map<String,Object> result = new HashMap<>();
        try{
            logger.info("clientId:"+clientId+";mobile:"+mobile+";productId:"+productId);

            //参数入库
            TblXfx xfx = new TblXfx();
            xfx.setClientId(clientId);
            xfx.setMobile(mobile);
            xfx.setProductId(productId);
            tblXfxService.save(xfx);

        }catch (Exception e){
            logger.error("获取数据时异常："+ExceptionUtils.getStackTrace(e));
            result.put("code",111);
            result.put("msg","失败");
            result.put("data", ExceptionUtils.getStackTrace(e));
        }


        result.put("code",200);
        result.put("msg","成功");
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
    @RequestMapping("/getXFXClientInfo.ajax")
    @ResponseBody
    public Object getXFXClientInfo(@RequestParam(name = "clientId") String clientId
            ,@RequestParam(name = "mobile") String mobile
            ,@RequestParam(name = "productId") String productId
            ,@RequestParam(name = "isTest") boolean isTest) {
        Map<String,Object> result = new HashMap<>();
        try{
            String sign = SignUtils.xfxSignMethod(clientId, productId);
            logger.info("clientId:"+clientId+";mobile:"+mobile+";productId:"+productId);

            //api url地址
            String testUrl = "http://111.230.216.152:8001/loansupermarket/api/o/getClientInfo";
            String prodUrl = "https://starsource.weshareholdings.com/loansupermarket/api/o/getClientInfo";
            //get请求
            HttpMethod method = HttpMethod.GET;
            // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
            MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
            params.set("clientId",clientId);
            params.set("productId",productId);
            params.set("dataType","1");
            params.set("sign",sign);
            //发送http请求并返回结果
            String resp = "";
            if(isTest){
                //            String resp = httpClient.client(testUrl, method, params);
            }else{
                //            String resp = httpClient.client(prodUrl, method, params);
            }
            resp = "{\"data\":\'{\"accumulationfund\":0,\"age\":28,\"birthdate\":\"1980-08-01\",\"city\":\"上海市\",\"creditCard\":1,\"expectation\":5.0,\"haveCar\":1,\"haveHouse\":1,\"idCard\":\"Kqnj1tfB3skpSOq8KSsjAeANOmW0SSgqoUbJ70EDvfY=\",\"insure\":1,\"mobile\":\"fPoskxKdE7uqzb/0lXxbyg==\",\"name\":\"7fFNh98Am2LdlayvpWek1Q==\",\"province\":\"上海市\",\"sex\":2,\"wagePayment\":1,\"weiLiDai\":1}\',\"code\": \"200\",\"msg\": \"OK\"}";
            JSONObject jsonObject = JSON.parseObject(resp);
            String data = (String) jsonObject.get("data");
            JSONObject clientInfo = JSON.parseObject(data);
            String sKey = "asdsdadsadwqedsd";

            String mobile1 = SignUtils.decrypt(clientInfo.get("mobile").toString(), sKey);
            System.out.println(mobile1.equals("13589526525"));
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
            tblClientService.save(client);
        }catch (Exception e){
            logger.error("获取数据时异常："+ExceptionUtils.getStackTrace(e));
            result.put("code",111);
            result.put("msg","失败");
            result.put("data", ExceptionUtils.getStackTrace(e));
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



