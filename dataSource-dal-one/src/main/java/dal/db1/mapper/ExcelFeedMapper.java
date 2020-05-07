package dal.db1.mapper;


import dal.db1.entity.ExcelFeed;
import dal.db1.entity.ExcelFeedCriteria;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ExcelFeedMapper extends Mapper<ExcelFeed> {

    void insertBatch(List<ExcelFeed> list);

}