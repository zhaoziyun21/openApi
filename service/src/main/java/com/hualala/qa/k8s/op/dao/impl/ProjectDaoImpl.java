package com.hualala.qa.k8s.op.dao.impl;

import com.hualala.qa.k8s.op.config.db.DatabaseContextHolder;
import com.hualala.qa.k8s.op.config.db.DatabaseType;
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
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        return tblPreServiceStatusMapper.insert(tblPreServiceStatus);
    }

    @Override
    public int deletePreServiceStatus(int id){
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        return tblPreServiceStatusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePreServiceStatus(TblPreServiceStatus tblPreServiceStatus){
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        return tblPreServiceStatusMapper.updateByPrimaryKeySelective(tblPreServiceStatus);
    }

    @Override
    public List<TblPreServiceStatus> queryPreServiceStatusList(){
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        TblPreServiceStatusExample example = buildExample();
        return tblPreServiceStatusMapper.selectByExample(example);

    }

    @Override
    public long countPreServiceStatus() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        TblPreServiceStatusExample example = buildExample();
        return tblPreServiceStatusMapper.countByExample(example);
    }

    private TblPreServiceStatusExample buildExample(){
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        TblPreServiceStatusExample example = new TblPreServiceStatusExample();
        TblPreServiceStatusExample.Criteria criteria = example.createCriteria();

        example.setOrderByClause("k8sStatus asc, apmStatus asc");
        return example;
    }

    @Override
    public TblPreServiceStatus getPreServiceStatus(int id){
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        return tblPreServiceStatusMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TblPreServiceStatus> queryAllService() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        TblPreServiceStatusExample example = buildExample();
        return tblPreServiceStatusMapper.selectByExample(example);
    }

    @Override
    public List<TblPreServiceStatus> queryService(TblPreServiceStatusExample example) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.db_pre_k8s_op);
        return tblPreServiceStatusMapper.selectByExample(example);
    }


}
