/**
 * Huatu.com Inc. Copyright (c) 2014-2018 All Rights Reserved.
 */
package sal.goods.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 教师动态
 * 
 * @title TeachingStatusRespDto
 * @author yanmaoyuan
 * @date 2018年7月26日
 * @version 1.0
 */
@Data
public class PkTeacherStatusRespDto2 implements Serializable {

    private static final long serialVersionUID = 2494930121068450230L;
    // 工号
    private String staffNo;
    // 姓名
    private String chineseName;
    // 化名
    private String aliasName;
    // 电话
    String mobile;
    // 居住地
    String address;
    // 性别
    private EnumDto genderEnum;
    // 分校/师资单元
    private IdAndNameDto teacherUnit;
    // 事业部
    private IdAndNameDto businessUnit;
    // 头像
    private String avatar;
    // 动态
    private List<DailyStatusDto2> schedules;

}