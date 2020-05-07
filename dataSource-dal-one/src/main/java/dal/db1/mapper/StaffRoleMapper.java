package dal.db1.mapper;

import dal.db1.entity.StaffRole;
import dal.db1.entity.StaffRoleCriteria;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StaffRoleMapper extends Mapper<StaffRole> {
    int deleteByFilter(StaffRoleCriteria filter);

    void insertIntoBatch(List<StaffRole> list);
}