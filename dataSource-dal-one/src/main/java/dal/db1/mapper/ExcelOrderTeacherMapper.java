package dal.db1.mapper;


import dal.db1.entity.ExcelOrderTeacher;
import dal.db1.entity.ExcelOrderTeacherCriteria;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ExcelOrderTeacherMapper extends Mapper<ExcelOrderTeacher> {
    int deleteByFilter(ExcelOrderTeacherCriteria filter);

    void insertBatch(List<ExcelOrderTeacher> excelOrderTeacherList);
}