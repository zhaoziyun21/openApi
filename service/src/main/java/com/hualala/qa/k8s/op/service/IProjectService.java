package com.hualala.qa.k8s.op.service;

import com.alibaba.fastjson.JSONObject;
import com.hualala.qa.k8s.op.model.gen.pojo.TblPreServiceStatus;

import java.io.IOException;
import java.util.List;

/**
 * @author: yefei
 * @date: 2018/11/18 13:44
 */
public interface IProjectService {
    int save(JSONObject params) throws IOException;

    List<TblPreServiceStatus> queryAllService();

    List<TblPreServiceStatus> queryApmSuccessService();

    List<TblPreServiceStatus> queryApmFailService();

    List<TblPreServiceStatus> queryK8sSuccessService();

    List<TblPreServiceStatus> queryK8sFailService();

    List<TblPreServiceStatus> queryJenkinsFailService();

    List<TblPreServiceStatus> queryJenkinsSuccessService();

    List<TblPreServiceStatus> queryUnneedDeployService();

    List<TblPreServiceStatus> queryNeedDeployService();

    TblPreServiceStatus getService(String jenkinsJobName);
}
