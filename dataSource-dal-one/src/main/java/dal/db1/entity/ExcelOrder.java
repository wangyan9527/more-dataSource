package dal.db1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "excel_order")
public class ExcelOrder {
    /**
     * id,自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 报名分部
     */
    private String department;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 商品编号
     */
    @Column(name = "goods_no")
    private String goodsNo;


//    private String goodsName;

    /**
     * 学员姓名
     */
    @Column(name = "student_name")
    private String studentName;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 成绩
     */
    private String score;

    /**
     * 商品编号
     */
    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "order_goods_id")
    private Long orderGoodsId;

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
     * 获取报名分部
     *
     * @return department - 报名分部
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置报名分部
     *
     * @param department 报名分部
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取订单编号
     *
     * @return order_no - 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单编号
     *
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取商品编号
     *
     * @return goods_no - 商品编号
     */
    public String getGoodsNo() {
        return goodsNo;
    }

    /**
     * 设置商品编号
     *
     * @param goodsNo 商品编号
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    /**
     * 获取学员姓名
     *
     * @return student_name - 学员姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置学员姓名
     *
     * @param studentName 学员姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取订单创建时间
     *
     * @return create_time - 订单创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取成绩
     *
     * @return score - 成绩
     */
    public String getScore() {
        return score;
    }

    /**
     * 设置成绩
     *
     * @param score 成绩
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * 获取商品编号
     *
     * @return goods_name - 商品编号
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品编号
     *
     * @param goodsName 商品编号
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}