package com.hualala.qa.k8s.op.service;

import com.hualala.qa.k8s.op.model.gen.pojo.Agent;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
public interface IAgentService {
    List<Agent> queryAllService();

    List<Agent> queryActiveService();

    void syncApnStatus();

//    List<Agent> queryApmFailService();
//
//    List<Agent> queryApmSuccessService();
//
//    List<Agent> queryK8sFailService();
//
//    List<Agent> queryK8sSuccessService();
//
//    List<Agent> queryUnneedDeployService();
//
//    List<Agent> queryNeedDeployService();
}
