package com.hualala.qa.k8s.op.dao;

import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:03
 */
public interface IProjectDao {

    abstract int insertPreServiceStatus(TblPreServiceStatus tblPreServiceStatus);

    int deletePreServiceStatus(int id);

    int updatePreServiceStatus(TblPreServiceStatus tblPreServiceStatus);

    List<TblPreServiceStatus> queryPreServiceStatusList();

    long countPreServiceStatus();

    TblPreServiceStatus getPreServiceStatus(int id);

    List<TblPreServiceStatus> queryPreServiceStatusList(TblPreServiceStatusExample example);
}
