package com.hualala.qa.k8s.op.dao.impl;

import com.hualala.qa.k8s.op.config.db.DatabaseContextHolder;
import com.hualala.qa.k8s.op.config.db.DatabaseType;
import com.hualala.qa.k8s.op.dao.IAgentDao;
import com.hualala.qa.k8s.op.dao.IProjectDao;
import com.hualala.qa.k8s.op.model.gen.dao.AgentMapper;
import com.hualala.qa.k8s.op.model.gen.dao.TblPreServiceStatusMapper;
import com.hualala.qa.k8s.op.model.gen.pojo.Agent;
import com.hualala.qa.k8s.op.model.gen.pojo.AgentExample;
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
public class AgentDaoImpl implements IAgentDao {

    @Autowired
    private AgentMapper agentMapper;


    @Override
    public int insertPreServiceStatus(Agent agent){
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        return agentMapper.insert(agent);
    }

    @Override
    public int deletePreServiceStatus(long id){
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        return agentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePreServiceStatus(Agent agent){
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        return agentMapper.updateByPrimaryKeySelective(agent);
    }

    @Override
    public List<Agent> queryPreServiceStatusList(){
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        AgentExample example = buildExample();
        return agentMapper.selectByExample(example);

    }

    @Override
    public long countPreServiceStatus() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        AgentExample example = buildExample();
        return agentMapper.countByExample(example);
    }

    @Override
    public Agent getPreServiceStatus(long id){
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        return agentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Agent> queryAllService() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        AgentExample example = buildExample();
        return agentMapper.selectByExample(example);
    }

    @Override
    public List<Agent> queryService(AgentExample example) {
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        return agentMapper.selectByExample(example);
    }




    private AgentExample buildExample(){
        DatabaseContextHolder.setDatabaseType(DatabaseType.kepler_management);
        AgentExample example = new AgentExample();
        AgentExample.Criteria criteria = example.createCriteria();

        return example;
    }
}
