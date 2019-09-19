package com.hroa.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JobRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public JobRecordExample() {
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

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andIcnoIsNull() {
            addCriterion("icno is null");
            return (Criteria) this;
        }

        public Criteria andIcnoIsNotNull() {
            addCriterion("icno is not null");
            return (Criteria) this;
        }

        public Criteria andIcnoEqualTo(String value) {
            addCriterion("icno =", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoNotEqualTo(String value) {
            addCriterion("icno <>", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoGreaterThan(String value) {
            addCriterion("icno >", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoGreaterThanOrEqualTo(String value) {
            addCriterion("icno >=", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoLessThan(String value) {
            addCriterion("icno <", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoLessThanOrEqualTo(String value) {
            addCriterion("icno <=", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoLike(String value) {
            addCriterion("icno like", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoNotLike(String value) {
            addCriterion("icno not like", value, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoIn(List<String> values) {
            addCriterion("icno in", values, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoNotIn(List<String> values) {
            addCriterion("icno not in", values, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoBetween(String value1, String value2) {
            addCriterion("icno between", value1, value2, "icno");
            return (Criteria) this;
        }

        public Criteria andIcnoNotBetween(String value1, String value2) {
            addCriterion("icno not between", value1, value2, "icno");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(String value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(String value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(String value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(String value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(String value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(String value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLike(String value) {
            addCriterion("label like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotLike(String value) {
            addCriterion("label not like", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<String> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<String> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(String value1, String value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(String value1, String value2) {
            addCriterion("label not between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLinkManIsNull() {
            addCriterion("link_man is null");
            return (Criteria) this;
        }

        public Criteria andLinkManIsNotNull() {
            addCriterion("link_man is not null");
            return (Criteria) this;
        }

        public Criteria andLinkManEqualTo(String value) {
            addCriterion("link_man =", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotEqualTo(String value) {
            addCriterion("link_man <>", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManGreaterThan(String value) {
            addCriterion("link_man >", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManGreaterThanOrEqualTo(String value) {
            addCriterion("link_man >=", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLessThan(String value) {
            addCriterion("link_man <", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLessThanOrEqualTo(String value) {
            addCriterion("link_man <=", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManLike(String value) {
            addCriterion("link_man like", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotLike(String value) {
            addCriterion("link_man not like", value, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManIn(List<String> values) {
            addCriterion("link_man in", values, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotIn(List<String> values) {
            addCriterion("link_man not in", values, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManBetween(String value1, String value2) {
            addCriterion("link_man between", value1, value2, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkManNotBetween(String value1, String value2) {
            addCriterion("link_man not between", value1, value2, "linkMan");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNull() {
            addCriterion("link_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNotNull() {
            addCriterion("link_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneEqualTo(String value) {
            addCriterion("link_phone =", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotEqualTo(String value) {
            addCriterion("link_phone <>", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThan(String value) {
            addCriterion("link_phone >", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("link_phone >=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThan(String value) {
            addCriterion("link_phone <", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("link_phone <=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLike(String value) {
            addCriterion("link_phone like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotLike(String value) {
            addCriterion("link_phone not like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIn(List<String> values) {
            addCriterion("link_phone in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotIn(List<String> values) {
            addCriterion("link_phone not in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneBetween(String value1, String value2) {
            addCriterion("link_phone between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("link_phone not between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNull() {
            addCriterion("registerdate is null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNotNull() {
            addCriterion("registerdate is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateEqualTo(String value) {
            addCriterion("registerdate =", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotEqualTo(String value) {
            addCriterion("registerdate <>", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThan(String value) {
            addCriterion("registerdate >", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThanOrEqualTo(String value) {
            addCriterion("registerdate >=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThan(String value) {
            addCriterion("registerdate <", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThanOrEqualTo(String value) {
            addCriterion("registerdate <=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLike(String value) {
            addCriterion("registerdate like", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotLike(String value) {
            addCriterion("registerdate not like", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIn(List<String> values) {
            addCriterion("registerdate in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotIn(List<String> values) {
            addCriterion("registerdate not in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateBetween(String value1, String value2) {
            addCriterion("registerdate between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotBetween(String value1, String value2) {
            addCriterion("registerdate not between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("scale is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("scale is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(String value) {
            addCriterion("scale =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(String value) {
            addCriterion("scale <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(String value) {
            addCriterion("scale >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(String value) {
            addCriterion("scale >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(String value) {
            addCriterion("scale <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(String value) {
            addCriterion("scale <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLike(String value) {
            addCriterion("scale like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotLike(String value) {
            addCriterion("scale not like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<String> values) {
            addCriterion("scale in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<String> values) {
            addCriterion("scale not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(String value1, String value2) {
            addCriterion("scale between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(String value1, String value2) {
            addCriterion("scale not between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andProduceIsNull() {
            addCriterion("produce is null");
            return (Criteria) this;
        }

        public Criteria andProduceIsNotNull() {
            addCriterion("produce is not null");
            return (Criteria) this;
        }

        public Criteria andProduceEqualTo(String value) {
            addCriterion("produce =", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceNotEqualTo(String value) {
            addCriterion("produce <>", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceGreaterThan(String value) {
            addCriterion("produce >", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceGreaterThanOrEqualTo(String value) {
            addCriterion("produce >=", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceLessThan(String value) {
            addCriterion("produce <", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceLessThanOrEqualTo(String value) {
            addCriterion("produce <=", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceLike(String value) {
            addCriterion("produce like", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceNotLike(String value) {
            addCriterion("produce not like", value, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceIn(List<String> values) {
            addCriterion("produce in", values, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceNotIn(List<String> values) {
            addCriterion("produce not in", values, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceBetween(String value1, String value2) {
            addCriterion("produce between", value1, value2, "produce");
            return (Criteria) this;
        }

        public Criteria andProduceNotBetween(String value1, String value2) {
            addCriterion("produce not between", value1, value2, "produce");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andCoverIsNull() {
            addCriterion("cover is null");
            return (Criteria) this;
        }

        public Criteria andCoverIsNotNull() {
            addCriterion("cover is not null");
            return (Criteria) this;
        }

        public Criteria andCoverEqualTo(String value) {
            addCriterion("cover =", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotEqualTo(String value) {
            addCriterion("cover <>", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThan(String value) {
            addCriterion("cover >", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverGreaterThanOrEqualTo(String value) {
            addCriterion("cover >=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThan(String value) {
            addCriterion("cover <", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLessThanOrEqualTo(String value) {
            addCriterion("cover <=", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverLike(String value) {
            addCriterion("cover like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotLike(String value) {
            addCriterion("cover not like", value, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverIn(List<String> values) {
            addCriterion("cover in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotIn(List<String> values) {
            addCriterion("cover not in", values, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverBetween(String value1, String value2) {
            addCriterion("cover between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andCoverNotBetween(String value1, String value2) {
            addCriterion("cover not between", value1, value2, "cover");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNull() {
            addCriterion("welfare is null");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNotNull() {
            addCriterion("welfare is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareEqualTo(String value) {
            addCriterion("welfare =", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotEqualTo(String value) {
            addCriterion("welfare <>", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThan(String value) {
            addCriterion("welfare >", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThanOrEqualTo(String value) {
            addCriterion("welfare >=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThan(String value) {
            addCriterion("welfare <", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThanOrEqualTo(String value) {
            addCriterion("welfare <=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLike(String value) {
            addCriterion("welfare like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotLike(String value) {
            addCriterion("welfare not like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareIn(List<String> values) {
            addCriterion("welfare in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotIn(List<String> values) {
            addCriterion("welfare not in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareBetween(String value1, String value2) {
            addCriterion("welfare between", value1, value2, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotBetween(String value1, String value2) {
            addCriterion("welfare not between", value1, value2, "welfare");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("required is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("required is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(String value) {
            addCriterion("required =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(String value) {
            addCriterion("required <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(String value) {
            addCriterion("required >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(String value) {
            addCriterion("required >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(String value) {
            addCriterion("required <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(String value) {
            addCriterion("required <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLike(String value) {
            addCriterion("required like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotLike(String value) {
            addCriterion("required not like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<String> values) {
            addCriterion("required in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<String> values) {
            addCriterion("required not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(String value1, String value2) {
            addCriterion("required between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(String value1, String value2) {
            addCriterion("required not between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("salary like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("salary not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryIsNull() {
            addCriterion("more_salary is null");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryIsNotNull() {
            addCriterion("more_salary is not null");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryEqualTo(BigDecimal value) {
            addCriterion("more_salary =", value, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryNotEqualTo(BigDecimal value) {
            addCriterion("more_salary <>", value, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryGreaterThan(BigDecimal value) {
            addCriterion("more_salary >", value, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("more_salary >=", value, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryLessThan(BigDecimal value) {
            addCriterion("more_salary <", value, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("more_salary <=", value, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryIn(List<BigDecimal> values) {
            addCriterion("more_salary in", values, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryNotIn(List<BigDecimal> values) {
            addCriterion("more_salary not in", values, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("more_salary between", value1, value2, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andMoreSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("more_salary not between", value1, value2, "moreSalary");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(Integer value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(Integer value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(Integer value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(Integer value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(Integer value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<Integer> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<Integer> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(Integer value1, Integer value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("unit not between", value1, value2, "unit");
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

        public Criteria andDetailsIsNull() {
            addCriterion("details is null");
            return (Criteria) this;
        }

        public Criteria andDetailsIsNotNull() {
            addCriterion("details is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsEqualTo(String value) {
            addCriterion("details =", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotEqualTo(String value) {
            addCriterion("details <>", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThan(String value) {
            addCriterion("details >", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("details >=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThan(String value) {
            addCriterion("details <", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLessThanOrEqualTo(String value) {
            addCriterion("details <=", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsLike(String value) {
            addCriterion("details like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotLike(String value) {
            addCriterion("details not like", value, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsIn(List<String> values) {
            addCriterion("details in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotIn(List<String> values) {
            addCriterion("details not in", values, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsBetween(String value1, String value2) {
            addCriterion("details between", value1, value2, "details");
            return (Criteria) this;
        }

        public Criteria andDetailsNotBetween(String value1, String value2) {
            addCriterion("details not between", value1, value2, "details");
            return (Criteria) this;
        }

        public Criteria andFactoryManIsNull() {
            addCriterion("factory_man is null");
            return (Criteria) this;
        }

        public Criteria andFactoryManIsNotNull() {
            addCriterion("factory_man is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryManEqualTo(String value) {
            addCriterion("factory_man =", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManNotEqualTo(String value) {
            addCriterion("factory_man <>", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManGreaterThan(String value) {
            addCriterion("factory_man >", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManGreaterThanOrEqualTo(String value) {
            addCriterion("factory_man >=", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManLessThan(String value) {
            addCriterion("factory_man <", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManLessThanOrEqualTo(String value) {
            addCriterion("factory_man <=", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManLike(String value) {
            addCriterion("factory_man like", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManNotLike(String value) {
            addCriterion("factory_man not like", value, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManIn(List<String> values) {
            addCriterion("factory_man in", values, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManNotIn(List<String> values) {
            addCriterion("factory_man not in", values, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManBetween(String value1, String value2) {
            addCriterion("factory_man between", value1, value2, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryManNotBetween(String value1, String value2) {
            addCriterion("factory_man not between", value1, value2, "factoryMan");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneIsNull() {
            addCriterion("factory_phone is null");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneIsNotNull() {
            addCriterion("factory_phone is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneEqualTo(String value) {
            addCriterion("factory_phone =", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneNotEqualTo(String value) {
            addCriterion("factory_phone <>", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneGreaterThan(String value) {
            addCriterion("factory_phone >", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("factory_phone >=", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneLessThan(String value) {
            addCriterion("factory_phone <", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneLessThanOrEqualTo(String value) {
            addCriterion("factory_phone <=", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneLike(String value) {
            addCriterion("factory_phone like", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneNotLike(String value) {
            addCriterion("factory_phone not like", value, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneIn(List<String> values) {
            addCriterion("factory_phone in", values, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneNotIn(List<String> values) {
            addCriterion("factory_phone not in", values, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneBetween(String value1, String value2) {
            addCriterion("factory_phone between", value1, value2, "factoryPhone");
            return (Criteria) this;
        }

        public Criteria andFactoryPhoneNotBetween(String value1, String value2) {
            addCriterion("factory_phone not between", value1, value2, "factoryPhone");
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

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("classify is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("classify is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(String value) {
            addCriterion("classify =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(String value) {
            addCriterion("classify <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(String value) {
            addCriterion("classify >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(String value) {
            addCriterion("classify >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(String value) {
            addCriterion("classify <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(String value) {
            addCriterion("classify <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLike(String value) {
            addCriterion("classify like", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotLike(String value) {
            addCriterion("classify not like", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<String> values) {
            addCriterion("classify in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<String> values) {
            addCriterion("classify not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(String value1, String value2) {
            addCriterion("classify between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(String value1, String value2) {
            addCriterion("classify not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNull() {
            addCriterion("is_finish is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNotNull() {
            addCriterion("is_finish is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishEqualTo(Integer value) {
            addCriterion("is_finish =", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotEqualTo(Integer value) {
            addCriterion("is_finish <>", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThan(Integer value) {
            addCriterion("is_finish >", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_finish >=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThan(Integer value) {
            addCriterion("is_finish <", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThanOrEqualTo(Integer value) {
            addCriterion("is_finish <=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishIn(List<Integer> values) {
            addCriterion("is_finish in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotIn(List<Integer> values) {
            addCriterion("is_finish not in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishBetween(Integer value1, Integer value2) {
            addCriterion("is_finish between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("is_finish not between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andCertificatesIsNull() {
            addCriterion("certificates is null");
            return (Criteria) this;
        }

        public Criteria andCertificatesIsNotNull() {
            addCriterion("certificates is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatesEqualTo(String value) {
            addCriterion("certificates =", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotEqualTo(String value) {
            addCriterion("certificates <>", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesGreaterThan(String value) {
            addCriterion("certificates >", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesGreaterThanOrEqualTo(String value) {
            addCriterion("certificates >=", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesLessThan(String value) {
            addCriterion("certificates <", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesLessThanOrEqualTo(String value) {
            addCriterion("certificates <=", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesLike(String value) {
            addCriterion("certificates like", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotLike(String value) {
            addCriterion("certificates not like", value, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesIn(List<String> values) {
            addCriterion("certificates in", values, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotIn(List<String> values) {
            addCriterion("certificates not in", values, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesBetween(String value1, String value2) {
            addCriterion("certificates between", value1, value2, "certificates");
            return (Criteria) this;
        }

        public Criteria andCertificatesNotBetween(String value1, String value2) {
            addCriterion("certificates not between", value1, value2, "certificates");
            return (Criteria) this;
        }

        public Criteria andMinageIsNull() {
            addCriterion("minage is null");
            return (Criteria) this;
        }

        public Criteria andMinageIsNotNull() {
            addCriterion("minage is not null");
            return (Criteria) this;
        }

        public Criteria andMinageEqualTo(Integer value) {
            addCriterion("minage =", value, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageNotEqualTo(Integer value) {
            addCriterion("minage <>", value, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageGreaterThan(Integer value) {
            addCriterion("minage >", value, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageGreaterThanOrEqualTo(Integer value) {
            addCriterion("minage >=", value, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageLessThan(Integer value) {
            addCriterion("minage <", value, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageLessThanOrEqualTo(Integer value) {
            addCriterion("minage <=", value, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageIn(List<Integer> values) {
            addCriterion("minage in", values, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageNotIn(List<Integer> values) {
            addCriterion("minage not in", values, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageBetween(Integer value1, Integer value2) {
            addCriterion("minage between", value1, value2, "minage");
            return (Criteria) this;
        }

        public Criteria andMinageNotBetween(Integer value1, Integer value2) {
            addCriterion("minage not between", value1, value2, "minage");
            return (Criteria) this;
        }

        public Criteria andMaxageIsNull() {
            addCriterion("maxage is null");
            return (Criteria) this;
        }

        public Criteria andMaxageIsNotNull() {
            addCriterion("maxage is not null");
            return (Criteria) this;
        }

        public Criteria andMaxageEqualTo(Integer value) {
            addCriterion("maxage =", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageNotEqualTo(Integer value) {
            addCriterion("maxage <>", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageGreaterThan(Integer value) {
            addCriterion("maxage >", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxage >=", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageLessThan(Integer value) {
            addCriterion("maxage <", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageLessThanOrEqualTo(Integer value) {
            addCriterion("maxage <=", value, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageIn(List<Integer> values) {
            addCriterion("maxage in", values, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageNotIn(List<Integer> values) {
            addCriterion("maxage not in", values, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageBetween(Integer value1, Integer value2) {
            addCriterion("maxage between", value1, value2, "maxage");
            return (Criteria) this;
        }

        public Criteria andMaxageNotBetween(Integer value1, Integer value2) {
            addCriterion("maxage not between", value1, value2, "maxage");
            return (Criteria) this;
        }

        public Criteria andDevelopManIsNull() {
            addCriterion("develop_man is null");
            return (Criteria) this;
        }

        public Criteria andDevelopManIsNotNull() {
            addCriterion("develop_man is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopManEqualTo(String value) {
            addCriterion("develop_man =", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManNotEqualTo(String value) {
            addCriterion("develop_man <>", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManGreaterThan(String value) {
            addCriterion("develop_man >", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManGreaterThanOrEqualTo(String value) {
            addCriterion("develop_man >=", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManLessThan(String value) {
            addCriterion("develop_man <", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManLessThanOrEqualTo(String value) {
            addCriterion("develop_man <=", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManLike(String value) {
            addCriterion("develop_man like", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManNotLike(String value) {
            addCriterion("develop_man not like", value, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManIn(List<String> values) {
            addCriterion("develop_man in", values, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManNotIn(List<String> values) {
            addCriterion("develop_man not in", values, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManBetween(String value1, String value2) {
            addCriterion("develop_man between", value1, value2, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopManNotBetween(String value1, String value2) {
            addCriterion("develop_man not between", value1, value2, "developMan");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkIsNull() {
            addCriterion("develop_link is null");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkIsNotNull() {
            addCriterion("develop_link is not null");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkEqualTo(String value) {
            addCriterion("develop_link =", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkNotEqualTo(String value) {
            addCriterion("develop_link <>", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkGreaterThan(String value) {
            addCriterion("develop_link >", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkGreaterThanOrEqualTo(String value) {
            addCriterion("develop_link >=", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkLessThan(String value) {
            addCriterion("develop_link <", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkLessThanOrEqualTo(String value) {
            addCriterion("develop_link <=", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkLike(String value) {
            addCriterion("develop_link like", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkNotLike(String value) {
            addCriterion("develop_link not like", value, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkIn(List<String> values) {
            addCriterion("develop_link in", values, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkNotIn(List<String> values) {
            addCriterion("develop_link not in", values, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkBetween(String value1, String value2) {
            addCriterion("develop_link between", value1, value2, "developLink");
            return (Criteria) this;
        }

        public Criteria andDevelopLinkNotBetween(String value1, String value2) {
            addCriterion("develop_link not between", value1, value2, "developLink");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNull() {
            addCriterion("work_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("work_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("work_type =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("work_type <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("work_type >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("work_type >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("work_type <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("work_type <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("work_type like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("work_type not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("work_type in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("work_type not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("work_type between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("work_type not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andLiveIsNull() {
            addCriterion("live is null");
            return (Criteria) this;
        }

        public Criteria andLiveIsNotNull() {
            addCriterion("live is not null");
            return (Criteria) this;
        }

        public Criteria andLiveEqualTo(String value) {
            addCriterion("live =", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveNotEqualTo(String value) {
            addCriterion("live <>", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveGreaterThan(String value) {
            addCriterion("live >", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveGreaterThanOrEqualTo(String value) {
            addCriterion("live >=", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveLessThan(String value) {
            addCriterion("live <", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveLessThanOrEqualTo(String value) {
            addCriterion("live <=", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveLike(String value) {
            addCriterion("live like", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveNotLike(String value) {
            addCriterion("live not like", value, "live");
            return (Criteria) this;
        }

        public Criteria andLiveIn(List<String> values) {
            addCriterion("live in", values, "live");
            return (Criteria) this;
        }

        public Criteria andLiveNotIn(List<String> values) {
            addCriterion("live not in", values, "live");
            return (Criteria) this;
        }

        public Criteria andLiveBetween(String value1, String value2) {
            addCriterion("live between", value1, value2, "live");
            return (Criteria) this;
        }

        public Criteria andLiveNotBetween(String value1, String value2) {
            addCriterion("live not between", value1, value2, "live");
            return (Criteria) this;
        }

        public Criteria andEatTypeIsNull() {
            addCriterion("eat_type is null");
            return (Criteria) this;
        }

        public Criteria andEatTypeIsNotNull() {
            addCriterion("eat_type is not null");
            return (Criteria) this;
        }

        public Criteria andEatTypeEqualTo(String value) {
            addCriterion("eat_type =", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeNotEqualTo(String value) {
            addCriterion("eat_type <>", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeGreaterThan(String value) {
            addCriterion("eat_type >", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeGreaterThanOrEqualTo(String value) {
            addCriterion("eat_type >=", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeLessThan(String value) {
            addCriterion("eat_type <", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeLessThanOrEqualTo(String value) {
            addCriterion("eat_type <=", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeLike(String value) {
            addCriterion("eat_type like", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeNotLike(String value) {
            addCriterion("eat_type not like", value, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeIn(List<String> values) {
            addCriterion("eat_type in", values, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeNotIn(List<String> values) {
            addCriterion("eat_type not in", values, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeBetween(String value1, String value2) {
            addCriterion("eat_type between", value1, value2, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatTypeNotBetween(String value1, String value2) {
            addCriterion("eat_type not between", value1, value2, "eatType");
            return (Criteria) this;
        }

        public Criteria andEatStandardIsNull() {
            addCriterion("eat_standard is null");
            return (Criteria) this;
        }

        public Criteria andEatStandardIsNotNull() {
            addCriterion("eat_standard is not null");
            return (Criteria) this;
        }

        public Criteria andEatStandardEqualTo(String value) {
            addCriterion("eat_standard =", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardNotEqualTo(String value) {
            addCriterion("eat_standard <>", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardGreaterThan(String value) {
            addCriterion("eat_standard >", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardGreaterThanOrEqualTo(String value) {
            addCriterion("eat_standard >=", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardLessThan(String value) {
            addCriterion("eat_standard <", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardLessThanOrEqualTo(String value) {
            addCriterion("eat_standard <=", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardLike(String value) {
            addCriterion("eat_standard like", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardNotLike(String value) {
            addCriterion("eat_standard not like", value, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardIn(List<String> values) {
            addCriterion("eat_standard in", values, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardNotIn(List<String> values) {
            addCriterion("eat_standard not in", values, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardBetween(String value1, String value2) {
            addCriterion("eat_standard between", value1, value2, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andEatStandardNotBetween(String value1, String value2) {
            addCriterion("eat_standard not between", value1, value2, "eatStandard");
            return (Criteria) this;
        }

        public Criteria andClothesTypeIsNull() {
            addCriterion("clothes_type is null");
            return (Criteria) this;
        }

        public Criteria andClothesTypeIsNotNull() {
            addCriterion("clothes_type is not null");
            return (Criteria) this;
        }

        public Criteria andClothesTypeEqualTo(String value) {
            addCriterion("clothes_type =", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeNotEqualTo(String value) {
            addCriterion("clothes_type <>", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeGreaterThan(String value) {
            addCriterion("clothes_type >", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("clothes_type >=", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeLessThan(String value) {
            addCriterion("clothes_type <", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeLessThanOrEqualTo(String value) {
            addCriterion("clothes_type <=", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeLike(String value) {
            addCriterion("clothes_type like", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeNotLike(String value) {
            addCriterion("clothes_type not like", value, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeIn(List<String> values) {
            addCriterion("clothes_type in", values, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeNotIn(List<String> values) {
            addCriterion("clothes_type not in", values, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeBetween(String value1, String value2) {
            addCriterion("clothes_type between", value1, value2, "clothesType");
            return (Criteria) this;
        }

        public Criteria andClothesTypeNotBetween(String value1, String value2) {
            addCriterion("clothes_type not between", value1, value2, "clothesType");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNull() {
            addCriterion("work_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNotNull() {
            addCriterion("work_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEqualTo(String value) {
            addCriterion("work_time =", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotEqualTo(String value) {
            addCriterion("work_time <>", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThan(String value) {
            addCriterion("work_time >", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("work_time >=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThan(String value) {
            addCriterion("work_time <", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("work_time <=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLike(String value) {
            addCriterion("work_time like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotLike(String value) {
            addCriterion("work_time not like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIn(List<String> values) {
            addCriterion("work_time in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotIn(List<String> values) {
            addCriterion("work_time not in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeBetween(String value1, String value2) {
            addCriterion("work_time between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotBetween(String value1, String value2) {
            addCriterion("work_time not between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andEatStandardExIsNull() {
            addCriterion("eat_standard_ex is null");
            return (Criteria) this;
        }

        public Criteria andEatStandardExIsNotNull() {
            addCriterion("eat_standard_ex is not null");
            return (Criteria) this;
        }

        public Criteria andEatStandardExEqualTo(String value) {
            addCriterion("eat_standard_ex =", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExNotEqualTo(String value) {
            addCriterion("eat_standard_ex <>", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExGreaterThan(String value) {
            addCriterion("eat_standard_ex >", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExGreaterThanOrEqualTo(String value) {
            addCriterion("eat_standard_ex >=", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExLessThan(String value) {
            addCriterion("eat_standard_ex <", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExLessThanOrEqualTo(String value) {
            addCriterion("eat_standard_ex <=", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExLike(String value) {
            addCriterion("eat_standard_ex like", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExNotLike(String value) {
            addCriterion("eat_standard_ex not like", value, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExIn(List<String> values) {
            addCriterion("eat_standard_ex in", values, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExNotIn(List<String> values) {
            addCriterion("eat_standard_ex not in", values, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExBetween(String value1, String value2) {
            addCriterion("eat_standard_ex between", value1, value2, "eatStandardEx");
            return (Criteria) this;
        }

        public Criteria andEatStandardExNotBetween(String value1, String value2) {
            addCriterion("eat_standard_ex not between", value1, value2, "eatStandardEx");
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