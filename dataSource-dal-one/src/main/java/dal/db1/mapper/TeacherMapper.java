package dal.db1.mapper;

import dal.db1.entity.Teacher;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TeacherMapper extends Mapper<Teacher> {

    List<Teacher> queryByNameList(Collection<String> nameList);

    List<Teacher> getAll();
}
