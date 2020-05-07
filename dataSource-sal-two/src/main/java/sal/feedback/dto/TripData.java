package sal.feedback.dto;

import common.dto.EnumStringIDTypeDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TripData {

    Integer batchNum;

    Long stageId;

    String stageName;

    Integer stageType;

    Integer subjectStatus;

    Long subjectId;

    String subjectName;

    Long tripId;

    EnumStringIDTypeDto teacher;

    Date startTime;

    Date endTime;

    String liveDays;

    String remark;

    String cascader;

    List<Date> date;
}
