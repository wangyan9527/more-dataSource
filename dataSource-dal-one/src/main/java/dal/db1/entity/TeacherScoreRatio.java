package dal.db1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "teacher_score_ratio")
public class TeacherScoreRatio {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * class_stage_subject_teacher主键id
     */
    @Column(name = "CSST_ID")
    private Long csstId;

    /**
     * 反馈编号
     */
    @Column(name = "FEEDBACK_NO")
    private String feedbackNo;

    /**
     * 班级id
     */
    @Column(name = "CLASS_ID")
    private Long classId;

    /**
     * 班级编号
     */
    @Column(name = "CLASS_NO")
    private String classNo;

    /**
     * 主讲老师no
     */
    @Column(name = "TEACHER_STAFF_NO")
    private String teacherStaffNo;

    @Column(name = "TEACHER_TYPE")
    private Byte teacherType;

    /**
     * 阶段id
     */
    @Column(name = "STAGE_ID")
    private Long stageId;

    /**
     * 科目id
     */
    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    /**
     * 批次数(默认从0开始)
     */
    @Column(name = "BATCH_NUM")
    private Integer batchNum;

    /**
     * 分校id
     */
    @Column(name = "BRANCH_ID")
    private Long branchId;

    /**
     * 分部id
     */
    @Column(name = "SUBSECTORS_ID")
    private Long subsectorsId;

    /**
     * 上课类型，1.讲座，2.非讲座
     */
    @Column(name = "COURSE_TYPE")
    private Byte courseType;

    /**
     * 事业部id
     */
    @Column(name = "BU_ID")
    private Long buId;

    /**
     * 退班人数
     */
    @Column(name = "QUIT_NUM")
    private Integer quitNum;

    /**
     * 笔面试类型:B(笔试),M(面试),Z(综合)
     */
    @Column(name = "EXAM_WAY")
    private String examWay;

    /**
     * 考试类型
     */
    @Column(name = "EXAM_TYPE")
    private String examType;

    /**
     * 参评率：0-100分别代表100个百分点
     */
    @Column(name = "SCORE_RATIO")
    private Integer scoreRatio;

    /**
     * 分值
     */
    @Column(name = "SCORE")
    private Integer score;

    /**
     * 日期
     */
    @Column(name = "LESSON_DATE")
    private Date lessonDate;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 调查问卷数
     */
    @Column(name = "SURVEY_NUM")
    private Integer surveyNum;

    /**
     * 到场人数
     */
    @Column(name = "REAL_NUM")
    private Integer realNum;
}