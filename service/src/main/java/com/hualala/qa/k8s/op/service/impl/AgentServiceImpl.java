package com.hualala.qa.k8s.op.service.impl;

import com.hualala.qa.k8s.op.dao.IAgentDao;
import com.hualala.qa.k8s.op.dao.IProjectDao;
import com.hualala.qa.k8s.op.model.gen.pojo.Agent;
import com.hualala.qa.k8s.op.model.gen.pojo.AgentExample;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import com.hualala.qa.k8s.op.service.IAgentService;
import com.hualala.qa.k8s.op.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
@Service
public class AgentServiceImpl implements IAgentService {

    @Autowired
    private IAgentDao agentDao;

    @Override
    public List<Agent> queryAllService() {
        return agentDao.queryAllService();
    }

//    @Override
//    public List<Agent> queryApmFailService(){
//        AgentExample example = buildExample();
//        example.createCriteria().andApmStatusEqualTo(false).andNeedDeployEqualTo(true);
//        return agentDao.queryService(example);
//    }
//
//
//    @Override
//    public List<Agent> queryApmSuccessService(){
//        AgentExample example = buildExample();
//        example.createCriteria().andApmStatusEqualTo(true).andNeedDeployEqualTo(true);
//
//        return agentDao.queryService(example);
//    }
//
//
//    @Override
//    public List<Agent> queryK8sFailService(){
//        AgentExample example = buildExample();
//        example.createCriteria().andK8sStatusEqualTo(false).andNeedDeployEqualTo(true);
//        return agentDao.queryService(example);
//    }

//    @Override
//    public List<Agent> queryK8sSuccessService() {
//        AgentExample example = buildExample();
//        example.createCriteria().andK8sStatusEqualTo(true).andNeedDeployEqualTo(true);
//        return agentDao.queryService(example);
//    }
//
//    @Override
//    public List<Agent> queryUnneedDeployService(){
//        AgentExample example = buildExample();
//        example.createCriteria().andNeedDeployEqualTo(false);
//        return agentDao.queryPreServiceStatusList();
//    }
//
//
//    @Override
//    public List<Agent> queryNeedDeployService(){
//        AgentExample example = buildExample();
//        example.createCriteria().andNeedDeployEqualTo(true);
//        return agentDao.queryPreServiceStatusList();
//    }
//
//




    private AgentExample buildExample(){
        AgentExample example = new AgentExample();
//        TblPreServiceStatusExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("k8sStatus asc, apmStatus asc");
        return example;
    }


}