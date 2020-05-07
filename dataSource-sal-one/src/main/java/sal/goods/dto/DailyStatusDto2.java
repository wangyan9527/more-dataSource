
package sal.goods.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DailyStatusDto2 {
    /**
     * 老师编号
     */
    private String staffNo;
    // 日期
    private Date date;

    String dateStr;

    // 状态
    private EnumDto statusEnum;

    // 请假状态
    private IdAndNameDto vacationType;

    // 上课地点
    private List<TeacherArrangeDto> subjects;
}
