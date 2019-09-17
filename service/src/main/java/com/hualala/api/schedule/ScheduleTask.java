package com.hualala.api.schedule;

import com.hualala.api.HttpClient;
import com.hualala.api.controllers.OpenApiController;
import com.hualala.api.model.TblXfx;
import com.hualala.api.service.TblXfxService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaoziyun on 2019/3/15.
 */
@Component
@ConfigurationProperties(prefix="openapi")
@EnableScheduling   // 2.开启定时任务
@Data
public class ScheduleTask {
    public static final Logger logger = LoggerFactory.getLogger(OpenApiController.class);
    @Autowired
    HttpClient httpClient;
    @Autowired
    private TblXfxService tblXfxService;

    private String ownGetXfxClientUrl;

    //3.添加定时任务
    @Scheduled(cron = "0 */5 *  * * *")
    //或直接指定时间间隔，例如：1分钟
    //@Scheduled(fixedRate=5000)

    private void configureTasks() {

        List<TblXfx> tblXfxeList = tblXfxService.queryUnDeal();
        if(tblXfxeList !=null && tblXfxeList.size() > 0){
            // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
//            MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
            Map<String, String> params = new HashMap<>();
            for(TblXfx tblXfx : tblXfxeList){
                params.put("clientId",tblXfx.getClientId());
                params.put("productId",tblXfx.getProductId());
                params.put("mobile",tblXfx.getMobile());
                //发送http请求并返回结果
                String result = httpClient.get(ownGetXfxClientUrl, params);
                logger.info("getXFXClientInfo请求客户数据处理返回结果："+result);
            }
        }

    }
}