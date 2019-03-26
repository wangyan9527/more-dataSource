package web.dto;

public class ResultUtils {

    public static Result buildResult() {
        return new Result(0, null, null);
    }

    public static Result buildResult(Object data) {
        return new Result(0, null, data);
    }
}
