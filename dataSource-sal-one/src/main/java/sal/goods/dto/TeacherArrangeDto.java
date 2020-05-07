
package sal.goods.dto;

import common.dto.EnumLongIDTypeDto;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherArrangeDto {
    /**
     * 班级ID
     */
    Long classId;
    /**
     * 授课类型
     */
    EnumLongIDTypeDto teachWay;

    /**
     * 老师类型
     */
    EnumLongIDTypeDto teacherType;
    /**
     * 阶段ID
     */
    Long stageId;
    /**
     * 阶段名称
     */
    String stageName;
    /**
     * 所上课节ID
     */
    Long lessonId;
    /**
     * 所上科目ID
     */
    Long subjectId;
    /**
     * 科目名称
     */
    String subjectName;
    /**
     * 课节明细ID
     */
    Long timeDetailId;
    /**
     * 上课起始时间
     */
    Date startTime;
    /**
     * 上课结束时间
     */
    Date endTime;
    /**
     * 教室ID
     */
    Long roomId;
    
    String city;
}
