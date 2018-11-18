package com.hualala.qa.k8s.op.dao.common.impl;

import com.hualala.qa.mockserver.dao.common.IMappingTaskDao;
import com.hualala.qa.mockserver.model.gen.dao.TblMappingTaskMapper;
import com.hualala.qa.mockserver.model.gen.pojo.TblMappingTask;
import com.hualala.qa.mockserver.model.gen.pojo.TblMappingTaskExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:16
 */
@Service
public class MappingTaskDaoImpl implements IMappingTaskDao {

    @Autowired
    private TblMappingTaskMapper tblMappingTaskMapper;

    @Override
    public int insertMappingTask(TblMappingTask tblMappingTask){
        return tblMappingTaskMapper.insert(tblMappingTask);
    }

    @Override
    public int deleteMappingTask(int taskID){
        return tblMappingTaskMapper.deleteByPrimaryKey(taskID);
    }

    @Override
    public int updateMappingTask(TblMappingTask tblMappingTask){
        return tblMappingTaskMapper.updateByPrimaryKeyWithBLOBs(tblMappingTask);
    }

    @Override
    public List<TblMappingTask> queryMappingTaskList(int jobID){
        TblMappingTaskExample example = buildExample(jobID);
        return tblMappingTaskMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public long countMappingTask(int jobID){
        TblMappingTaskExample example = buildExample(jobID);
        return tblMappingTaskMapper.countByExample(example);
    }

    public TblMappingTaskExample buildExample(int jobID){
        TblMappingTaskExample example = new TblMappingTaskExample();
        TblMappingTaskExample.Criteria criteria = example.createCriteria();
        criteria.andJobIDEqualTo(jobID);

        example.setOrderByClause("isActive desc, sortIndex asc, updateTime desc");

        return example;
    }

}
