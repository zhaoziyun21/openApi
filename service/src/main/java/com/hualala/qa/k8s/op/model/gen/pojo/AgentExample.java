package com.hualala.qa.k8s.op.model.gen.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andApp_idIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andApp_idIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andApp_idEqualTo(Long value) {
            addCriterion("app_id =", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idNotEqualTo(Long value) {
            addCriterion("app_id <>", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idGreaterThan(Long value) {
            addCriterion("app_id >", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idGreaterThanOrEqualTo(Long value) {
            addCriterion("app_id >=", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idLessThan(Long value) {
            addCriterion("app_id <", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idLessThanOrEqualTo(Long value) {
            addCriterion("app_id <=", value, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idIn(List<Long> values) {
            addCriterion("app_id in", values, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idNotIn(List<Long> values) {
            addCriterion("app_id not in", values, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idBetween(Long value1, Long value2) {
            addCriterion("app_id between", value1, value2, "app_id");
            return (Criteria) this;
        }

        public Criteria andApp_idNotBetween(Long value1, Long value2) {
            addCriterion("app_id not between", value1, value2, "app_id");
            return (Criteria) this;
        }

        public Criteria andTier_idIsNull() {
            addCriterion("tier_id is null");
            return (Criteria) this;
        }

        public Criteria andTier_idIsNotNull() {
            addCriterion("tier_id is not null");
            return (Criteria) this;
        }

        public Criteria andTier_idEqualTo(Long value) {
            addCriterion("tier_id =", value, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idNotEqualTo(Long value) {
            addCriterion("tier_id <>", value, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idGreaterThan(Long value) {
            addCriterion("tier_id >", value, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idGreaterThanOrEqualTo(Long value) {
            addCriterion("tier_id >=", value, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idLessThan(Long value) {
            addCriterion("tier_id <", value, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idLessThanOrEqualTo(Long value) {
            addCriterion("tier_id <=", value, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idIn(List<Long> values) {
            addCriterion("tier_id in", values, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idNotIn(List<Long> values) {
            addCriterion("tier_id not in", values, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idBetween(Long value1, Long value2) {
            addCriterion("tier_id between", value1, value2, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTier_idNotBetween(Long value1, Long value2) {
            addCriterion("tier_id not between", value1, value2, "tier_id");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andConfig_versionIsNull() {
            addCriterion("config_version is null");
            return (Criteria) this;
        }

        public Criteria andConfig_versionIsNotNull() {
            addCriterion("config_version is not null");
            return (Criteria) this;
        }

        public Criteria andConfig_versionEqualTo(Integer value) {
            addCriterion("config_version =", value, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionNotEqualTo(Integer value) {
            addCriterion("config_version <>", value, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionGreaterThan(Integer value) {
            addCriterion("config_version >", value, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionGreaterThanOrEqualTo(Integer value) {
            addCriterion("config_version >=", value, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionLessThan(Integer value) {
            addCriterion("config_version <", value, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionLessThanOrEqualTo(Integer value) {
            addCriterion("config_version <=", value, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionIn(List<Integer> values) {
            addCriterion("config_version in", values, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionNotIn(List<Integer> values) {
            addCriterion("config_version not in", values, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionBetween(Integer value1, Integer value2) {
            addCriterion("config_version between", value1, value2, "config_version");
            return (Criteria) this;
        }

        public Criteria andConfig_versionNotBetween(Integer value1, Integer value2) {
            addCriterion("config_version not between", value1, value2, "config_version");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintIsNull() {
            addCriterion("agent_fingerprint is null");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintIsNotNull() {
            addCriterion("agent_fingerprint is not null");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintEqualTo(String value) {
            addCriterion("agent_fingerprint =", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintNotEqualTo(String value) {
            addCriterion("agent_fingerprint <>", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintGreaterThan(String value) {
            addCriterion("agent_fingerprint >", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintGreaterThanOrEqualTo(String value) {
            addCriterion("agent_fingerprint >=", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintLessThan(String value) {
            addCriterion("agent_fingerprint <", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintLessThanOrEqualTo(String value) {
            addCriterion("agent_fingerprint <=", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintLike(String value) {
            addCriterion("agent_fingerprint like", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintNotLike(String value) {
            addCriterion("agent_fingerprint not like", value, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintIn(List<String> values) {
            addCriterion("agent_fingerprint in", values, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintNotIn(List<String> values) {
            addCriterion("agent_fingerprint not in", values, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintBetween(String value1, String value2) {
            addCriterion("agent_fingerprint between", value1, value2, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andAgent_fingerprintNotBetween(String value1, String value2) {
            addCriterion("agent_fingerprint not between", value1, value2, "agent_fingerprint");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeIsNull() {
            addCriterion("last_health_check_time is null");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeIsNotNull() {
            addCriterion("last_health_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeEqualTo(Date value) {
            addCriterion("last_health_check_time =", value, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeNotEqualTo(Date value) {
            addCriterion("last_health_check_time <>", value, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeGreaterThan(Date value) {
            addCriterion("last_health_check_time >", value, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_health_check_time >=", value, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeLessThan(Date value) {
            addCriterion("last_health_check_time <", value, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeLessThanOrEqualTo(Date value) {
            addCriterion("last_health_check_time <=", value, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeIn(List<Date> values) {
            addCriterion("last_health_check_time in", values, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeNotIn(List<Date> values) {
            addCriterion("last_health_check_time not in", values, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeBetween(Date value1, Date value2) {
            addCriterion("last_health_check_time between", value1, value2, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andLast_health_check_timeNotBetween(Date value1, Date value2) {
            addCriterion("last_health_check_time not between", value1, value2, "last_health_check_time");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Byte value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Byte value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Byte value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Byte value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Byte> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Byte> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Byte value1, Byte value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andIs_visibleIsNull() {
            addCriterion("is_visible is null");
            return (Criteria) this;
        }

        public Criteria andIs_visibleIsNotNull() {
            addCriterion("is_visible is not null");
            return (Criteria) this;
        }

        public Criteria andIs_visibleEqualTo(Byte value) {
            addCriterion("is_visible =", value, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleNotEqualTo(Byte value) {
            addCriterion("is_visible <>", value, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleGreaterThan(Byte value) {
            addCriterion("is_visible >", value, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_visible >=", value, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleLessThan(Byte value) {
            addCriterion("is_visible <", value, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleLessThanOrEqualTo(Byte value) {
            addCriterion("is_visible <=", value, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleIn(List<Byte> values) {
            addCriterion("is_visible in", values, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleNotIn(List<Byte> values) {
            addCriterion("is_visible not in", values, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleBetween(Byte value1, Byte value2) {
            addCriterion("is_visible between", value1, value2, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_visibleNotBetween(Byte value1, Byte value2) {
            addCriterion("is_visible not between", value1, value2, "is_visible");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameIsNull() {
            addCriterion("original_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameIsNotNull() {
            addCriterion("original_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameEqualTo(String value) {
            addCriterion("original_name =", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameNotEqualTo(String value) {
            addCriterion("original_name <>", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameGreaterThan(String value) {
            addCriterion("original_name >", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameGreaterThanOrEqualTo(String value) {
            addCriterion("original_name >=", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameLessThan(String value) {
            addCriterion("original_name <", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameLessThanOrEqualTo(String value) {
            addCriterion("original_name <=", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameLike(String value) {
            addCriterion("original_name like", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameNotLike(String value) {
            addCriterion("original_name not like", value, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameIn(List<String> values) {
            addCriterion("original_name in", values, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameNotIn(List<String> values) {
            addCriterion("original_name not in", values, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameBetween(String value1, String value2) {
            addCriterion("original_name between", value1, value2, "original_name");
            return (Criteria) this;
        }

        public Criteria andOriginal_nameNotBetween(String value1, String value2) {
            addCriterion("original_name not between", value1, value2, "original_name");
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