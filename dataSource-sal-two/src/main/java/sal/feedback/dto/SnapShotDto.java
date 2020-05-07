package sal.feedback.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SnapShotDto implements Serializable {

    private static final long serialVersionUID = -867591044824674524L;

    private String title;

    private String workUnit;

    private String year;

    private String month;

    private String day;

    private String allGoodsNos;

    private String remark;

    private String studentComment;

    private String effectDesc;

    private String quitReason;// 退班原因

    private String subSchoolSuggest;

    private String teachAgainSuggestion;

    private List<TeacherSchedule> teacherScheduleList;

    private List<WriteInterview> writeInterviewList;

    private List<GoodsDurationDto> goodsDurationList;
}

