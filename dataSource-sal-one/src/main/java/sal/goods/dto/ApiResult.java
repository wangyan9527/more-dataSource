package sal.goods.dto;

import lombok.Data;

@Data
public class ApiResult {

    private String code;

    private String msg;

    private Object data;

    private PageDto pageDto;

}
