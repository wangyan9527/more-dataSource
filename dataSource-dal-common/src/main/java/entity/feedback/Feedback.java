package entity.feedback;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "feed_back")
public class Feedback {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 反馈编号
     */
    @Column(name = "FEEDBACK_NO")
    private String feedbackNo;

    /**
     * 班级ID
     */
    @Column(name = "CLASS_ID")
    private Long classId;

    /**
     * 反馈状态,5:待反馈;6反馈中;7:已反馈
     */
    @Column(name = "STATUS")
    private Byte status;

    /**
     * 备注(通用)
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 学生意见(通用)
     */
    @Column(name = "STUDENT_SUGGESTION")
    private String studentSuggestion;

    /**
     * 退班原因(非讲座用)
     */
    @Column(name = "QUIT_REASON")
    private String quitReason;

    /**
     * 讲座效果(讲座用)
     */
    @Column(name = "EFFCT_DESC")
    private String effctDesc;

    /**
     * 分校意见与建议(讲座用)
     */
    @Column(name = "SUBSCHOOL_SUGGEST")
    private String subschoolSuggest;

    /**
     * 老师再次授课意见(讲座用)
     */
    @Column(name = "TEACH_AGAIN_SUGGESTION")
    private String teachAgainSuggestion;

    /**
     * 反馈快照标题
     */
    @Column(name = "TITLE")
    private String title;

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
     * 反馈时间
     */
    @Column(name = "FEEDBACK_TIME")
    private Date feedbackTime;

    /**
     * 创建人id
     */
    @Column(name = "CREATOR_ID")
    private Long creatorId;

    /**
     * 反馈界面快照
     */
    @Column(name = "SNAPSHOT")
    private String snapshot;

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
     * 获取反馈编号
     *
     * @return FEEDBACK_NO - 反馈编号
     */
    public String getFeedbackNo() {
        return feedbackNo;
    }

    /**
     * 设置反馈编号
     *
     * @param feedbackNo 反馈编号
     */
    public void setFeedbackNo(String feedbackNo) {
        this.feedbackNo = feedbackNo;
    }

    /**
     * 获取班级ID
     *
     * @return CLASS_ID - 班级ID
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * 设置班级ID
     *
     * @param classId 班级ID
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * 获取反馈状态,5:待反馈;6反馈中;7:已反馈
     *
     * @return STATUS - 反馈状态,5:待反馈;6反馈中;7:已反馈
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置反馈状态,5:待反馈;6反馈中;7:已反馈
     *
     * @param status 反馈状态,5:待反馈;6反馈中;7:已反馈
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取备注(通用)
     *
     * @return REMARK - 备注(通用)
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注(通用)
     *
     * @param remark 备注(通用)
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取学生意见(通用)
     *
     * @return STUDENT_SUGGESTION - 学生意见(通用)
     */
    public String getStudentSuggestion() {
        return studentSuggestion;
    }

    /**
     * 设置学生意见(通用)
     *
     * @param studentSuggestion 学生意见(通用)
     */
    public void setStudentSuggestion(String studentSuggestion) {
        this.studentSuggestion = studentSuggestion;
    }

    /**
     * 获取退班原因(非讲座用)
     *
     * @return QUIT_REASON - 退班原因(非讲座用)
     */
    public String getQuitReason() {
        return quitReason;
    }

    /**
     * 设置退班原因(非讲座用)
     *
     * @param quitReason 退班原因(非讲座用)
     */
    public void setQuitReason(String quitReason) {
        this.quitReason = quitReason;
    }

    /**
     * 获取讲座效果(讲座用)
     *
     * @return EFFCT_DESC - 讲座效果(讲座用)
     */
    public String getEffctDesc() {
        return effctDesc;
    }

    /**
     * 设置讲座效果(讲座用)
     *
     * @param effctDesc 讲座效果(讲座用)
     */
    public void setEffctDesc(String effctDesc) {
        this.effctDesc = effctDesc;
    }

    /**
     * 获取分校意见与建议(讲座用)
     *
     * @return SUBSCHOOL_SUGGEST - 分校意见与建议(讲座用)
     */
    public String getSubschoolSuggest() {
        return subschoolSuggest;
    }

    /**
     * 设置分校意见与建议(讲座用)
     *
     * @param subschoolSuggest 分校意见与建议(讲座用)
     */
    public void setSubschoolSuggest(String subschoolSuggest) {
        this.subschoolSuggest = subschoolSuggest;
    }

    /**
     * 获取老师再次授课意见(讲座用)
     *
     * @return TEACH_AGAIN_SUGGESTION - 老师再次授课意见(讲座用)
     */
    public String getTeachAgainSuggestion() {
        return teachAgainSuggestion;
    }

    /**
     * 设置老师再次授课意见(讲座用)
     *
     * @param teachAgainSuggestion 老师再次授课意见(讲座用)
     */
    public void setTeachAgainSuggestion(String teachAgainSuggestion) {
        this.teachAgainSuggestion = teachAgainSuggestion;
    }

    /**
     * 获取反馈快照标题
     *
     * @return TITLE - 反馈快照标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置反馈快照标题
     *
     * @param title 反馈快照标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取反馈时间
     *
     * @return FEEDBACK_TIME - 反馈时间
     */
    public Date getFeedbackTime() {
        return feedbackTime;
    }

    /**
     * 设置反馈时间
     *
     * @param feedbackTime 反馈时间
     */
    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    /**
     * 获取创建人id
     *
     * @return CREATOR_ID - 创建人id
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取反馈界面快照
     *
     * @return SNAPSHOT - 反馈界面快照
     */
    public String getSnapshot() {
        return snapshot;
    }

    /**
     * 设置反馈界面快照
     *
     * @param snapshot 反馈界面快照
     */
    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }
}