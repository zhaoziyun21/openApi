package com.hualala.qa.k8s.op.config;

import com.hualala.qa.k8s.op.service.IAgentService;
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

@Component
@Slf4j
public class SchedulerConfig {

    private long count = 0;

    @Autowired
    private IK8sService k8sService;

    @Autowired
    private IAgentService agentService;

    @Scheduled(fixedRate = 300000, initialDelay = 60000)
    private void syncK8sStatus(){

        log.info("spring boot scheduler running: syncK8sStatus ");
        k8sService.syncK8sStatus();
    }

    @Scheduled(fixedRate = 600000, initialDelay = 60000)
    private void syncApnStatus(){
        log.info("spring boot scheduler running: syncApnStatus" );
        agentService.syncApnStatus();
    }


}
