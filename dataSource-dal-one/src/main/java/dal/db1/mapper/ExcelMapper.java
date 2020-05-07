package dal.db1.mapper;


import dal.db1.entity.Excel;
import dal.db1.entity.ExcelCriteria;
import dal.db1.entity.ExcelTemp;
import dal.db1.entity.Stage;
import dal.db1.entity.Subject;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ExcelMapper extends Mapper<ExcelTemp> {
    int deleteByFilter(ExcelCriteria filter);

    void insertBatch(List<Excel> excels);

    List<Stage> queryStageList();

    List<Subject> querySubjectList();

    List<Excel> queryStageId0();

    void insertBatchTemp(List<ExcelTemp> excels);
}