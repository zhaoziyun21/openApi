package com.hualala.qa.k8s.op.dao;

import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatusExample;

import java.util.List;

/**
 * @author: yefei
 * @date: 2018/10/4 22:03
 */
public interface IProjectDao {

    List<TblPreServiceStatus> queryAllService();

    List<TblPreServiceStatus> queryApmService(TblPreServiceStatusExample example);

    List<TblPreServiceStatus> queryK8sService(TblPreServiceStatusExample example);
}
