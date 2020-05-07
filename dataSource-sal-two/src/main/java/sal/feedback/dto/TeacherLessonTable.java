package sal.feedback.dto;

import common.dto.EnumLongIDTypeDto;
import common.dto.EnumStringIDTypeDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TeacherLessonTable {

    Long lessonTableId;

    String lessonTableNo;

    EnumLongIDTypeDto teacherDevices;

    EnumStringIDTypeDto teacher;

    EnumLongIDTypeDto stage;

    EnumLongIDTypeDto subject;

    Date startTime;

    Date endTime;

    Long duration;

    Integer studentDeviceNum;

    Integer applyNum;

    Integer quitNum;

    Integer arrivedNum;

    Integer scoreNum;

    Integer score;

    List<String> lessonDateStrList;

    Integer hour;

    Integer minute;
}
