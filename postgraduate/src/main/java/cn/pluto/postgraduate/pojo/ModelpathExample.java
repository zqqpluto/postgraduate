package cn.pluto.postgraduate.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelpathExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelpathExample() {
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

        public Criteria andExcelIdIsNull() {
            addCriterion("excel_id is null");
            return (Criteria) this;
        }

        public Criteria andExcelIdIsNotNull() {
            addCriterion("excel_id is not null");
            return (Criteria) this;
        }

        public Criteria andExcelIdEqualTo(Integer value) {
            addCriterion("excel_id =", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotEqualTo(Integer value) {
            addCriterion("excel_id <>", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdGreaterThan(Integer value) {
            addCriterion("excel_id >", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("excel_id >=", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdLessThan(Integer value) {
            addCriterion("excel_id <", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdLessThanOrEqualTo(Integer value) {
            addCriterion("excel_id <=", value, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdIn(List<Integer> values) {
            addCriterion("excel_id in", values, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotIn(List<Integer> values) {
            addCriterion("excel_id not in", values, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdBetween(Integer value1, Integer value2) {
            addCriterion("excel_id between", value1, value2, "excelId");
            return (Criteria) this;
        }

        public Criteria andExcelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("excel_id not between", value1, value2, "excelId");
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

        public Criteria andModelPathIsNull() {
            addCriterion("model_path is null");
            return (Criteria) this;
        }

        public Criteria andModelPathIsNotNull() {
            addCriterion("model_path is not null");
            return (Criteria) this;
        }

        public Criteria andModelPathEqualTo(String value) {
            addCriterion("model_path =", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathNotEqualTo(String value) {
            addCriterion("model_path <>", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathGreaterThan(String value) {
            addCriterion("model_path >", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathGreaterThanOrEqualTo(String value) {
            addCriterion("model_path >=", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathLessThan(String value) {
            addCriterion("model_path <", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathLessThanOrEqualTo(String value) {
            addCriterion("model_path <=", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathLike(String value) {
            addCriterion("model_path like", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathNotLike(String value) {
            addCriterion("model_path not like", value, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathIn(List<String> values) {
            addCriterion("model_path in", values, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathNotIn(List<String> values) {
            addCriterion("model_path not in", values, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathBetween(String value1, String value2) {
            addCriterion("model_path between", value1, value2, "modelPath");
            return (Criteria) this;
        }

        public Criteria andModelPathNotBetween(String value1, String value2) {
            addCriterion("model_path not between", value1, value2, "modelPath");
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