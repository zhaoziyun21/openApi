package com.hualala.qa.k8s.op.model.gen.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblPreServiceStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblPreServiceStatusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("serviceName is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("serviceName is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("serviceName =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("serviceName <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("serviceName >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("serviceName >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("serviceName <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("serviceName <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("serviceName like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("serviceName not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("serviceName in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("serviceName not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("serviceName between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("serviceName not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameIsNull() {
            addCriterion("jenkinsJobName is null");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameIsNotNull() {
            addCriterion("jenkinsJobName is not null");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameEqualTo(String value) {
            addCriterion("jenkinsJobName =", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameNotEqualTo(String value) {
            addCriterion("jenkinsJobName <>", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameGreaterThan(String value) {
            addCriterion("jenkinsJobName >", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("jenkinsJobName >=", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameLessThan(String value) {
            addCriterion("jenkinsJobName <", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameLessThanOrEqualTo(String value) {
            addCriterion("jenkinsJobName <=", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameLike(String value) {
            addCriterion("jenkinsJobName like", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameNotLike(String value) {
            addCriterion("jenkinsJobName not like", value, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameIn(List<String> values) {
            addCriterion("jenkinsJobName in", values, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameNotIn(List<String> values) {
            addCriterion("jenkinsJobName not in", values, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameBetween(String value1, String value2) {
            addCriterion("jenkinsJobName between", value1, value2, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andJenkinsJobNameNotBetween(String value1, String value2) {
            addCriterion("jenkinsJobName not between", value1, value2, "jenkinsJobName");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeIsNull() {
            addCriterion("serviceDescribe is null");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeIsNotNull() {
            addCriterion("serviceDescribe is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeEqualTo(String value) {
            addCriterion("serviceDescribe =", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeNotEqualTo(String value) {
            addCriterion("serviceDescribe <>", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeGreaterThan(String value) {
            addCriterion("serviceDescribe >", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("serviceDescribe >=", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeLessThan(String value) {
            addCriterion("serviceDescribe <", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeLessThanOrEqualTo(String value) {
            addCriterion("serviceDescribe <=", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeLike(String value) {
            addCriterion("serviceDescribe like", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeNotLike(String value) {
            addCriterion("serviceDescribe not like", value, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeIn(List<String> values) {
            addCriterion("serviceDescribe in", values, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeNotIn(List<String> values) {
            addCriterion("serviceDescribe not in", values, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeBetween(String value1, String value2) {
            addCriterion("serviceDescribe between", value1, value2, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andServiceDescribeNotBetween(String value1, String value2) {
            addCriterion("serviceDescribe not between", value1, value2, "serviceDescribe");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNull() {
            addCriterion("business is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNotNull() {
            addCriterion("business is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEqualTo(String value) {
            addCriterion("business =", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotEqualTo(String value) {
            addCriterion("business <>", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThan(String value) {
            addCriterion("business >", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("business >=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThan(String value) {
            addCriterion("business <", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThanOrEqualTo(String value) {
            addCriterion("business <=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLike(String value) {
            addCriterion("business like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotLike(String value) {
            addCriterion("business not like", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessIn(List<String> values) {
            addCriterion("business in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotIn(List<String> values) {
            addCriterion("business not in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessBetween(String value1, String value2) {
            addCriterion("business between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotBetween(String value1, String value2) {
            addCriterion("business not between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusIsNull() {
            addCriterion("jenkinsStatus is null");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusIsNotNull() {
            addCriterion("jenkinsStatus is not null");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusEqualTo(Boolean value) {
            addCriterion("jenkinsStatus =", value, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusNotEqualTo(Boolean value) {
            addCriterion("jenkinsStatus <>", value, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusGreaterThan(Boolean value) {
            addCriterion("jenkinsStatus >", value, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("jenkinsStatus >=", value, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusLessThan(Boolean value) {
            addCriterion("jenkinsStatus <", value, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("jenkinsStatus <=", value, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusIn(List<Boolean> values) {
            addCriterion("jenkinsStatus in", values, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusNotIn(List<Boolean> values) {
            addCriterion("jenkinsStatus not in", values, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("jenkinsStatus between", value1, value2, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andJenkinsStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("jenkinsStatus not between", value1, value2, "jenkinsStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusIsNull() {
            addCriterion("apmStatus is null");
            return (Criteria) this;
        }

        public Criteria andApmStatusIsNotNull() {
            addCriterion("apmStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApmStatusEqualTo(Boolean value) {
            addCriterion("apmStatus =", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusNotEqualTo(Boolean value) {
            addCriterion("apmStatus <>", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusGreaterThan(Boolean value) {
            addCriterion("apmStatus >", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("apmStatus >=", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusLessThan(Boolean value) {
            addCriterion("apmStatus <", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("apmStatus <=", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusIn(List<Boolean> values) {
            addCriterion("apmStatus in", values, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusNotIn(List<Boolean> values) {
            addCriterion("apmStatus not in", values, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("apmStatus between", value1, value2, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("apmStatus not between", value1, value2, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusIsNull() {
            addCriterion("k8sStatus is null");
            return (Criteria) this;
        }

        public Criteria andK8sStatusIsNotNull() {
            addCriterion("k8sStatus is not null");
            return (Criteria) this;
        }

        public Criteria andK8sStatusEqualTo(Boolean value) {
            addCriterion("k8sStatus =", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusNotEqualTo(Boolean value) {
            addCriterion("k8sStatus <>", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusGreaterThan(Boolean value) {
            addCriterion("k8sStatus >", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("k8sStatus >=", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusLessThan(Boolean value) {
            addCriterion("k8sStatus <", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("k8sStatus <=", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusIn(List<Boolean> values) {
            addCriterion("k8sStatus in", values, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusNotIn(List<Boolean> values) {
            addCriterion("k8sStatus not in", values, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("k8sStatus between", value1, value2, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("k8sStatus not between", value1, value2, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andNeedDeployIsNull() {
            addCriterion("needDeploy is null");
            return (Criteria) this;
        }

        public Criteria andNeedDeployIsNotNull() {
            addCriterion("needDeploy is not null");
            return (Criteria) this;
        }

        public Criteria andNeedDeployEqualTo(Boolean value) {
            addCriterion("needDeploy =", value, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployNotEqualTo(Boolean value) {
            addCriterion("needDeploy <>", value, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployGreaterThan(Boolean value) {
            addCriterion("needDeploy >", value, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployGreaterThanOrEqualTo(Boolean value) {
            addCriterion("needDeploy >=", value, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployLessThan(Boolean value) {
            addCriterion("needDeploy <", value, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployLessThanOrEqualTo(Boolean value) {
            addCriterion("needDeploy <=", value, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployIn(List<Boolean> values) {
            addCriterion("needDeploy in", values, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployNotIn(List<Boolean> values) {
            addCriterion("needDeploy not in", values, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployBetween(Boolean value1, Boolean value2) {
            addCriterion("needDeploy between", value1, value2, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andNeedDeployNotBetween(Boolean value1, Boolean value2) {
            addCriterion("needDeploy not between", value1, value2, "needDeploy");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeIsNull() {
            addCriterion("apmuUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeIsNotNull() {
            addCriterion("apmuUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeEqualTo(Date value) {
            addCriterion("apmuUpdateTime =", value, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeNotEqualTo(Date value) {
            addCriterion("apmuUpdateTime <>", value, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeGreaterThan(Date value) {
            addCriterion("apmuUpdateTime >", value, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apmuUpdateTime >=", value, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeLessThan(Date value) {
            addCriterion("apmuUpdateTime <", value, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("apmuUpdateTime <=", value, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeIn(List<Date> values) {
            addCriterion("apmuUpdateTime in", values, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeNotIn(List<Date> values) {
            addCriterion("apmuUpdateTime not in", values, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("apmuUpdateTime between", value1, value2, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmuUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("apmuUpdateTime not between", value1, value2, "apmuUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeIsNull() {
            addCriterion("jenkinsUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeIsNotNull() {
            addCriterion("jenkinsUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeEqualTo(Date value) {
            addCriterion("jenkinsUpdateTime =", value, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeNotEqualTo(Date value) {
            addCriterion("jenkinsUpdateTime <>", value, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeGreaterThan(Date value) {
            addCriterion("jenkinsUpdateTime >", value, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("jenkinsUpdateTime >=", value, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeLessThan(Date value) {
            addCriterion("jenkinsUpdateTime <", value, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("jenkinsUpdateTime <=", value, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeIn(List<Date> values) {
            addCriterion("jenkinsUpdateTime in", values, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeNotIn(List<Date> values) {
            addCriterion("jenkinsUpdateTime not in", values, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("jenkinsUpdateTime between", value1, value2, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andJenkinsUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("jenkinsUpdateTime not between", value1, value2, "jenkinsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeIsNull() {
            addCriterion("k8sUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeIsNotNull() {
            addCriterion("k8sUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeEqualTo(Date value) {
            addCriterion("k8sUpdateTime =", value, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeNotEqualTo(Date value) {
            addCriterion("k8sUpdateTime <>", value, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeGreaterThan(Date value) {
            addCriterion("k8sUpdateTime >", value, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("k8sUpdateTime >=", value, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeLessThan(Date value) {
            addCriterion("k8sUpdateTime <", value, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("k8sUpdateTime <=", value, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeIn(List<Date> values) {
            addCriterion("k8sUpdateTime in", values, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeNotIn(List<Date> values) {
            addCriterion("k8sUpdateTime not in", values, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("k8sUpdateTime between", value1, value2, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andK8sUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("k8sUpdateTime not between", value1, value2, "k8sUpdateTime");
            return (Criteria) this;
        }

        public Criteria andApmAgentIsNull() {
            addCriterion("apmAgent is null");
            return (Criteria) this;
        }

        public Criteria andApmAgentIsNotNull() {
            addCriterion("apmAgent is not null");
            return (Criteria) this;
        }

        public Criteria andApmAgentEqualTo(String value) {
            addCriterion("apmAgent =", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentNotEqualTo(String value) {
            addCriterion("apmAgent <>", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentGreaterThan(String value) {
            addCriterion("apmAgent >", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentGreaterThanOrEqualTo(String value) {
            addCriterion("apmAgent >=", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentLessThan(String value) {
            addCriterion("apmAgent <", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentLessThanOrEqualTo(String value) {
            addCriterion("apmAgent <=", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentLike(String value) {
            addCriterion("apmAgent like", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentNotLike(String value) {
            addCriterion("apmAgent not like", value, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentIn(List<String> values) {
            addCriterion("apmAgent in", values, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentNotIn(List<String> values) {
            addCriterion("apmAgent not in", values, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentBetween(String value1, String value2) {
            addCriterion("apmAgent between", value1, value2, "apmAgent");
            return (Criteria) this;
        }

        public Criteria andApmAgentNotBetween(String value1, String value2) {
            addCriterion("apmAgent not between", value1, value2, "apmAgent");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}