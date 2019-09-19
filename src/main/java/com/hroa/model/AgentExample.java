package com.hroa.model;

import java.util.ArrayList;
import java.util.List;

public class AgentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andIdcardNumIsNull() {
            addCriterion("idCard_num is null");
            return (Criteria) this;
        }

        public Criteria andIdcardNumIsNotNull() {
            addCriterion("idCard_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardNumEqualTo(String value) {
            addCriterion("idCard_num =", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotEqualTo(String value) {
            addCriterion("idCard_num <>", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumGreaterThan(String value) {
            addCriterion("idCard_num >", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumGreaterThanOrEqualTo(String value) {
            addCriterion("idCard_num >=", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumLessThan(String value) {
            addCriterion("idCard_num <", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumLessThanOrEqualTo(String value) {
            addCriterion("idCard_num <=", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumLike(String value) {
            addCriterion("idCard_num like", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotLike(String value) {
            addCriterion("idCard_num not like", value, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumIn(List<String> values) {
            addCriterion("idCard_num in", values, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotIn(List<String> values) {
            addCriterion("idCard_num not in", values, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumBetween(String value1, String value2) {
            addCriterion("idCard_num between", value1, value2, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardNumNotBetween(String value1, String value2) {
            addCriterion("idCard_num not between", value1, value2, "idcardNum");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontIsNull() {
            addCriterion("idCard_front is null");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontIsNotNull() {
            addCriterion("idCard_front is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontEqualTo(String value) {
            addCriterion("idCard_front =", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontNotEqualTo(String value) {
            addCriterion("idCard_front <>", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontGreaterThan(String value) {
            addCriterion("idCard_front >", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontGreaterThanOrEqualTo(String value) {
            addCriterion("idCard_front >=", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontLessThan(String value) {
            addCriterion("idCard_front <", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontLessThanOrEqualTo(String value) {
            addCriterion("idCard_front <=", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontLike(String value) {
            addCriterion("idCard_front like", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontNotLike(String value) {
            addCriterion("idCard_front not like", value, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontIn(List<String> values) {
            addCriterion("idCard_front in", values, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontNotIn(List<String> values) {
            addCriterion("idCard_front not in", values, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontBetween(String value1, String value2) {
            addCriterion("idCard_front between", value1, value2, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardFrontNotBetween(String value1, String value2) {
            addCriterion("idCard_front not between", value1, value2, "idcardFront");
            return (Criteria) this;
        }

        public Criteria andIdcardBackIsNull() {
            addCriterion("idCard_back is null");
            return (Criteria) this;
        }

        public Criteria andIdcardBackIsNotNull() {
            addCriterion("idCard_back is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardBackEqualTo(String value) {
            addCriterion("idCard_back =", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackNotEqualTo(String value) {
            addCriterion("idCard_back <>", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackGreaterThan(String value) {
            addCriterion("idCard_back >", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackGreaterThanOrEqualTo(String value) {
            addCriterion("idCard_back >=", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackLessThan(String value) {
            addCriterion("idCard_back <", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackLessThanOrEqualTo(String value) {
            addCriterion("idCard_back <=", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackLike(String value) {
            addCriterion("idCard_back like", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackNotLike(String value) {
            addCriterion("idCard_back not like", value, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackIn(List<String> values) {
            addCriterion("idCard_back in", values, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackNotIn(List<String> values) {
            addCriterion("idCard_back not in", values, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackBetween(String value1, String value2) {
            addCriterion("idCard_back between", value1, value2, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andIdcardBackNotBetween(String value1, String value2) {
            addCriterion("idCard_back not between", value1, value2, "idcardBack");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIsNull() {
            addCriterion("apply_province is null");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIsNotNull() {
            addCriterion("apply_province is not null");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceEqualTo(String value) {
            addCriterion("apply_province =", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotEqualTo(String value) {
            addCriterion("apply_province <>", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceGreaterThan(String value) {
            addCriterion("apply_province >", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("apply_province >=", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLessThan(String value) {
            addCriterion("apply_province <", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLessThanOrEqualTo(String value) {
            addCriterion("apply_province <=", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceLike(String value) {
            addCriterion("apply_province like", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotLike(String value) {
            addCriterion("apply_province not like", value, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceIn(List<String> values) {
            addCriterion("apply_province in", values, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotIn(List<String> values) {
            addCriterion("apply_province not in", values, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceBetween(String value1, String value2) {
            addCriterion("apply_province between", value1, value2, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyProvinceNotBetween(String value1, String value2) {
            addCriterion("apply_province not between", value1, value2, "applyProvince");
            return (Criteria) this;
        }

        public Criteria andApplyCityIsNull() {
            addCriterion("apply_city is null");
            return (Criteria) this;
        }

        public Criteria andApplyCityIsNotNull() {
            addCriterion("apply_city is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCityEqualTo(String value) {
            addCriterion("apply_city =", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotEqualTo(String value) {
            addCriterion("apply_city <>", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityGreaterThan(String value) {
            addCriterion("apply_city >", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityGreaterThanOrEqualTo(String value) {
            addCriterion("apply_city >=", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLessThan(String value) {
            addCriterion("apply_city <", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLessThanOrEqualTo(String value) {
            addCriterion("apply_city <=", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityLike(String value) {
            addCriterion("apply_city like", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotLike(String value) {
            addCriterion("apply_city not like", value, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityIn(List<String> values) {
            addCriterion("apply_city in", values, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotIn(List<String> values) {
            addCriterion("apply_city not in", values, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityBetween(String value1, String value2) {
            addCriterion("apply_city between", value1, value2, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyCityNotBetween(String value1, String value2) {
            addCriterion("apply_city not between", value1, value2, "applyCity");
            return (Criteria) this;
        }

        public Criteria andApplyRegionIsNull() {
            addCriterion("apply_region is null");
            return (Criteria) this;
        }

        public Criteria andApplyRegionIsNotNull() {
            addCriterion("apply_region is not null");
            return (Criteria) this;
        }

        public Criteria andApplyRegionEqualTo(String value) {
            addCriterion("apply_region =", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionNotEqualTo(String value) {
            addCriterion("apply_region <>", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionGreaterThan(String value) {
            addCriterion("apply_region >", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionGreaterThanOrEqualTo(String value) {
            addCriterion("apply_region >=", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionLessThan(String value) {
            addCriterion("apply_region <", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionLessThanOrEqualTo(String value) {
            addCriterion("apply_region <=", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionLike(String value) {
            addCriterion("apply_region like", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionNotLike(String value) {
            addCriterion("apply_region not like", value, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionIn(List<String> values) {
            addCriterion("apply_region in", values, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionNotIn(List<String> values) {
            addCriterion("apply_region not in", values, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionBetween(String value1, String value2) {
            addCriterion("apply_region between", value1, value2, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andApplyRegionNotBetween(String value1, String value2) {
            addCriterion("apply_region not between", value1, value2, "applyRegion");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNull() {
            addCriterion("qrCode is null");
            return (Criteria) this;
        }

        public Criteria andQrcodeIsNotNull() {
            addCriterion("qrCode is not null");
            return (Criteria) this;
        }

        public Criteria andQrcodeEqualTo(String value) {
            addCriterion("qrCode =", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotEqualTo(String value) {
            addCriterion("qrCode <>", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThan(String value) {
            addCriterion("qrCode >", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("qrCode >=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThan(String value) {
            addCriterion("qrCode <", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLessThanOrEqualTo(String value) {
            addCriterion("qrCode <=", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeLike(String value) {
            addCriterion("qrCode like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotLike(String value) {
            addCriterion("qrCode not like", value, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeIn(List<String> values) {
            addCriterion("qrCode in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotIn(List<String> values) {
            addCriterion("qrCode not in", values, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeBetween(String value1, String value2) {
            addCriterion("qrCode between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andQrcodeNotBetween(String value1, String value2) {
            addCriterion("qrCode not between", value1, value2, "qrcode");
            return (Criteria) this;
        }

        public Criteria andFailureInfoIsNull() {
            addCriterion("failure_info is null");
            return (Criteria) this;
        }

        public Criteria andFailureInfoIsNotNull() {
            addCriterion("failure_info is not null");
            return (Criteria) this;
        }

        public Criteria andFailureInfoEqualTo(String value) {
            addCriterion("failure_info =", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoNotEqualTo(String value) {
            addCriterion("failure_info <>", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoGreaterThan(String value) {
            addCriterion("failure_info >", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoGreaterThanOrEqualTo(String value) {
            addCriterion("failure_info >=", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoLessThan(String value) {
            addCriterion("failure_info <", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoLessThanOrEqualTo(String value) {
            addCriterion("failure_info <=", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoLike(String value) {
            addCriterion("failure_info like", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoNotLike(String value) {
            addCriterion("failure_info not like", value, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoIn(List<String> values) {
            addCriterion("failure_info in", values, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoNotIn(List<String> values) {
            addCriterion("failure_info not in", values, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoBetween(String value1, String value2) {
            addCriterion("failure_info between", value1, value2, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andFailureInfoNotBetween(String value1, String value2) {
            addCriterion("failure_info not between", value1, value2, "failureInfo");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNull() {
            addCriterion("apply_status is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(Integer value) {
            addCriterion("apply_status =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(Integer value) {
            addCriterion("apply_status <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(Integer value) {
            addCriterion("apply_status >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_status >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(Integer value) {
            addCriterion("apply_status <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("apply_status <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<Integer> values) {
            addCriterion("apply_status in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<Integer> values) {
            addCriterion("apply_status not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(Integer value1, Integer value2) {
            addCriterion("apply_status between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_status not between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andManagerIsNull() {
            addCriterion("manager is null");
            return (Criteria) this;
        }

        public Criteria andManagerIsNotNull() {
            addCriterion("manager is not null");
            return (Criteria) this;
        }

        public Criteria andManagerEqualTo(String value) {
            addCriterion("manager =", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotEqualTo(String value) {
            addCriterion("manager <>", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThan(String value) {
            addCriterion("manager >", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerGreaterThanOrEqualTo(String value) {
            addCriterion("manager >=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThan(String value) {
            addCriterion("manager <", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLessThanOrEqualTo(String value) {
            addCriterion("manager <=", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerLike(String value) {
            addCriterion("manager like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotLike(String value) {
            addCriterion("manager not like", value, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerIn(List<String> values) {
            addCriterion("manager in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotIn(List<String> values) {
            addCriterion("manager not in", values, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerBetween(String value1, String value2) {
            addCriterion("manager between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerNotBetween(String value1, String value2) {
            addCriterion("manager not between", value1, value2, "manager");
            return (Criteria) this;
        }

        public Criteria andManagerTelIsNull() {
            addCriterion("manager_tel is null");
            return (Criteria) this;
        }

        public Criteria andManagerTelIsNotNull() {
            addCriterion("manager_tel is not null");
            return (Criteria) this;
        }

        public Criteria andManagerTelEqualTo(String value) {
            addCriterion("manager_tel =", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotEqualTo(String value) {
            addCriterion("manager_tel <>", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelGreaterThan(String value) {
            addCriterion("manager_tel >", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelGreaterThanOrEqualTo(String value) {
            addCriterion("manager_tel >=", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelLessThan(String value) {
            addCriterion("manager_tel <", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelLessThanOrEqualTo(String value) {
            addCriterion("manager_tel <=", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelLike(String value) {
            addCriterion("manager_tel like", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotLike(String value) {
            addCriterion("manager_tel not like", value, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelIn(List<String> values) {
            addCriterion("manager_tel in", values, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotIn(List<String> values) {
            addCriterion("manager_tel not in", values, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelBetween(String value1, String value2) {
            addCriterion("manager_tel between", value1, value2, "managerTel");
            return (Criteria) this;
        }

        public Criteria andManagerTelNotBetween(String value1, String value2) {
            addCriterion("manager_tel not between", value1, value2, "managerTel");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNull() {
            addCriterion("agent_type is null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNotNull() {
            addCriterion("agent_type is not null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeEqualTo(String value) {
            addCriterion("agent_type =", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotEqualTo(String value) {
            addCriterion("agent_type <>", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThan(String value) {
            addCriterion("agent_type >", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_type >=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThan(String value) {
            addCriterion("agent_type <", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThanOrEqualTo(String value) {
            addCriterion("agent_type <=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLike(String value) {
            addCriterion("agent_type like", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotLike(String value) {
            addCriterion("agent_type not like", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIn(List<String> values) {
            addCriterion("agent_type in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotIn(List<String> values) {
            addCriterion("agent_type not in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeBetween(String value1, String value2) {
            addCriterion("agent_type between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotBetween(String value1, String value2) {
            addCriterion("agent_type not between", value1, value2, "agentType");
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