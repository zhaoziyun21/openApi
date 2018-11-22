package com.hualala.qa.k8s.op.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hualala.qa.k8s.op.dao.IProjectDao;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import com.hualala.qa.k8s.op.service.IProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectDao projectDao;

    @Resource(name = "jacksonFormatter")
    private ObjectMapper jacksonFormatter;

    @Override
    public int save(JSONObject params) throws IOException {

        TblPreServiceStatus preServiceStatus = jacksonFormatter.readValue(params.toJSONString(), TblPreServiceStatus.class);

        if ( preServiceStatus.getID() > 0){

            return projectDao.updatePreServiceStatus(preServiceStatus);

        }else{
            return projectDao.insertPreServiceStatus(preServiceStatus);
        }

    }

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
        return projectDao.queryService(example);
    }


    @Override
    public List<TblPreServiceStatus> queryNeedDeployService(){
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andNeedDeployEqualTo(true);
        return projectDao.queryService(example);
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

    @Override
    public TblPreServiceStatus getService(String jenkinsJobName){
        TblPreServiceStatusExample example = buildExample();
        example.createCriteria().andJenkinsJobNameEqualTo(jenkinsJobName);

        List<TblPreServiceStatus> list = projectDao.queryService(example);

        if (list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }
    }


}
