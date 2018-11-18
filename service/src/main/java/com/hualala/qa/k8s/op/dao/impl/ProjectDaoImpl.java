package com.hualala.qa.k8s.op.dao.impl;

import com.hualala.qa.k8s.op.dao.IProjectDao;
import com.hualala.qa.k8s.op.model.gen.dao.TblPreServiceStatusMapper;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:03
 */
@Service
public class ProjectDaoImpl implements IProjectDao {

    @Autowired
    private TblPreServiceStatusMapper tblPreServiceStatusMapper;


    @Override
    public List<TblPreServiceStatus> queryAllService() {
        TblPreServiceStatusExample example = buildExample();
        return tblPreServiceStatusMapper.queryAllService(example);
    }

    @Override
    public List<TblPreServiceStatus> queryApmService(TblPreServiceStatusExample example) {
        return tblPreServiceStatusMapper.queryApmService(example);
    }

    @Override
    public List<TblPreServiceStatus> queryK8sService(TblPreServiceStatusExample example) {
        return tblPreServiceStatusMapper.queryK8sService(example);
    }


    private TblPreServiceStatusExample buildExample(){
        TblPreServiceStatusExample example = new TblPreServiceStatusExample();
        TblPreServiceStatusExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("k8sStatus asc, apmStatus asc");
        return example;
    }

}
