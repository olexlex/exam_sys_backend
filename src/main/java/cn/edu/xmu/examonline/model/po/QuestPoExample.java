package cn.edu.xmu.examonline.model.po;

import java.util.ArrayList;
import java.util.List;

public class QuestPoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table quest
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table quest
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table quest
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public QuestPoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table quest
     *
     * @mbggenerated
     */
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
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMajorIdIsNull() {
            addCriterion("`major_id` is null");
            return (Criteria) this;
        }

        public Criteria andMajorIdIsNotNull() {
            addCriterion("`major_id` is not null");
            return (Criteria) this;
        }

        public Criteria andMajorIdEqualTo(Integer value) {
            addCriterion("`major_id` =", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotEqualTo(Integer value) {
            addCriterion("`major_id` <>", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThan(Integer value) {
            addCriterion("`major_id` >", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`major_id` >=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThan(Integer value) {
            addCriterion("`major_id` <", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThanOrEqualTo(Integer value) {
            addCriterion("`major_id` <=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdIn(List<Integer> values) {
            addCriterion("`major_id` in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotIn(List<Integer> values) {
            addCriterion("`major_id` not in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdBetween(Integer value1, Integer value2) {
            addCriterion("`major_id` between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`major_id` not between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("`type_id` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("`type_id` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("`type_id` =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("`type_id` <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("`type_id` >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type_id` >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("`type_id` <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("`type_id` <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("`type_id` in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("`type_id` not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("`type_id` between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`type_id` not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("`description` is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("`description` is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("`description` =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("`description` <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("`description` >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("`description` >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("`description` <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("`description` <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("`description` like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("`description` not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("`description` in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("`description` not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("`description` between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("`description` not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("`answer` is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("`answer` is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("`answer` =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("`answer` <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("`answer` >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("`answer` >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("`answer` <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("`answer` <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("`answer` like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("`answer` not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("`answer` in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("`answer` not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("`answer` between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("`answer` not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andSelectionNumIsNull() {
            addCriterion("`selection_num` is null");
            return (Criteria) this;
        }

        public Criteria andSelectionNumIsNotNull() {
            addCriterion("`selection_num` is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionNumEqualTo(Integer value) {
            addCriterion("`selection_num` =", value, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumNotEqualTo(Integer value) {
            addCriterion("`selection_num` <>", value, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumGreaterThan(Integer value) {
            addCriterion("`selection_num` >", value, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("`selection_num` >=", value, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumLessThan(Integer value) {
            addCriterion("`selection_num` <", value, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumLessThanOrEqualTo(Integer value) {
            addCriterion("`selection_num` <=", value, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumIn(List<Integer> values) {
            addCriterion("`selection_num` in", values, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumNotIn(List<Integer> values) {
            addCriterion("`selection_num` not in", values, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumBetween(Integer value1, Integer value2) {
            addCriterion("`selection_num` between", value1, value2, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("`selection_num` not between", value1, value2, "selectionNum");
            return (Criteria) this;
        }

        public Criteria andSelectionAIsNull() {
            addCriterion("`selection_a` is null");
            return (Criteria) this;
        }

        public Criteria andSelectionAIsNotNull() {
            addCriterion("`selection_a` is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionAEqualTo(String value) {
            addCriterion("`selection_a` =", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionANotEqualTo(String value) {
            addCriterion("`selection_a` <>", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionAGreaterThan(String value) {
            addCriterion("`selection_a` >", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionAGreaterThanOrEqualTo(String value) {
            addCriterion("`selection_a` >=", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionALessThan(String value) {
            addCriterion("`selection_a` <", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionALessThanOrEqualTo(String value) {
            addCriterion("`selection_a` <=", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionALike(String value) {
            addCriterion("`selection_a` like", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionANotLike(String value) {
            addCriterion("`selection_a` not like", value, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionAIn(List<String> values) {
            addCriterion("`selection_a` in", values, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionANotIn(List<String> values) {
            addCriterion("`selection_a` not in", values, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionABetween(String value1, String value2) {
            addCriterion("`selection_a` between", value1, value2, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionANotBetween(String value1, String value2) {
            addCriterion("`selection_a` not between", value1, value2, "selectionA");
            return (Criteria) this;
        }

        public Criteria andSelectionBIsNull() {
            addCriterion("`selection_b` is null");
            return (Criteria) this;
        }

        public Criteria andSelectionBIsNotNull() {
            addCriterion("`selection_b` is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionBEqualTo(String value) {
            addCriterion("`selection_b` =", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBNotEqualTo(String value) {
            addCriterion("`selection_b` <>", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBGreaterThan(String value) {
            addCriterion("`selection_b` >", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBGreaterThanOrEqualTo(String value) {
            addCriterion("`selection_b` >=", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBLessThan(String value) {
            addCriterion("`selection_b` <", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBLessThanOrEqualTo(String value) {
            addCriterion("`selection_b` <=", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBLike(String value) {
            addCriterion("`selection_b` like", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBNotLike(String value) {
            addCriterion("`selection_b` not like", value, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBIn(List<String> values) {
            addCriterion("`selection_b` in", values, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBNotIn(List<String> values) {
            addCriterion("`selection_b` not in", values, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBBetween(String value1, String value2) {
            addCriterion("`selection_b` between", value1, value2, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionBNotBetween(String value1, String value2) {
            addCriterion("`selection_b` not between", value1, value2, "selectionB");
            return (Criteria) this;
        }

        public Criteria andSelectionCIsNull() {
            addCriterion("`selection_c` is null");
            return (Criteria) this;
        }

        public Criteria andSelectionCIsNotNull() {
            addCriterion("`selection_c` is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionCEqualTo(String value) {
            addCriterion("`selection_c` =", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCNotEqualTo(String value) {
            addCriterion("`selection_c` <>", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCGreaterThan(String value) {
            addCriterion("`selection_c` >", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCGreaterThanOrEqualTo(String value) {
            addCriterion("`selection_c` >=", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCLessThan(String value) {
            addCriterion("`selection_c` <", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCLessThanOrEqualTo(String value) {
            addCriterion("`selection_c` <=", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCLike(String value) {
            addCriterion("`selection_c` like", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCNotLike(String value) {
            addCriterion("`selection_c` not like", value, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCIn(List<String> values) {
            addCriterion("`selection_c` in", values, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCNotIn(List<String> values) {
            addCriterion("`selection_c` not in", values, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCBetween(String value1, String value2) {
            addCriterion("`selection_c` between", value1, value2, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionCNotBetween(String value1, String value2) {
            addCriterion("`selection_c` not between", value1, value2, "selectionC");
            return (Criteria) this;
        }

        public Criteria andSelectionDIsNull() {
            addCriterion("`selection_d` is null");
            return (Criteria) this;
        }

        public Criteria andSelectionDIsNotNull() {
            addCriterion("`selection_d` is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionDEqualTo(String value) {
            addCriterion("`selection_d` =", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDNotEqualTo(String value) {
            addCriterion("`selection_d` <>", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDGreaterThan(String value) {
            addCriterion("`selection_d` >", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDGreaterThanOrEqualTo(String value) {
            addCriterion("`selection_d` >=", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDLessThan(String value) {
            addCriterion("`selection_d` <", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDLessThanOrEqualTo(String value) {
            addCriterion("`selection_d` <=", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDLike(String value) {
            addCriterion("`selection_d` like", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDNotLike(String value) {
            addCriterion("`selection_d` not like", value, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDIn(List<String> values) {
            addCriterion("`selection_d` in", values, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDNotIn(List<String> values) {
            addCriterion("`selection_d` not in", values, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDBetween(String value1, String value2) {
            addCriterion("`selection_d` between", value1, value2, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionDNotBetween(String value1, String value2) {
            addCriterion("`selection_d` not between", value1, value2, "selectionD");
            return (Criteria) this;
        }

        public Criteria andSelectionEIsNull() {
            addCriterion("`selection_e` is null");
            return (Criteria) this;
        }

        public Criteria andSelectionEIsNotNull() {
            addCriterion("`selection_e` is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionEEqualTo(String value) {
            addCriterion("`selection_e` =", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionENotEqualTo(String value) {
            addCriterion("`selection_e` <>", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionEGreaterThan(String value) {
            addCriterion("`selection_e` >", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionEGreaterThanOrEqualTo(String value) {
            addCriterion("`selection_e` >=", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionELessThan(String value) {
            addCriterion("`selection_e` <", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionELessThanOrEqualTo(String value) {
            addCriterion("`selection_e` <=", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionELike(String value) {
            addCriterion("`selection_e` like", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionENotLike(String value) {
            addCriterion("`selection_e` not like", value, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionEIn(List<String> values) {
            addCriterion("`selection_e` in", values, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionENotIn(List<String> values) {
            addCriterion("`selection_e` not in", values, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionEBetween(String value1, String value2) {
            addCriterion("`selection_e` between", value1, value2, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionENotBetween(String value1, String value2) {
            addCriterion("`selection_e` not between", value1, value2, "selectionE");
            return (Criteria) this;
        }

        public Criteria andSelectionFIsNull() {
            addCriterion("`selection_f` is null");
            return (Criteria) this;
        }

        public Criteria andSelectionFIsNotNull() {
            addCriterion("`selection_f` is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionFEqualTo(String value) {
            addCriterion("`selection_f` =", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFNotEqualTo(String value) {
            addCriterion("`selection_f` <>", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFGreaterThan(String value) {
            addCriterion("`selection_f` >", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFGreaterThanOrEqualTo(String value) {
            addCriterion("`selection_f` >=", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFLessThan(String value) {
            addCriterion("`selection_f` <", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFLessThanOrEqualTo(String value) {
            addCriterion("`selection_f` <=", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFLike(String value) {
            addCriterion("`selection_f` like", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFNotLike(String value) {
            addCriterion("`selection_f` not like", value, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFIn(List<String> values) {
            addCriterion("`selection_f` in", values, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFNotIn(List<String> values) {
            addCriterion("`selection_f` not in", values, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFBetween(String value1, String value2) {
            addCriterion("`selection_f` between", value1, value2, "selectionF");
            return (Criteria) this;
        }

        public Criteria andSelectionFNotBetween(String value1, String value2) {
            addCriterion("`selection_f` not between", value1, value2, "selectionF");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table quest
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table quest
     *
     * @mbggenerated
     */
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