package sal.goods.impl;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryParamBO implements Serializable {
    private static final long serialVersionUID = -4881240380958595368L;

    String serviceInterface;

    String methodName;

    String serverIp;

    String serverPort;


    Object[] objectArgs;


    public QueryParamBO(){}

    public QueryParamBO(String serviceInterface, String methodName, String serverIp, String serverPort) {
        this.serviceInterface = serviceInterface;
        this.methodName = methodName;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }
}
