package dal.db2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassStageSubjectTeacherDto {

    private Long classId;

    private Long stageId;

    private Long subjectId;

    private Integer batchNum;

    private String teacherNo;

    public ClassStageSubjectTeacherDto(Long classId, Long stageId, Long subjectId, Integer batchNum) {
        this.classId = classId;
        this.stageId = stageId;
        this.subjectId = subjectId;
        this.batchNum = batchNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassStageSubjectTeacherDto that = (ClassStageSubjectTeacherDto) o;
        return Objects.equals(classId, that.classId) &&
                Objects.equals(stageId, that.stageId) &&
                Objects.equals(subjectId, that.subjectId) &&
                Objects.equals(batchNum, that.batchNum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classId, stageId, subjectId, batchNum);
    }
}
