package dal.db1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Excel {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FEED_BACK_ID")
    private Long feedBackId;

    /**
     * 事业部id
     */
    @Column(name = "BU_ID")
    private Long buId;

    /**
     * 分校id
     */
    @Column(name = "BRANCH_ID")
    private Long branchId;

    /**
     * 班级编号
     */
    @Column(name = "CLASS_NO")
    private String classNo;

    /**
     * 班级名称
     */
    @Column(name = "CLASS_NAME")
    private String className;

    /**
     * 阶段Id
     */
    @Column(name = "STAGE_ID")
    private Long stageId;

    /**
     * 科目Id
     */
    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    /**
     * 员工工号
     */
    @Column(name = "staff_no")
    private String staffNo;

    @Column(name = "teacher_name")
    private String teacherName;


    @Column(name = "TEACHER_TYPE")
    private Byte teacherType;

    /**
     * 上课人数
     */
    @Column(name = "STUDENT_NUM")
    private Integer studentNum;

    /**
     * 开始时间
     */
    @Column(name = "START_TIME")
    private String startTime;

    /**
     * 结课时间
     */
    @Column(name = "END_TIME")
    private String endTime;

    /**
     * 授课小时数
     */
    @Column(name = "DURATION")
    private Long duration;

    /**
     * 退班人数
     */
    @Column(name = "QUIT_NUM")
    private Integer quitNum;

    /**
     * 退款订单
     */
    @Column(name = "ORDER_NO")
    private String orderNo;

    /**
     * 分数
     */
    @Column(name = "SCORE")
    private Integer score;

    /**
     * 是否事故,0否,1是
     */
    @Column(name = "ACCIDENT")
    private Byte accident;

    /**
     * 退班原因
     */
    @Column(name = "QUIT_REASON")
    private String quitReason;

    /**
     * 获取自增ID
     *
     * @return ID - 自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取事业部id
     *
     * @return BU_ID - 事业部id
     */
    public Long getBuId() {
        return buId;
    }

    /**
     * 设置事业部id
     *
     * @param buId 事业部id
     */
    public void setBuId(Long buId) {
        this.buId = buId;
    }

    /**
     * 获取分校id
     *
     * @return BRANCH_ID - 分校id
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置分校id
     *
     * @param branchId 分校id
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * 获取班级编号
     *
     * @return CLASS_NO - 班级编号
     */
    public String getClassNo() {
        return classNo;
    }

    /**
     * 设置班级编号
     *
     * @param classNo 班级编号
     */
    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    /**
     * 获取班级名称
     *
     * @return CLASS_NAME - 班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置班级名称
     *
     * @param className 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取阶段Id
     *
     * @return STAGE_ID - 阶段Id
     */
    public Long getStageId() {
        return stageId;
    }

    /**
     * 设置阶段Id
     *
     * @param stageId 阶段Id
     */
    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    /**
     * 获取科目Id
     *
     * @return SUBJECT_ID - 科目Id
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * 设置科目Id
     *
     * @param subjectId 科目Id
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取员工工号
     *
     * @return staff_no - 员工工号
     */
    public String getStaffNo() {
        return staffNo;
    }

    /**
     * 设置员工工号
     *
     * @param staffNo 员工工号
     */
    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    /**
     * 获取上课人数
     *
     * @return STUDENT_NUM - 上课人数
     */
    public Integer getStudentNum() {
        return studentNum;
    }

    /**
     * 设置上课人数
     *
     * @param studentNum 上课人数
     */
    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * 获取开始时间
     *
     * @return START_TIME - 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结课时间
     *
     * @return END_TIME - 结课时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结课时间
     *
     * @param endTime 结课时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取授课小时数
     *
     * @return DURATION - 授课小时数
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * 设置授课小时数
     *
     * @param duration 授课小时数
     */
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    /**
     * 获取退班人数
     *
     * @return QUIT_NUM - 退班人数
     */
    public Integer getQuitNum() {
        return quitNum;
    }

    /**
     * 设置退班人数
     *
     * @param quitNum 退班人数
     */
    public void setQuitNum(Integer quitNum) {
        this.quitNum = quitNum;
    }

    /**
     * 获取退款订单
     *
     * @return ORDER_NO - 退款订单
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置退款订单
     *
     * @param orderNo 退款订单
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取分数
     *
     * @return SCORE - 分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置分数
     *
     * @param score 分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取是否事故,0否,1是
     *
     * @return ACCIDENT - 是否事故,0否,1是
     */
    public Byte getAccident() {
        return accident;
    }

    /**
     * 设置是否事故,0否,1是
     *
     * @param accident 是否事故,0否,1是
     */
    public void setAccident(Byte accident) {
        this.accident = accident;
    }

    /**
     * 获取退班原因
     *
     * @return QUIT_REASON - 退班原因
     */
    public String getQuitReason() {
        return quitReason;
    }

    /**
     * 设置退班原因
     *
     * @param quitReason 退班原因
     */
    public void setQuitReason(String quitReason) {
        this.quitReason = quitReason;
    }
}