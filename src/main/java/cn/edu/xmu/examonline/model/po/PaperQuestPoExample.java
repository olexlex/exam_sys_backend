package cn.edu.xmu.examonline.model.po;

import java.util.ArrayList;
import java.util.List;

public class PaperQuestPoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    public PaperQuestPoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
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
     * This method corresponds to the database table paper_quest
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
     * This method corresponds to the database table paper_quest
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table paper_quest
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
     * This class corresponds to the database table paper_quest
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

        public Criteria andPaperIdIsNull() {
            addCriterion("`paper_id` is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("`paper_id` is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Integer value) {
            addCriterion("`paper_id` =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Integer value) {
            addCriterion("`paper_id` <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Integer value) {
            addCriterion("`paper_id` >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`paper_id` >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Integer value) {
            addCriterion("`paper_id` <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("`paper_id` <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Integer> values) {
            addCriterion("`paper_id` in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Integer> values) {
            addCriterion("`paper_id` not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("`paper_id` between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`paper_id` not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andQuestIdIsNull() {
            addCriterion("`quest_id` is null");
            return (Criteria) this;
        }

        public Criteria andQuestIdIsNotNull() {
            addCriterion("`quest_id` is not null");
            return (Criteria) this;
        }

        public Criteria andQuestIdEqualTo(Integer value) {
            addCriterion("`quest_id` =", value, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdNotEqualTo(Integer value) {
            addCriterion("`quest_id` <>", value, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdGreaterThan(Integer value) {
            addCriterion("`quest_id` >", value, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`quest_id` >=", value, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdLessThan(Integer value) {
            addCriterion("`quest_id` <", value, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdLessThanOrEqualTo(Integer value) {
            addCriterion("`quest_id` <=", value, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdIn(List<Integer> values) {
            addCriterion("`quest_id` in", values, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdNotIn(List<Integer> values) {
            addCriterion("`quest_id` not in", values, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdBetween(Integer value1, Integer value2) {
            addCriterion("`quest_id` between", value1, value2, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`quest_id` not between", value1, value2, "questId");
            return (Criteria) this;
        }

        public Criteria andQuestIndexIsNull() {
            addCriterion("`quest_index` is null");
            return (Criteria) this;
        }

        public Criteria andQuestIndexIsNotNull() {
            addCriterion("`quest_index` is not null");
            return (Criteria) this;
        }

        public Criteria andQuestIndexEqualTo(Integer value) {
            addCriterion("`quest_index` =", value, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexNotEqualTo(Integer value) {
            addCriterion("`quest_index` <>", value, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexGreaterThan(Integer value) {
            addCriterion("`quest_index` >", value, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("`quest_index` >=", value, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexLessThan(Integer value) {
            addCriterion("`quest_index` <", value, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexLessThanOrEqualTo(Integer value) {
            addCriterion("`quest_index` <=", value, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexIn(List<Integer> values) {
            addCriterion("`quest_index` in", values, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexNotIn(List<Integer> values) {
            addCriterion("`quest_index` not in", values, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexBetween(Integer value1, Integer value2) {
            addCriterion("`quest_index` between", value1, value2, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("`quest_index` not between", value1, value2, "questIndex");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerIsNull() {
            addCriterion("`quest_answer` is null");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerIsNotNull() {
            addCriterion("`quest_answer` is not null");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerEqualTo(String value) {
            addCriterion("`quest_answer` =", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerNotEqualTo(String value) {
            addCriterion("`quest_answer` <>", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerGreaterThan(String value) {
            addCriterion("`quest_answer` >", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("`quest_answer` >=", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerLessThan(String value) {
            addCriterion("`quest_answer` <", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerLessThanOrEqualTo(String value) {
            addCriterion("`quest_answer` <=", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerLike(String value) {
            addCriterion("`quest_answer` like", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerNotLike(String value) {
            addCriterion("`quest_answer` not like", value, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerIn(List<String> values) {
            addCriterion("`quest_answer` in", values, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerNotIn(List<String> values) {
            addCriterion("`quest_answer` not in", values, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerBetween(String value1, String value2) {
            addCriterion("`quest_answer` between", value1, value2, "questAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestAnswerNotBetween(String value1, String value2) {
            addCriterion("`quest_answer` not between", value1, value2, "questAnswer");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table paper_quest
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
     * This class corresponds to the database table paper_quest
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