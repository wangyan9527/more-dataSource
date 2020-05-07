package web.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StartAndEndIdDto implements Serializable {

    private static final long serialVersionUID = 247102199708418810L;

    private Long startId;

    private Long endId;
}
