package dal.db2.mapper;

import dal.db2.entity.ClassStageSubjectTeacherDto;
import dal.db2.entity.CsstCount;
import dal.db2.entity.CsstDto;
import dal.db2.entity.CsstQuitOrderDto;
import dal.db2.entity.OrderNoDto;
import dal.db2.entity.OrderTeacherDto;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;
import java.util.List;

public interface CsstMapper extends Mapper<CsstQuitOrderDto> {

    List<CsstQuitOrderDto> queryQuitOrderNo(Collection<ClassStageSubjectTeacherDto> dtos);

    List<CsstDto> queryTeacherNo(Collection<ClassStageSubjectTeacherDto> dtos);

    List<CsstCount> querySomeOrder(Collection<ClassStageSubjectTeacherDto> dtos);

    List<String> queryTeacherNoByCssbId(@Param("classId") Long classId, @Param("stageId")Long stageId,
                                        @Param("subjectId")Long subjectId, @Param("batchNum")Integer batchNum);

    List<OrderTeacherDto> queryOrderTeacherList(Collection<String> orderNoList);

    List<OrderNoDto> queryOrderList(Collection<String> orderNoList);
}
