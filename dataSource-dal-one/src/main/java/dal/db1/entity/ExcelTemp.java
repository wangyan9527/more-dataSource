package dal.db1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class ExcelTemp {
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

    @Column(name = "STAGE")
    private String stage;

    @Column(name = "SUBJECT")
    private String subject;

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
    private String teacherType;

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
    private String duration;

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
    private String score;

    /**
     * 是否事故,0否,1是
     */
    @Column(name = "ACCIDENT")
    private String accident;

    /**
     * 退班原因
     */
    @Column(name = "QUIT_REASON")
    private String quitReason;

}