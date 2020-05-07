package dal.db1.mapper;


import dal.db1.entity.ExcelOrder;
import dal.db1.entity.ExcelOrderCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ExcelOrderMapper extends Mapper<ExcelOrder> {
    int deleteByFilter(ExcelOrderCriteria filter);

    List<ExcelOrder> queryList(@Param("startIndex") Long startIndex, @Param("endIndex") Long endIndex);
}