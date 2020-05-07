package sal.feedback.dto;

import lombok.Data;

import java.util.List;

@Data
public class AssisTeacherData {

    List<TeacherDataAssisDto> teacherData;

    List<TripData> tripData;
}
