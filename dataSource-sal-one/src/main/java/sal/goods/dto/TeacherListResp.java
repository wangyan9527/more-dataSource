package sal.goods.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TeacherListResp implements Serializable {
    private static final long serialVersionUID = 2541398643775561024L;

    private String staffNo;

    private String chineseName;

    private String aliasName;

    private String idCardNo;

    private EnumDto genderEnum;

    private String mobile;

    private IdAndNameDto teacherUnit;

    private IdAndNameDto businessUnit;

    private EnumDto typeEnum;

    private Long areaId;

    private Date graduateTime;

    private String highestGraduateSchool;

    private String highestMajor;

    private EnumDto highestDegreeEnum;

    private String firstGraduateSchool;

    private String firstMajor;

    private String avatar;

    private String address;

    private String ehrNodeCode;
}
