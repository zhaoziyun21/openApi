package com.hualala.qa.k8s.op.service.impl;

import com.hualala.qa.k8s.op.dao.IProjectDao;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import com.hualala.qa.k8s.op.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectDao projectDao;

    @Override
    public List<TblPreServiceStatus> queryAllService() {
        return projectDao.queryAllService();
    }

    @Override
    public List<TblPreServiceStatus> queryApmFailService(){
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andApmStatusEqualTo(false).andNeedDeployEqualTo(true);
        return projectDao.queryService(example);
    }

    @Override
    public List<TblPreServiceStatus> queryK8sFailService(){
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andK8sStatusEqualTo(false).andNeedDeployEqualTo(true);
        return projectDao.queryService(example);
    }

    @Override
    public List<TblPreServiceStatus> queryK8sSuccessService() {
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andK8sStatusEqualTo(true).andNeedDeployEqualTo(true);
        return projectDao.queryService(example);
    }

    @Override
    public List<TblPreServiceStatus> queryUnneedDeployService(){
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andNeedDeployEqualTo(false);
        return projectDao.queryPreServiceStatusList();
    }


    @Override
    public List<TblPreServiceStatus> queryNeedDeployService(){
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andNeedDeployEqualTo(true);
        return projectDao.queryPreServiceStatusList();
    }


    private TblPreServiceStatusExample buildExample(){
        TblPreServiceStatusExample example = new TblPreServiceStatusExample();
//        TblPreServiceStatusExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("k8sStatus asc, apmStatus asc");
        return example;
    }


    @Override
    public List<TblPreServiceStatus> queryApmSuccessService(){
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andApmStatusEqualTo(true).andNeedDeployEqualTo(true);

        return projectDao.queryService(example);
    }

}
