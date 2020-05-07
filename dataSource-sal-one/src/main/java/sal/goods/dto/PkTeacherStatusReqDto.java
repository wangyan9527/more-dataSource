/**
 * Huatu.com Inc. Copyright (c) 2014-2018 All Rights Reserved.
 */
package sal.goods.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师动态请求参数
 * 
 * @title TeacherStatusReqDto
 * @author yanmaoyuan
 * @date 2018年7月26日
 * @version 1.0
 */
@Data
public class PkTeacherStatusReqDto implements Serializable {

    private static final long serialVersionUID = -4641670671059300908L;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 分校/师资
    private Long nodeId;
    // 事业部
    private Long businessUnitId;
    // 科目组ID
    private Long subjectGroupId;
    // 科目ID
    private Long subjectId;
    // 教师类型
    private Integer teacherType;
    // 姓名、化名、工号
    private String teacherQuery;
    // 老师级别
    private Long gradeId;

    // 分页查询参数
    private PageDto pageDto;
}