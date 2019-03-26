package web.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -7249032799476987349L;

    private long code;

    private String msg;

    private Object data;

    // 分页等其他参数

    public Result(long code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }
}
