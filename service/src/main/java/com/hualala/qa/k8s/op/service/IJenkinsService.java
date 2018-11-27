package com.hualala.qa.k8s.op.service;

/**
 * @author: yefei
 * @date: 2018/11/18 17:34
 */
public interface IJenkinsService {

    void syncJenkinsStatus();

    String getJenkinsStatus(String jenkinsJobName);

    void buildJenkins(String jenkinsJobName);

    void buildJenkins();

    void rebuildAllJenkins();
}
