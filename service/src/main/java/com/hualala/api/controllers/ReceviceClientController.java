package com.hualala.api.controllers;


import com.hualala.api.config.ResponseAdapter;
import com.hualala.api.exception.ResponseCodeEnum;
import com.hualala.api.model.TblClient;
import com.hualala.api.service.TblClientService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/receiveClient")
@Data
@Slf4j
public class ReceviceClientController {
    public static final Logger logger = LoggerFactory.getLogger(ReceviceClientController.class);
    @Autowired
    private ResponseAdapter responseAdapter;
    @Autowired
    private TblClientService tblClientService;


    /**
     * 推广数据入库
     * @param
     *
     *
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/saveClient.ajax")
    @ResponseBody
    public Object saveClient1(@RequestBody HashMap<String, String> map) {
        String clientName = map.get("clientName");
        String clientTel = map.get("clientTel");
        BigDecimal applyAmount = map.get("applyAmount")!=null?new BigDecimal(map.get("applyAmount")):BigDecimal.ZERO;
        Map<String,Object> result = new HashMap<>();
        try{
            logger.info("推广来的客户，clientName:"+clientName+";clientTel:"+clientTel+";applyAmount:"+applyAmount);
            //参数入库
            TblClient client = new TblClient();
            client.setClientName(clientName);
            client.setClientTel(clientTel);
            client.setApplyAmount(applyAmount);
            client.setStatus("0");
            client.setCreateTime(new Date());
            client.setClientFrom(2);
            tblClientService.save(client);

        }catch (Exception e){
            logger.error("推广来的客户保存时异常："+ExceptionUtils.getStackTrace(e));
            return responseAdapter.failure(ResponseCodeEnum.FAIL.getCode(),ResponseCodeEnum.FAIL.getReason());
        }


          return responseAdapter.success(result);
    }

}



