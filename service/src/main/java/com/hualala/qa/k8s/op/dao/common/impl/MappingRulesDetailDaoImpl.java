package com.hualala.qa.k8s.op.dao.common.impl;

import com.hualala.qa.mockserver.dao.common.IMappingRulesDetailDao;
import com.hualala.qa.mockserver.model.gen.dao.TblMappingRulesDetailMapper;
import com.hualala.qa.mockserver.model.gen.pojo.TblMappingRulesDetail;
import com.hualala.qa.mockserver.model.gen.pojo.TblMappingRulesDetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:08
 */
@Service
public class MappingRulesDetailDaoImpl implements IMappingRulesDetailDao {

    @Autowired
    private TblMappingRulesDetailMapper tblMappingRulesDetailMapper;

    @Override
    public int insertMappingRulesDetail(TblMappingRulesDetail tblMappingRulesDetail){
        return tblMappingRulesDetailMapper.insert(tblMappingRulesDetail);
    }

    @Override
    public int deleteMappingRulesDetail(int rulesDetailID){
        return tblMappingRulesDetailMapper.deleteByPrimaryKey(rulesDetailID);
    }

    @Override
    public List<TblMappingRulesDetail> queryMappingRulesDetail(int requestID, String protocol){
        TblMappingRulesDetailExample example = buildExample(requestID, protocol);
        return tblMappingRulesDetailMapper.selectByExample(example);
    }

    @Override
    public long countMappingRulesDetail(int requestID, String protocol){
        TblMappingRulesDetailExample example = buildExample(requestID, protocol);
        return tblMappingRulesDetailMapper.countByExample(example);
    }

    public TblMappingRulesDetailExample buildExample(int requestID, String protocol){
        TblMappingRulesDetailExample example = new TblMappingRulesDetailExample();
        TblMappingRulesDetailExample.Criteria criteria = example.createCriteria();
        criteria.andProtocolEqualTo(protocol).andRequestIDEqualTo(requestID);

        example.setOrderByClause("sortIndex asc, updateTime asc");
        return example;
    }

    @Override
    public int updateMappingRulesDetail(TblMappingRulesDetail tblMappingRulesDetail){
        return tblMappingRulesDetailMapper.updateByPrimaryKeySelective(tblMappingRulesDetail);
    }
}
