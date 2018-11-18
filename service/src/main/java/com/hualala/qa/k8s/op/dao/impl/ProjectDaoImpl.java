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
    public int insertPreServiceStatus(TblPreServiceStatus tblPreServiceStatus){
        return tblPreServiceStatusMapper.insert(tblPreServiceStatus);
    }

    @Override
    public int deletePreServiceStatus(int id){

        return tblPreServiceStatusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePreServiceStatus(TblPreServiceStatus tblPreServiceStatus){
        return tblPreServiceStatusMapper.updateByPrimaryKeySelective(tblPreServiceStatus);
    }

    @Override
    public List<TblPreServiceStatus> queryPreServiceStatusList(){
        TblPreServiceStatusExample example = buildExample();
        return tblPreServiceStatusMapper.selectByExample(example);

    }

    @Override
    public long countPreServiceStatus() {
        TblPreServiceStatusExample example = buildExample();
        return tblPreServiceStatusMapper.countByExample(example);
    }

    private TblPreServiceStatusExample buildExample(){
        TblPreServiceStatusExample example = new TblPreServiceStatusExample();
        TblPreServiceStatusExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("k8sStatus asc, apmStatus asc");
        return example;
    }

    @Override
    public TblPreServiceStatus getPreServiceStatus(int id){
        return tblPreServiceStatusMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TblPreServiceStatus> queryAllService() {
        TblPreServiceStatusExample example = buildExample();
        return tblPreServiceStatusMapper.selectByExample(example);
    }

    @Override
    public List<TblPreServiceStatus> queryService(TblPreServiceStatusExample example) {
        return tblPreServiceStatusMapper.selectByExample(example);
    }


}
