package com.hualala.qa.k8s.op.service;

/**
 * @author: yefei
 * @date: 2018/11/18 17:34
 */
public interface IK8sService {
    void syncK8sStatus();

    String getK8sStatus(String jenkinsJobName);

    void reloadK8s(String jenkinsJobName);

    void reloadAllK8s();

    void reloadK8s();
}
