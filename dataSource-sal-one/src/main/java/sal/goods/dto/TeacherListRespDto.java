package sal.goods.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TeacherListRespDto implements Serializable {

    private static final long serialVersionUID = 7700472806153398756L;

    private List<TeacherListResp> list;

    private PageDto pageDto;
}
