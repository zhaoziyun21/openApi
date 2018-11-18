package com.hualala.qa.k8s.op.model.gen.pojo;

public class TblPreServiceStatus {
    private Integer ID;

    private String serviceName;

    private String jenkinsJobName;

    private String serviceDescribe;

    private String business;

    private Integer apmStatus;

    private Integer k8sStatus;

    private String remark;

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

    public Integer getApmStatus() {
        return apmStatus;
    }

    public void setApmStatus(Integer apmStatus) {
        this.apmStatus = apmStatus;
    }

    public Integer getK8sStatus() {
        return k8sStatus;
    }

    public void setK8sStatus(Integer k8sStatus) {
        this.k8sStatus = k8sStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}