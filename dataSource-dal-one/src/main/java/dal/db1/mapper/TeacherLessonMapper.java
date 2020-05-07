package dal.db1.mapper;

import dal.db1.entity.TeacherLesson;
import dal.db1.entity.TeacherLessonCriteria;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TeacherLessonMapper extends Mapper<TeacherLesson> {
    int deleteByFilter(TeacherLessonCriteria filter);

    void insertBatch(List<TeacherLesson> needInsertList);
}