package sal.goods.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;



@Data
public class UserRespDto implements Serializable {

    private static final long serialVersionUID = -3543960608579545584L;

    private Long staffId;// 员工id

    private String staffNo;// 员工工号

    private String chineseName; // 员工姓名

    private String department;// 部门

    private String workEmail;

    private String avatar;

    private EnumDto genderEnum;

    private List<IdAndNameDto> roles;


}
