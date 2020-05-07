package dal.db1.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "teacher_lesson")
public class TeacherLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 中文名
     */
    @Column(name = "chinese_name")
    private String chineseName;

    /**
     * 员工工号
     */
    @Column(name = "staff_no")
    private String staffNo;

    /**
     * 师资单元ID
     */
    @Column(name = "teacher_unit_id")
    private Long teacherUnitId;

    /**
     * 师资单元
     */
    @Column(name = "teacher_unit")
    private String teacherUnit;

    /**
     * 教师类型
     */
    @Column(name = "teacher_type")
    private Long teacherType;

    /**
     * 教师类型
     */
    @Column(name = "teacher_type_name")
    private String teacherTypeName;

    /**
     * 上课日期
     */
    @Column(name = "lesson_date_str")
    private String lessonDateStr;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取中文名
     *
     * @return chinese_name - 中文名
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * 设置中文名
     *
     * @param chineseName 中文名
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
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
     * 获取师资单元ID
     *
     * @return teacher_unit_id - 师资单元ID
     */
    public Long getTeacherUnitId() {
        return teacherUnitId;
    }

    /**
     * 设置师资单元ID
     *
     * @param teacherUnitId 师资单元ID
     */
    public void setTeacherUnitId(Long teacherUnitId) {
        this.teacherUnitId = teacherUnitId;
    }

    /**
     * 获取师资单元
     *
     * @return teacher_unit - 师资单元
     */
    public String getTeacherUnit() {
        return teacherUnit;
    }

    /**
     * 设置师资单元
     *
     * @param teacherUnit 师资单元
     */
    public void setTeacherUnit(String teacherUnit) {
        this.teacherUnit = teacherUnit;
    }

    /**
     * 获取教师类型
     *
     * @return teacher_type - 教师类型
     */
    public Long getTeacherType() {
        return teacherType;
    }

    /**
     * 设置教师类型
     *
     * @param teacherType 教师类型
     */
    public void setTeacherType(Long teacherType) {
        this.teacherType = teacherType;
    }

    /**
     * 获取上课日期
     *
     * @return lesson_date_str - 上课日期
     */
    public String getLessonDateStr() {
        return lessonDateStr;
    }

    /**
     * 设置上课日期
     *
     * @param lessonDateStr 上课日期
     */
    public void setLessonDateStr(String lessonDateStr) {
        this.lessonDateStr = lessonDateStr;
    }
}