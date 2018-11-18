package com.hualala.qa.k8s.op.dao.rest.impl;

import com.hualala.qa.mockserver.dao.rest.IRestRequestMappingDao;
import com.hualala.qa.mockserver.model.gen.dao.TblRestRequestMappingMapper;
import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestMapping;
import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestMappingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:07
 */
@Service
public class RestRequestMappingDaoImpl implements IRestRequestMappingDao {

    @Autowired
    private TblRestRequestMappingMapper tblRestRequestMappingMapper;

    @Override
    public int insertRestRequestMapping(TblRestRequestMapping tblRestRequestMapping){
        return tblRestRequestMappingMapper.insert(tblRestRequestMapping);
    }

    @Override
    public int deleteRestRequestMaster(int requestID){
        return tblRestRequestMappingMapper.deleteByPrimaryKey(requestID);
    }

    @Override
    public int updateRestRequestMapping(TblRestRequestMapping tblRestRequestMapping){
        return tblRestRequestMappingMapper.updateByPrimaryKeyWithBLOBs(tblRestRequestMapping);
    }

    @Override
    public List<TblRestRequestMapping> queryRestRequestMappingList(int groupID){
        TblRestRequestMappingExample example = new TblRestRequestMappingExample();
        TblRestRequestMappingExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIDEqualTo(groupID);

        example.setOrderByClause("groupCode asc, sortIndex asc, updateTime desc");

        return tblRestRequestMappingMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public long countRestRequestMapping(int groupID){
        TblRestRequestMappingExample example = new TblRestRequestMappingExample();
        TblRestRequestMappingExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIDEqualTo(groupID);

        example.setOrderByClause("groupCode asc, sortIndex asc, updateTime desc");

        return tblRestRequestMappingMapper.countByExample(example);
    }

    @Override
    public int updateGroupCode(int groupID, String groupCode){
        TblRestRequestMapping tblRestRequestMapping = new TblRestRequestMapping();
        tblRestRequestMapping.setGroupCode(groupCode);

        TblRestRequestMappingExample example = new TblRestRequestMappingExample();
        TblRestRequestMappingExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIDEqualTo(groupID);


        return tblRestRequestMappingMapper.updateByExampleSelective(tblRestRequestMapping, example);
    }

    @Override
    public TblRestRequestMapping getMapping(int requestID){
        return tblRestRequestMappingMapper.selectByPrimaryKey(requestID);
    }
}
