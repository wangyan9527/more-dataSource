package dal.db1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TEACHER")
public class Teacher {

    /**
     * 自增ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_no")
    private String staffNo;

    @Column(name = "teacher_unit_id")
    private Long teacherUnitId;

    @Column(name = "chinese_name")
    private String chineseName;

    @Column(name = "name")
    private String name;


}
