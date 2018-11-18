package com.hualala.qa.k8s.op.model.gen.pojo;

import java.util.Date;

public class TblPreServiceStatus {
    private Integer ID;

    private String serviceName;

    private String jenkinsJobName;

    private String serviceDescribe;

    private String business;

    private Boolean apmStatus;

    private Boolean k8sStatus;

    private String remark;

    private Boolean needDeploy;

    private Date apmuUpdateTime;

    private Date k8sUpdateTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getJenkinsJobName() {
        return jenkinsJobName;
    }

    public void setJenkinsJobName(String jenkinsJobName) {
        this.jenkinsJobName = jenkinsJobName == null ? null : jenkinsJobName.trim();
    }

    public String getServiceDescribe() {
        return serviceDescribe;
    }

    public void setServiceDescribe(String serviceDescribe) {
        this.serviceDescribe = serviceDescribe == null ? null : serviceDescribe.trim();
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public Boolean getApmStatus() {
        return apmStatus;
    }

    public void setApmStatus(Boolean apmStatus) {
        this.apmStatus = apmStatus;
    }

    public Boolean getK8sStatus() {
        return k8sStatus;
    }

    public void setK8sStatus(Boolean k8sStatus) {
        this.k8sStatus = k8sStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getNeedDeploy() {
        return needDeploy;
    }

    public void setNeedDeploy(Boolean needDeploy) {
        this.needDeploy = needDeploy;
    }

    public Date getApmuUpdateTime() {
        return apmuUpdateTime;
    }

    public void setApmuUpdateTime(Date apmuUpdateTime) {
        this.apmuUpdateTime = apmuUpdateTime;
    }

    public Date getK8sUpdateTime() {
        return k8sUpdateTime;
    }

    public void setK8sUpdateTime(Date k8sUpdateTime) {
        this.k8sUpdateTime = k8sUpdateTime;
    }
}