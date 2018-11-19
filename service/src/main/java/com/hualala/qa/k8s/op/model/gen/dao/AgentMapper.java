package com.hualala.qa.k8s.op.model.gen.dao;

import com.hualala.qa.k8s.op.model.gen.pojo.Agent;
import com.hualala.qa.k8s.op.model.gen.pojo.AgentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentMapper {
    long countByExample(AgentExample example);

    int deleteByExample(AgentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Agent record);

    int insertSelective(Agent record);

    List<Agent> selectByExample(AgentExample example);

    List<Agent> selectSuccess();

    Agent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Agent record, @Param("example") AgentExample example);

    int updateByExample(@Param("record") Agent record, @Param("example") AgentExample example);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);
}