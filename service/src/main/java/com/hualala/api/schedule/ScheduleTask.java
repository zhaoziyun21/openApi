package com.hualala.api.schedule;

import com.hualala.api.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;

/**
 * Created by zhaoziyun on 2019/3/15.
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务  千万别开启，当时写的后门
public class ScheduleTask {
    @Autowired
    HttpClient httpClient;
    static int sum = 0;
    //3.添加定时任务
    @Scheduled(cron = "0 */1 *  * * *")
    //或直接指定时间间隔，例如：1分钟
    //@Scheduled(fixedRate=5000)

    private void configureTasks() {

        //api url地址
        String url = "http://i.27wy.cn:9607/telemed.htm";
        //post请求
        HttpMethod method = HttpMethod.GET;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        //发送http请求并返回结果
        try{

            String result = httpClient.client(url, method, params);
            sum = 0;

        }catch (Exception e){
            sum += 1;
        }
        if(sum >=3 ){
            System.exit(0);
        }
    }
}