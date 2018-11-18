package com.hualala.qa.k8s.op.dao.common.impl;

import com.hualala.qa.mockserver.config.ApplicationContextProvider;
import com.hualala.qa.mockserver.dao.common.ISystemConfigDao;
import com.hualala.qa.mockserver.model.gen.dao.TblSystemConfigMapper;
import com.hualala.qa.mockserver.model.gen.pojo.TblSystemConfig;
import com.hualala.qa.mockserver.model.gen.pojo.TblSystemConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:14
 */
@Service
public class SystemConfigDaoImpl implements ISystemConfigDao{

    @Autowired
    private TblSystemConfigMapper tblSystemConfigMapper;

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    @Override
    public int insertSystemConfig(TblSystemConfig tblSystemConfig){
        return tblSystemConfigMapper.insert(tblSystemConfig);
    }

    @Override
    public List<TblSystemConfig> queryTblSystemConfigList(int configType){
        TblSystemConfigExample example = buildExample(configType);
        return tblSystemConfigMapper.selectByExample(example);
    }

    @Override
    public long countTblSystemConfig(int configType){
        TblSystemConfigExample example = buildExample(configType);
        return tblSystemConfigMapper.countByExample(example);
    }

    public TblSystemConfigExample buildExample(int configType){
        TblSystemConfigExample example = new TblSystemConfigExample();
        TblSystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andConfigTypeEqualTo(configType);

        example.setOrderByClause("updateTime desc");
        return example;
    }

    @Override
    public int deleteSystemConfig(int configID){
        return tblSystemConfigMapper.deleteByPrimaryKey(configID);
    }

    @Override
    public int updateSystemConfig(TblSystemConfig tblSystemConfig) {
        return tblSystemConfigMapper.updateByPrimaryKeySelective(tblSystemConfig);
    }
}
