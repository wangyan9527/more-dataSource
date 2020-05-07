package dal.db1.entity;

import java.util.ArrayList;
import java.util.List;

public class ExcelFeedCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExcelFeedCriteria() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoIsNull() {
            addCriterion("FEED_BACK_NO is null");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoIsNotNull() {
            addCriterion("FEED_BACK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoEqualTo(String value) {
            addCriterion("FEED_BACK_NO =", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoNotEqualTo(String value) {
            addCriterion("FEED_BACK_NO <>", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoGreaterThan(String value) {
            addCriterion("FEED_BACK_NO >", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoGreaterThanOrEqualTo(String value) {
            addCriterion("FEED_BACK_NO >=", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoLessThan(String value) {
            addCriterion("FEED_BACK_NO <", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoLessThanOrEqualTo(String value) {
            addCriterion("FEED_BACK_NO <=", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoLike(String value) {
            addCriterion("FEED_BACK_NO like", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoNotLike(String value) {
            addCriterion("FEED_BACK_NO not like", value, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoIn(List<String> values) {
            addCriterion("FEED_BACK_NO in", values, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoNotIn(List<String> values) {
            addCriterion("FEED_BACK_NO not in", values, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoBetween(String value1, String value2) {
            addCriterion("FEED_BACK_NO between", value1, value2, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andFeedBackNoNotBetween(String value1, String value2) {
            addCriterion("FEED_BACK_NO not between", value1, value2, "feedBackNo");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNull() {
            addCriterion("CLASS_NO is null");
            return (Criteria) this;
        }

        public Criteria andClassNoIsNotNull() {
            addCriterion("CLASS_NO is not null");
            return (Criteria) this;
        }

        public Criteria andClassNoEqualTo(String value) {
            addCriterion("CLASS_NO =", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotEqualTo(String value) {
            addCriterion("CLASS_NO <>", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThan(String value) {
            addCriterion("CLASS_NO >", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_NO >=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThan(String value) {
            addCriterion("CLASS_NO <", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLessThanOrEqualTo(String value) {
            addCriterion("CLASS_NO <=", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoLike(String value) {
            addCriterion("CLASS_NO like", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotLike(String value) {
            addCriterion("CLASS_NO not like", value, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoIn(List<String> values) {
            addCriterion("CLASS_NO in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotIn(List<String> values) {
            addCriterion("CLASS_NO not in", values, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoBetween(String value1, String value2) {
            addCriterion("CLASS_NO between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNoNotBetween(String value1, String value2) {
            addCriterion("CLASS_NO not between", value1, value2, "classNo");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("CLASS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("CLASS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("CLASS_NAME =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("CLASS_NAME <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("CLASS_NAME >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("CLASS_NAME <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("CLASS_NAME like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("CLASS_NAME not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("CLASS_NAME in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("CLASS_NAME not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("CLASS_NAME between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("CLASS_NAME not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andBuIdIsNull() {
            addCriterion("BU_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuIdIsNotNull() {
            addCriterion("BU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuIdEqualTo(Long value) {
            addCriterion("BU_ID =", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdNotEqualTo(Long value) {
            addCriterion("BU_ID <>", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdGreaterThan(Long value) {
            addCriterion("BU_ID >", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BU_ID >=", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdLessThan(Long value) {
            addCriterion("BU_ID <", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdLessThanOrEqualTo(Long value) {
            addCriterion("BU_ID <=", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdIn(List<Long> values) {
            addCriterion("BU_ID in", values, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdNotIn(List<Long> values) {
            addCriterion("BU_ID not in", values, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdBetween(Long value1, Long value2) {
            addCriterion("BU_ID between", value1, value2, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdNotBetween(Long value1, Long value2) {
            addCriterion("BU_ID not between", value1, value2, "buId");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNull() {
            addCriterion("EXAM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNotNull() {
            addCriterion("EXAM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andExamTypeEqualTo(String value) {
            addCriterion("EXAM_TYPE =", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotEqualTo(String value) {
            addCriterion("EXAM_TYPE <>", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThan(String value) {
            addCriterion("EXAM_TYPE >", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EXAM_TYPE >=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThan(String value) {
            addCriterion("EXAM_TYPE <", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThanOrEqualTo(String value) {
            addCriterion("EXAM_TYPE <=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLike(String value) {
            addCriterion("EXAM_TYPE like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotLike(String value) {
            addCriterion("EXAM_TYPE not like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeIn(List<String> values) {
            addCriterion("EXAM_TYPE in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotIn(List<String> values) {
            addCriterion("EXAM_TYPE not in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeBetween(String value1, String value2) {
            addCriterion("EXAM_TYPE between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotBetween(String value1, String value2) {
            addCriterion("EXAM_TYPE not between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andBranchIdIsNull() {
            addCriterion("BRANCH_ID is null");
            return (Criteria) this;
        }

        public Criteria andBranchIdIsNotNull() {
            addCriterion("BRANCH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBranchIdEqualTo(Long value) {
            addCriterion("BRANCH_ID =", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdNotEqualTo(Long value) {
            addCriterion("BRANCH_ID <>", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdGreaterThan(Long value) {
            addCriterion("BRANCH_ID >", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BRANCH_ID >=", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdLessThan(Long value) {
            addCriterion("BRANCH_ID <", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdLessThanOrEqualTo(Long value) {
            addCriterion("BRANCH_ID <=", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdIn(List<Long> values) {
            addCriterion("BRANCH_ID in", values, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdNotIn(List<Long> values) {
            addCriterion("BRANCH_ID not in", values, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdBetween(Long value1, Long value2) {
            addCriterion("BRANCH_ID between", value1, value2, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdNotBetween(Long value1, Long value2) {
            addCriterion("BRANCH_ID not between", value1, value2, "branchId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdIsNull() {
            addCriterion("SUBSECTORS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdIsNotNull() {
            addCriterion("SUBSECTORS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdEqualTo(Long value) {
            addCriterion("SUBSECTORS_ID =", value, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdNotEqualTo(Long value) {
            addCriterion("SUBSECTORS_ID <>", value, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdGreaterThan(Long value) {
            addCriterion("SUBSECTORS_ID >", value, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBSECTORS_ID >=", value, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdLessThan(Long value) {
            addCriterion("SUBSECTORS_ID <", value, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdLessThanOrEqualTo(Long value) {
            addCriterion("SUBSECTORS_ID <=", value, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdIn(List<Long> values) {
            addCriterion("SUBSECTORS_ID in", values, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdNotIn(List<Long> values) {
            addCriterion("SUBSECTORS_ID not in", values, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdBetween(Long value1, Long value2) {
            addCriterion("SUBSECTORS_ID between", value1, value2, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andSubsectorsIdNotBetween(Long value1, Long value2) {
            addCriterion("SUBSECTORS_ID not between", value1, value2, "subsectorsId");
            return (Criteria) this;
        }

        public Criteria andRoomIsNull() {
            addCriterion("ROOM is null");
            return (Criteria) this;
        }

        public Criteria andRoomIsNotNull() {
            addCriterion("ROOM is not null");
            return (Criteria) this;
        }

        public Criteria andRoomEqualTo(String value) {
            addCriterion("ROOM =", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotEqualTo(String value) {
            addCriterion("ROOM <>", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThan(String value) {
            addCriterion("ROOM >", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThanOrEqualTo(String value) {
            addCriterion("ROOM >=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThan(String value) {
            addCriterion("ROOM <", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThanOrEqualTo(String value) {
            addCriterion("ROOM <=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLike(String value) {
            addCriterion("ROOM like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotLike(String value) {
            addCriterion("ROOM not like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomIn(List<String> values) {
            addCriterion("ROOM in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotIn(List<String> values) {
            addCriterion("ROOM not in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomBetween(String value1, String value2) {
            addCriterion("ROOM between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotBetween(String value1, String value2) {
            addCriterion("ROOM not between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIsNull() {
            addCriterion("TEACHER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIsNotNull() {
            addCriterion("TEACHER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeEqualTo(String value) {
            addCriterion("TEACHER_TYPE =", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotEqualTo(String value) {
            addCriterion("TEACHER_TYPE <>", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeGreaterThan(String value) {
            addCriterion("TEACHER_TYPE >", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_TYPE >=", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLessThan(String value) {
            addCriterion("TEACHER_TYPE <", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_TYPE <=", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLike(String value) {
            addCriterion("TEACHER_TYPE like", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotLike(String value) {
            addCriterion("TEACHER_TYPE not like", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIn(List<String> values) {
            addCriterion("TEACHER_TYPE in", values, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotIn(List<String> values) {
            addCriterion("TEACHER_TYPE not in", values, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeBetween(String value1, String value2) {
            addCriterion("TEACHER_TYPE between", value1, value2, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotBetween(String value1, String value2) {
            addCriterion("TEACHER_TYPE not between", value1, value2, "teacherType");
            return (Criteria) this;
        }

        public Criteria andStageIsNull() {
            addCriterion("STAGE is null");
            return (Criteria) this;
        }

        public Criteria andStageIsNotNull() {
            addCriterion("STAGE is not null");
            return (Criteria) this;
        }

        public Criteria andStageEqualTo(String value) {
            addCriterion("STAGE =", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotEqualTo(String value) {
            addCriterion("STAGE <>", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThan(String value) {
            addCriterion("STAGE >", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThanOrEqualTo(String value) {
            addCriterion("STAGE >=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThan(String value) {
            addCriterion("STAGE <", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThanOrEqualTo(String value) {
            addCriterion("STAGE <=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLike(String value) {
            addCriterion("STAGE like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotLike(String value) {
            addCriterion("STAGE not like", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageIn(List<String> values) {
            addCriterion("STAGE in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotIn(List<String> values) {
            addCriterion("STAGE not in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageBetween(String value1, String value2) {
            addCriterion("STAGE between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotBetween(String value1, String value2) {
            addCriterion("STAGE not between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("SUBJECT =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("SUBJECT <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("SUBJECT >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("SUBJECT <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("SUBJECT like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("SUBJECT not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("SUBJECT in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("SUBJECT not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("SUBJECT between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("SUBJECT not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andGoodsnosIsNull() {
            addCriterion("goodsNos is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnosIsNotNull() {
            addCriterion("goodsNos is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnosEqualTo(String value) {
            addCriterion("goodsNos =", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosNotEqualTo(String value) {
            addCriterion("goodsNos <>", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosGreaterThan(String value) {
            addCriterion("goodsNos >", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosGreaterThanOrEqualTo(String value) {
            addCriterion("goodsNos >=", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosLessThan(String value) {
            addCriterion("goodsNos <", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosLessThanOrEqualTo(String value) {
            addCriterion("goodsNos <=", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosLike(String value) {
            addCriterion("goodsNos like", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosNotLike(String value) {
            addCriterion("goodsNos not like", value, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosIn(List<String> values) {
            addCriterion("goodsNos in", values, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosNotIn(List<String> values) {
            addCriterion("goodsNos not in", values, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosBetween(String value1, String value2) {
            addCriterion("goodsNos between", value1, value2, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andGoodsnosNotBetween(String value1, String value2) {
            addCriterion("goodsNos not between", value1, value2, "goodsnos");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("START_TIME like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("START_TIME not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("END_TIME like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("END_TIME not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("DURATION is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("DURATION =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("DURATION <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("DURATION >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("DURATION >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("DURATION <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("DURATION <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("DURATION like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("DURATION not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("DURATION in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("DURATION not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("DURATION between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("DURATION not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andAccidentIsNull() {
            addCriterion("ACCIDENT is null");
            return (Criteria) this;
        }

        public Criteria andAccidentIsNotNull() {
            addCriterion("ACCIDENT is not null");
            return (Criteria) this;
        }

        public Criteria andAccidentEqualTo(String value) {
            addCriterion("ACCIDENT =", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentNotEqualTo(String value) {
            addCriterion("ACCIDENT <>", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentGreaterThan(String value) {
            addCriterion("ACCIDENT >", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentGreaterThanOrEqualTo(String value) {
            addCriterion("ACCIDENT >=", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentLessThan(String value) {
            addCriterion("ACCIDENT <", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentLessThanOrEqualTo(String value) {
            addCriterion("ACCIDENT <=", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentLike(String value) {
            addCriterion("ACCIDENT like", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentNotLike(String value) {
            addCriterion("ACCIDENT not like", value, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentIn(List<String> values) {
            addCriterion("ACCIDENT in", values, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentNotIn(List<String> values) {
            addCriterion("ACCIDENT not in", values, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentBetween(String value1, String value2) {
            addCriterion("ACCIDENT between", value1, value2, "accident");
            return (Criteria) this;
        }

        public Criteria andAccidentNotBetween(String value1, String value2) {
            addCriterion("ACCIDENT not between", value1, value2, "accident");
            return (Criteria) this;
        }

        public Criteria andSurveyNumIsNull() {
            addCriterion("SURVEY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSurveyNumIsNotNull() {
            addCriterion("SURVEY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyNumEqualTo(Integer value) {
            addCriterion("SURVEY_NUM =", value, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumNotEqualTo(Integer value) {
            addCriterion("SURVEY_NUM <>", value, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumGreaterThan(Integer value) {
            addCriterion("SURVEY_NUM >", value, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SURVEY_NUM >=", value, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumLessThan(Integer value) {
            addCriterion("SURVEY_NUM <", value, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumLessThanOrEqualTo(Integer value) {
            addCriterion("SURVEY_NUM <=", value, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumIn(List<Integer> values) {
            addCriterion("SURVEY_NUM in", values, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumNotIn(List<Integer> values) {
            addCriterion("SURVEY_NUM not in", values, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumBetween(Integer value1, Integer value2) {
            addCriterion("SURVEY_NUM between", value1, value2, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andSurveyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SURVEY_NUM not between", value1, value2, "surveyNum");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("SCORE like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("SCORE not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("SCORE not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNull() {
            addCriterion("STUDENT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNotNull() {
            addCriterion("STUDENT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumEqualTo(Integer value) {
            addCriterion("STUDENT_NUM =", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotEqualTo(Integer value) {
            addCriterion("STUDENT_NUM <>", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThan(Integer value) {
            addCriterion("STUDENT_NUM >", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("STUDENT_NUM >=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThan(Integer value) {
            addCriterion("STUDENT_NUM <", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThanOrEqualTo(Integer value) {
            addCriterion("STUDENT_NUM <=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumIn(List<Integer> values) {
            addCriterion("STUDENT_NUM in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotIn(List<Integer> values) {
            addCriterion("STUDENT_NUM not in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumBetween(Integer value1, Integer value2) {
            addCriterion("STUDENT_NUM between", value1, value2, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("STUDENT_NUM not between", value1, value2, "studentNum");
            return (Criteria) this;
        }

        public Criteria andRealNumIsNull() {
            addCriterion("REAL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andRealNumIsNotNull() {
            addCriterion("REAL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andRealNumEqualTo(Integer value) {
            addCriterion("REAL_NUM =", value, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumNotEqualTo(Integer value) {
            addCriterion("REAL_NUM <>", value, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumGreaterThan(Integer value) {
            addCriterion("REAL_NUM >", value, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("REAL_NUM >=", value, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumLessThan(Integer value) {
            addCriterion("REAL_NUM <", value, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumLessThanOrEqualTo(Integer value) {
            addCriterion("REAL_NUM <=", value, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumIn(List<Integer> values) {
            addCriterion("REAL_NUM in", values, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumNotIn(List<Integer> values) {
            addCriterion("REAL_NUM not in", values, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumBetween(Integer value1, Integer value2) {
            addCriterion("REAL_NUM between", value1, value2, "realNum");
            return (Criteria) this;
        }

        public Criteria andRealNumNotBetween(Integer value1, Integer value2) {
            addCriterion("REAL_NUM not between", value1, value2, "realNum");
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