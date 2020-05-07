package dal.db1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Stage {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public static void main(String[] args) {
        char ch = '1';
        System.out.println(Integer.valueOf(ch));
        System.out.println(Integer.valueOf(ch - 48));
    }

}