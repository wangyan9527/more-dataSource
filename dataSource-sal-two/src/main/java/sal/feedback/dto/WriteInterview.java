package sal.feedback.dto;


import lombok.Data;

import java.util.List;

@Data
public class WriteInterview {

    private String applyNum;

    private String hours;

    private String subject;

    private String teacher;

    private String teacherType;

    private String teacherTypeName;

    private String stageName;

    private String startTime;

    private String endTime;

    private String realNum;

    private String location;

    private String surveyNum;

    private String quitNum;

    private String score;

    private String trouble;

    private List<String> time;
}

