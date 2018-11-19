package com.hualala.qa.k8s.op.dao;

import com.hualala.qa.k8s.op.model.gen.pojo.Agent;
import com.hualala.qa.k8s.op.model.gen.pojo.AgentExample;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:03
 */
public interface IAgentDao {

    Agent getPreServiceStatus(long id);

    List<Agent> queryAllService();

    List<Agent> queryService(AgentExample example);

    int insertPreServiceStatus(Agent agent);

    int deletePreServiceStatus(long id);

    int updatePreServiceStatus(Agent agent);

    List<Agent> queryPreServiceStatusList();

    long countPreServiceStatus();
}
