package cn.pluto.postgraduate.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelpathExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExcelpathExample() {
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

        public Criteria andExcelTimeIsNull() {
            addCriterion("excel_time is null");
            return (Criteria) this;
        }

        public Criteria andExcelTimeIsNotNull() {
            addCriterion("excel_time is not null");
            return (Criteria) this;
        }

        public Criteria andExcelTimeEqualTo(String value) {
            addCriterion("excel_time =", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeNotEqualTo(String value) {
            addCriterion("excel_time <>", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeGreaterThan(String value) {
            addCriterion("excel_time >", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeGreaterThanOrEqualTo(String value) {
            addCriterion("excel_time >=", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeLessThan(String value) {
            addCriterion("excel_time <", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeLessThanOrEqualTo(String value) {
            addCriterion("excel_time <=", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeLike(String value) {
            addCriterion("excel_time like", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeNotLike(String value) {
            addCriterion("excel_time not like", value, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeIn(List<String> values) {
            addCriterion("excel_time in", values, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeNotIn(List<String> values) {
            addCriterion("excel_time not in", values, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeBetween(String value1, String value2) {
            addCriterion("excel_time between", value1, value2, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelTimeNotBetween(String value1, String value2) {
            addCriterion("excel_time not between", value1, value2, "excelTime");
            return (Criteria) this;
        }

        public Criteria andExcelPathIsNull() {
            addCriterion("excel_path is null");
            return (Criteria) this;
        }

        public Criteria andExcelPathIsNotNull() {
            addCriterion("excel_path is not null");
            return (Criteria) this;
        }

        public Criteria andExcelPathEqualTo(String value) {
            addCriterion("excel_path =", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathNotEqualTo(String value) {
            addCriterion("excel_path <>", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathGreaterThan(String value) {
            addCriterion("excel_path >", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathGreaterThanOrEqualTo(String value) {
            addCriterion("excel_path >=", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathLessThan(String value) {
            addCriterion("excel_path <", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathLessThanOrEqualTo(String value) {
            addCriterion("excel_path <=", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathLike(String value) {
            addCriterion("excel_path like", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathNotLike(String value) {
            addCriterion("excel_path not like", value, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathIn(List<String> values) {
            addCriterion("excel_path in", values, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathNotIn(List<String> values) {
            addCriterion("excel_path not in", values, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathBetween(String value1, String value2) {
            addCriterion("excel_path between", value1, value2, "excelPath");
            return (Criteria) this;
        }

        public Criteria andExcelPathNotBetween(String value1, String value2) {
            addCriterion("excel_path not between", value1, value2, "excelPath");
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