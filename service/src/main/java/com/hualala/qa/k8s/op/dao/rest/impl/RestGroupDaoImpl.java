package com.hualala.qa.k8s.op.dao.rest.impl;

import com.hualala.qa.mockserver.dao.rest.IRestGroupDao;
import com.hualala.qa.mockserver.model.gen.dao.TblRestRequestGroupMapper;
import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestGroup;
import com.hualala.qa.mockserver.model.gen.pojo.TblRestRequestGroupExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:03
 */
@Service
public class RestGroupDaoImpl implements IRestGroupDao {

    @Autowired
    private TblRestRequestGroupMapper tblRestRequestGroupMapper;


    @Override
    public int insertRestRequestGroup(TblRestRequestGroup tblRestRequestGroup){
        return tblRestRequestGroupMapper.insert(tblRestRequestGroup);
    }

    @Override
    public int deleteRestRequestGroup(int groupID){
        TblRestRequestGroup record = new TblRestRequestGroup();
        record.setIsActive(false);

        TblRestRequestGroupExample example= new TblRestRequestGroupExample();
        TblRestRequestGroupExample.Criteria criteria = example.createCriteria();
        criteria.andGroupIDEqualTo(groupID);

        tblRestRequestGroupMapper.updateByExampleSelective(record, example);
        return tblRestRequestGroupMapper.deleteByPrimaryKey(groupID);
    }

    @Override
    public int updateRestRequestGroup(TblRestRequestGroup tblRestRequestGroup){
        return tblRestRequestGroupMapper.updateByPrimaryKeySelective(tblRestRequestGroup);
    }

    @Override
    public List<TblRestRequestGroup> queryRestRequestGroupList(){
        TblRestRequestGroupExample example = buildExample();
        return tblRestRequestGroupMapper.selectByExample(example);

    }

    @Override
    public long countRestRequestGroup(){
        TblRestRequestGroupExample example = buildExample();
        return tblRestRequestGroupMapper.countByExample(example);

    }

    private TblRestRequestGroupExample buildExample(){
        TblRestRequestGroupExample example = new TblRestRequestGroupExample();
        TblRestRequestGroupExample.Criteria criteria = example.createCriteria();

        criteria.andIsActiveEqualTo(true);

        example.setOrderByClause("sortIndex asc, updateTime desc");
        return example;
    }

    @Override
    public List<TblRestRequestGroup> queryRestGroupByCode(String groupCode){
        TblRestRequestGroupExample example = new TblRestRequestGroupExample();
        TblRestRequestGroupExample.Criteria criteria = example.createCriteria();
        criteria.andGroupCodeEqualTo(groupCode);

        return tblRestRequestGroupMapper.selectByExample(example);
    }

    @Override
    public long countRestGroupByCode(String groupCode){
        TblRestRequestGroupExample example = new TblRestRequestGroupExample();
        TblRestRequestGroupExample.Criteria criteria = example.createCriteria();
        criteria.andGroupCodeEqualTo(groupCode);

        return tblRestRequestGroupMapper.countByExample(example);
    }


    @Override
    public TblRestRequestGroup getGroup(int groupID){
        return tblRestRequestGroupMapper.selectByPrimaryKey(groupID);
    }

}
