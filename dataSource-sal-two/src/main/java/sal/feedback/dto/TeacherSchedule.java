package sal.feedback.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherSchedule implements Serializable {

    private static final long serialVersionUID = 6103247463501493820L;

    private String date1;

    private String date2;

    private String remark;

    private String liveDays;

    private String teacher;
}

