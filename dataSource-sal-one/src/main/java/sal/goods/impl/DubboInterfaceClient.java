package sal.goods.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.huatu.shizi.service.dto.response.TeacherListResp;
import com.huatu.shizi.service.dto.response.TeacherListRespDto;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

@Component
public class DubboInterfaceClient {

    private static Method getMethod(Class<?> forName, QueryParamBO paramBO) {

        Method[] methods = forName.getMethods();
        for (Method m : methods) {
            if (paramBO.getMethodName().equals(m.getName())) {
                return m;
            }
        }

        return null;
    }

    private static Object initDubbo(ReferenceConfig reference, Class<?> forName, QueryParamBO paramBO) {

        reference.setApplication(new ApplicationConfig("paike-provider"));
        reference.setInterface(forName);
        reference.setUrl("dubbo://" + paramBO.getServerIp() + ":" + paramBO.getServerPort());
        reference.setTimeout(30000);
        Object o = reference.get();
        return o;
    }

    public static List<TeacherListResp> dubbo(Set<String> staffNo) {
        if (CollectionUtils.isEmpty(staffNo)) {
            return Lists.newArrayList();
        }

        //初始化参数
        String serviceInterface = "com.huatu.shizi.service.teacher.TeacherQueryService";
        //接口方法
        String methodName = "listStaffNos";
        //IP
        String serverIp = "172.30.70.58";
        // 端口
        String serverPort = "8081";
        // dubbo 引用
        ReferenceConfig reference = new ReferenceConfig();
        // 32883
        // 查询参数
        QueryParamBO paramBO = new QueryParamBO(serviceInterface, methodName, serverIp, serverPort);
            try {
            Class<?> forName = Class.forName(serviceInterface);
            // 1. 获取dubbo服务链接
            Object object = initDubbo(reference, forName, paramBO);
            // 2. 校验获取方法
            Method method = getMethod(forName, paramBO);

            // 3. 设置查询参数,接口中多个参数，使用数组形式赋值。
            Object[] objectArgs = new Object[1];

            objectArgs[0] = Lists.newArrayList(staffNo);
            paramBO.setObjectArgs(objectArgs);


            // 4. 指定方法，参数 调用dubbo接口方法
            Object invokeResult = method.invoke(object, paramBO.getObjectArgs());
            TeacherListRespDto respDto = (TeacherListRespDto) invokeResult;
            // 5. 打印参数调用结果
            System.out.println("invokeResult = [" + JSON.toJSONString(invokeResult) + "]");
            return respDto.getList();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
}

}
