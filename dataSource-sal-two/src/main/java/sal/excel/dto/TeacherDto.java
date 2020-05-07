package sal.excel.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import sal.feedback.dto.WriteInterview;

import java.util.List;


@Data
public class TeacherDto {

    private Long feedbackId;

    private Long classId;

    private Long stageId;

    private List<Long> stageIdList;

    private List<Long> subjectIdList;

    private String stageName;

    private Long subjectId;

    private Integer batchNum;

    private String subjectName;

    private String teacherNo;

    private List<String> teacherNoList;

    private String teacherName;

    private String teacherType;

    private Integer studentNum;// 上课人数

    private Integer quitNum;

    private String startTime;

    private String endTime;

    private String duration;

    private String trouble;// 是否教学事故

    private String score;// 分数

    private Long teacherUnitId;// 老师事业部

    public void buildDetailWithWriteInterview(WriteInterview w) {
        if (w != null) {
            if (StringUtils.isNotBlank(w.getHours())) {
                this.duration = Integer.valueOf(w.getHours()) / 60 + "时" + Integer.valueOf(w.getHours()) % 60 + "分";
            }
            if (StringUtils.isNotBlank(w.getSubject())) {
                this.subjectName = w.getSubject();
            }
            if (StringUtils.isNotBlank(w.getTeacher())) {
                w.setTeacher(StringUtils.trim(w.getTeacher()));
                this.teacherName = w.getTeacher();
            } else {
                this.teacherName = "";
            }
            if (StringUtils.isNotBlank(w.getTeacherType())) {
                this.teacherType = Integer.valueOf(w.getTeacherType()) == 1? "主讲":"助教";
            }
            if (StringUtils.isNotBlank(w.getTeacherTypeName())) {
                this.teacherType = w.getTeacherTypeName();
            }
            if (StringUtils.isNotBlank(w.getStageName())) {
                this.stageName = w.getStageName();
            }
            if (StringUtils.isNotBlank(w.getStartTime())) {
                this.startTime = w.getStartTime();
            }
            if (StringUtils.isNotBlank(w.getEndTime())) {
                this.endTime = w.getEndTime();
            }
            if (StringUtils.isNotBlank(w.getRealNum())) {
                this.studentNum = Integer.valueOf(w.getRealNum());
            } else {
                this.studentNum = 0;
            }
            if (StringUtils.isNotBlank(w.getQuitNum())) {
                this.quitNum = Integer.valueOf(w.getQuitNum());
            } else {
                this.quitNum = 0;
            }
            if (StringUtils.isNotBlank(w.getScore())) {
                this.score = w.getScore();
            } else {
                this.score = "0";
            }
            if (StringUtils.isNotBlank(w.getTrouble())) {
                this.trouble = Integer.valueOf(w.getTrouble()) == 1 ? "是":"否";
            }

        }
    }





}
