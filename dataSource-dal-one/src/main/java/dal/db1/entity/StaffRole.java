package dal.db1.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "staff_role")
public class StaffRole {
    /**
     * id,自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 员工id
     */
    @Column(name = "staff_id")
    private Long staffId;

    /**
     * 员工姓名
     */
    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_no")
    private String staffNo;

    /**
     * 角色列表
     */
    @Column(name = "role_name_arr")
    private String roleNameArr;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取id,自增
     *
     * @return id - id,自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id,自增
     *
     * @param id id,自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取员工id
     *
     * @return staff_id - 员工id
     */
    public Long getStaffId() {
        return staffId;
    }

    /**
     * 设置员工id
     *
     * @param staffId 员工id
     */
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取员工姓名
     *
     * @return staff_name - 员工姓名
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置员工姓名
     *
     * @param staffName 员工姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 获取角色列表
     *
     * @return role_name_arr - 角色列表
     */
    public String getRoleNameArr() {
        return roleNameArr;
    }

    /**
     * 设置角色列表
     *
     * @param roleNameArr 角色列表
     */
    public void setRoleNameArr(String roleNameArr) {
        this.roleNameArr = roleNameArr;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}