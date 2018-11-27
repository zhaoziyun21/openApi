package com.hualala.qa.k8s.op.config.scheduler;


import com.hualala.qa.k8s.op.service.IK8sService;
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
public class SchedulerK8sConfig {

    @Autowired
    private IK8sService k8sService;

    @Scheduled(fixedRate = 300000, initialDelay = 60000)
    private void process(){

        log.info("spring boot scheduler running: syncK8sStatus ");
        k8sService.syncK8sStatus();
    }


}
