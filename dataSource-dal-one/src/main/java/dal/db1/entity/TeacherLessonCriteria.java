package dal.db1.entity;

import java.util.ArrayList;
import java.util.List;

public class TeacherLessonCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherLessonCriteria() {
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

        public Criteria andChineseNameIsNull() {
            addCriterion("chinese_name is null");
            return (Criteria) this;
        }

        public Criteria andChineseNameIsNotNull() {
            addCriterion("chinese_name is not null");
            return (Criteria) this;
        }

        public Criteria andChineseNameEqualTo(String value) {
            addCriterion("chinese_name =", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotEqualTo(String value) {
            addCriterion("chinese_name <>", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThan(String value) {
            addCriterion("chinese_name >", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_name >=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThan(String value) {
            addCriterion("chinese_name <", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLessThanOrEqualTo(String value) {
            addCriterion("chinese_name <=", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameLike(String value) {
            addCriterion("chinese_name like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotLike(String value) {
            addCriterion("chinese_name not like", value, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameIn(List<String> values) {
            addCriterion("chinese_name in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotIn(List<String> values) {
            addCriterion("chinese_name not in", values, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameBetween(String value1, String value2) {
            addCriterion("chinese_name between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andChineseNameNotBetween(String value1, String value2) {
            addCriterion("chinese_name not between", value1, value2, "chineseName");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNull() {
            addCriterion("staff_no is null");
            return (Criteria) this;
        }

        public Criteria andStaffNoIsNotNull() {
            addCriterion("staff_no is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNoEqualTo(String value) {
            addCriterion("staff_no =", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotEqualTo(String value) {
            addCriterion("staff_no <>", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThan(String value) {
            addCriterion("staff_no >", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoGreaterThanOrEqualTo(String value) {
            addCriterion("staff_no >=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThan(String value) {
            addCriterion("staff_no <", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLessThanOrEqualTo(String value) {
            addCriterion("staff_no <=", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoLike(String value) {
            addCriterion("staff_no like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotLike(String value) {
            addCriterion("staff_no not like", value, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoIn(List<String> values) {
            addCriterion("staff_no in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotIn(List<String> values) {
            addCriterion("staff_no not in", values, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoBetween(String value1, String value2) {
            addCriterion("staff_no between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andStaffNoNotBetween(String value1, String value2) {
            addCriterion("staff_no not between", value1, value2, "staffNo");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdIsNull() {
            addCriterion("teacher_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdIsNotNull() {
            addCriterion("teacher_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdEqualTo(Long value) {
            addCriterion("teacher_unit_id =", value, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdNotEqualTo(Long value) {
            addCriterion("teacher_unit_id <>", value, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdGreaterThan(Long value) {
            addCriterion("teacher_unit_id >", value, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher_unit_id >=", value, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdLessThan(Long value) {
            addCriterion("teacher_unit_id <", value, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdLessThanOrEqualTo(Long value) {
            addCriterion("teacher_unit_id <=", value, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdIn(List<Long> values) {
            addCriterion("teacher_unit_id in", values, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdNotIn(List<Long> values) {
            addCriterion("teacher_unit_id not in", values, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdBetween(Long value1, Long value2) {
            addCriterion("teacher_unit_id between", value1, value2, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIdNotBetween(Long value1, Long value2) {
            addCriterion("teacher_unit_id not between", value1, value2, "teacherUnitId");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIsNull() {
            addCriterion("teacher_unit is null");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIsNotNull() {
            addCriterion("teacher_unit is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitEqualTo(String value) {
            addCriterion("teacher_unit =", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitNotEqualTo(String value) {
            addCriterion("teacher_unit <>", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitGreaterThan(String value) {
            addCriterion("teacher_unit >", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_unit >=", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitLessThan(String value) {
            addCriterion("teacher_unit <", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitLessThanOrEqualTo(String value) {
            addCriterion("teacher_unit <=", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitLike(String value) {
            addCriterion("teacher_unit like", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitNotLike(String value) {
            addCriterion("teacher_unit not like", value, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitIn(List<String> values) {
            addCriterion("teacher_unit in", values, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitNotIn(List<String> values) {
            addCriterion("teacher_unit not in", values, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitBetween(String value1, String value2) {
            addCriterion("teacher_unit between", value1, value2, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherUnitNotBetween(String value1, String value2) {
            addCriterion("teacher_unit not between", value1, value2, "teacherUnit");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIsNull() {
            addCriterion("teacher_type is null");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIsNotNull() {
            addCriterion("teacher_type is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeEqualTo(Long value) {
            addCriterion("teacher_type =", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotEqualTo(Long value) {
            addCriterion("teacher_type <>", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeGreaterThan(Long value) {
            addCriterion("teacher_type >", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("teacher_type >=", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLessThan(Long value) {
            addCriterion("teacher_type <", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLessThanOrEqualTo(Long value) {
            addCriterion("teacher_type <=", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIn(List<Long> values) {
            addCriterion("teacher_type in", values, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotIn(List<Long> values) {
            addCriterion("teacher_type not in", values, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeBetween(Long value1, Long value2) {
            addCriterion("teacher_type between", value1, value2, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotBetween(Long value1, Long value2) {
            addCriterion("teacher_type not between", value1, value2, "teacherType");
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