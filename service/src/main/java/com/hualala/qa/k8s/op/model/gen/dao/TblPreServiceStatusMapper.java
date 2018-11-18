package com.hualala.qa.k8s.op.model.gen.dao;

import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblPreServiceStatusMapper {
    long countByExample(TblPreServiceStatusExample example);

    int deleteByExample(TblPreServiceStatusExample example);

    int deleteByPrimaryKey(Integer ID);

    int insert(TblPreServiceStatus record);

    int insertSelective(TblPreServiceStatus record);

    List<TblPreServiceStatus> selectByExample(TblPreServiceStatusExample example);

    TblPreServiceStatus selectByPrimaryKey(Integer ID);

    int updateByExampleSelective(@Param("record") TblPreServiceStatus record, @Param("example") TblPreServiceStatusExample example);

    int updateByExample(@Param("record") TblPreServiceStatus record, @Param("example") TblPreServiceStatusExample example);

    int updateByPrimaryKeySelective(TblPreServiceStatus record);

    int updateByPrimaryKey(TblPreServiceStatus record);
}