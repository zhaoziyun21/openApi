package com.hualala.qa.k8s.op.config.scheduler;


import com.hualala.qa.k8s.op.service.IJenkinsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: yefei
 * @date: 2018/9/10 00:36
 * @desc: 定时任务配置
 */

@Slf4j
@Component
public class SchedulerJenkinsConfig {

    @Autowired
    private IJenkinsService jenkinsService;

    @Scheduled(fixedRate = 3600000, initialDelay = 600000)
    private void process(){

        log.info("spring boot scheduler running: syncJenkinsStatus ");
        jenkinsService.syncJenkinsStatus();
    }


}
