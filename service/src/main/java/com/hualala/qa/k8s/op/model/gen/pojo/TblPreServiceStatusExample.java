package com.hualala.qa.k8s.op.model.gen.pojo;

import java.util.ArrayList;
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

        public Criteria andApmStatusIsNull() {
            addCriterion("apmStatus is null");
            return (Criteria) this;
        }

        public Criteria andApmStatusIsNotNull() {
            addCriterion("apmStatus is not null");
            return (Criteria) this;
        }

        public Criteria andApmStatusEqualTo(Integer value) {
            addCriterion("apmStatus =", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusNotEqualTo(Integer value) {
            addCriterion("apmStatus <>", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusGreaterThan(Integer value) {
            addCriterion("apmStatus >", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("apmStatus >=", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusLessThan(Integer value) {
            addCriterion("apmStatus <", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusLessThanOrEqualTo(Integer value) {
            addCriterion("apmStatus <=", value, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusIn(List<Integer> values) {
            addCriterion("apmStatus in", values, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusNotIn(List<Integer> values) {
            addCriterion("apmStatus not in", values, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusBetween(Integer value1, Integer value2) {
            addCriterion("apmStatus between", value1, value2, "apmStatus");
            return (Criteria) this;
        }

        public Criteria andApmStatusNotBetween(Integer value1, Integer value2) {
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

        public Criteria andK8sStatusEqualTo(Integer value) {
            addCriterion("k8sStatus =", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusNotEqualTo(Integer value) {
            addCriterion("k8sStatus <>", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusGreaterThan(Integer value) {
            addCriterion("k8sStatus >", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("k8sStatus >=", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusLessThan(Integer value) {
            addCriterion("k8sStatus <", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusLessThanOrEqualTo(Integer value) {
            addCriterion("k8sStatus <=", value, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusIn(List<Integer> values) {
            addCriterion("k8sStatus in", values, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusNotIn(List<Integer> values) {
            addCriterion("k8sStatus not in", values, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusBetween(Integer value1, Integer value2) {
            addCriterion("k8sStatus between", value1, value2, "k8sStatus");
            return (Criteria) this;
        }

        public Criteria andK8sStatusNotBetween(Integer value1, Integer value2) {
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