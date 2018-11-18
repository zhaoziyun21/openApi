package com.hualala.qa.k8s.op.dao.common.impl;

import com.hualala.qa.mockserver.dao.common.IMappingJobDao;
import com.hualala.qa.mockserver.model.gen.dao.TblMappingJobMapper;
import com.hualala.qa.mockserver.model.gen.pojo.TblMappingJob;
import com.hualala.qa.mockserver.model.gen.pojo.TblMappingJobExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:16
 */
@Service
public class MappingJobDaoImpl implements IMappingJobDao {

    @Autowired
    private TblMappingJobMapper tblMappingJobMapper;

    @Override
    public int insertMappingJob(TblMappingJob tblMappingJob){
        return tblMappingJobMapper.insert(tblMappingJob);
    }

    @Override
    public int deleteMappingJob(int jobID){
        return tblMappingJobMapper.deleteByPrimaryKey(jobID);
    }

    @Override
    public List<TblMappingJob> queryTblMappingJobList(int requestID, String protocol){
        TblMappingJobExample example = buildExample(requestID, protocol);
        return tblMappingJobMapper.selectByExample(example);
    }

    @Override
    public long countMappingJob(int requestID, String protocol){
        TblMappingJobExample example = buildExample(requestID, protocol);
        return tblMappingJobMapper.countByExample(example);
    }

    private TblMappingJobExample buildExample(int requestID, String protocol){
        TblMappingJobExample example = new TblMappingJobExample();
        TblMappingJobExample.Criteria criteria = example.createCriteria();
        criteria.andProtocolEqualTo(protocol).andRequestIDEqualTo(requestID);

        example.setOrderByClause("isActive desc, sortIndex asc, updateTime desc");
        return example;
    }

    @Override
    public int updateMappingJob(TblMappingJob tblMappingJob){
        return tblMappingJobMapper.updateByPrimaryKeySelective(tblMappingJob);
    }
}
