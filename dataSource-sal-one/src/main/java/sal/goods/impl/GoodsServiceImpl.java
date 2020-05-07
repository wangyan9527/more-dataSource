package sal.goods.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import	java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.huatu.shizi.service.dto.response.TeacherListResp;
import dal.db1.entity.Goods;
import dal.db1.entity.StaffRole;
import dal.db1.entity.TeacherLesson;
import dal.db1.mapper.GoodsMapper;
import dal.db1.mapper.StaffRoleMapper;
import dal.db1.mapper.TeacherLessonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sal.goods.GoodsService;
import sal.goods.dto.ApiResult;
import sal.goods.dto.DailyStatusDto2;
import sal.goods.dto.GoodsReqDto;
import sal.goods.dto.PageDto;
import sal.goods.dto.Param;
import sal.goods.dto.PkTeacherStatusReqDto;
import sal.goods.dto.PkTeacherStatusRespDto2;
import sal.goods.dto.UserRespDto;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long insertGoods(GoodsReqDto param) {
        param.validate();
        Goods goods = new Goods();
        goods.setName(param.getGoodsName());
        goods.setPrice(param.getPrice());
        goodsMapper.insertOne(goods);
        return goods.getId();
    }

    @Override
    public List<Goods> getGoodsListByName(String name) {
        if (StringUtils.isBlank(name)) {
            return Lists.newArrayList();
        }
        return goodsMapper.selectGoodsListByGoodsName(name);
    }

    @Override
    public void testTransactional() {
        log.info("test Transactional");

        // 使用新事务插入表中
        Long goodsId = insertGoods();

        Goods goods = goodsMapper.selectById(goodsId);
        System.out.println(goods);
    }

    @Transactional(rollbackFor = Exception.class)//propagation = Propagation.REQUIRES_NEW
    public Long insertGoods() {
        Goods goods = new Goods();
        goods.setName("testTransactional");
        goods.setPrice(100l);
        goodsMapper.insertOne(goods);
        return goods.getId();
    }

    @Autowired
    private StaffRoleMapper staffRoleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void queryAndInsertPost() throws IOException, InterruptedException {
        log.info("query and insert post");
        String url = "https://paike.huatu.com/user/list.json";
        Map<String, String> paramMap = Maps.newHashMap();
        PageDto pageDto = new PageDto();
        pageDto.setPageSize(40);
        int pageNum = 0;

        int totalPageNum = 1;
        do {
            pageDto.setPageNum(++pageNum);
            Param param = new Param();
            param.setPageDto(pageDto);
//            String result = getResult(url, param);
            String result = ";";
            ApiResult response = JSONObject.parseObject(result, ApiResult.class);
            List<UserRespDto> respDto = JSONObject.parseArray(response.getData().toString(), UserRespDto.class);
            List<StaffRole> list = Lists.newArrayList();
            for (UserRespDto dto : respDto) {
                StaffRole staffRole = new StaffRole();
                staffRole.setStaffId(dto.getStaffId());
                staffRole.setStaffName(dto.getChineseName());
                staffRole.setRoleNameArr(dto.getRoles().stream().map(p -> p.getName()).collect(Collectors.joining(",")));
                staffRole.setStaffNo(dto.getStaffNo());
                list.add(staffRole);
            }
            PageDto resultPageDto = response.getPageDto();
            totalPageNum = resultPageDto.getTotalPageNum();
            if (!CollectionUtils.isEmpty(list)) {
                staffRoleMapper.insertIntoBatch(list);
            }
            Thread.sleep(100);
        } while (totalPageNum >= pageNum);


    }

    @Autowired
    TeacherLessonMapper teacherLessonMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void queryAndInsertTeacher() throws InterruptedException {
        log.info("query and insert post");
        String url = "https://paike.huatu.com/teacher/teacherArrange.json";
        Map<String, String> paramMap = Maps.newHashMap();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PageDto pageDto = new PageDto();
        pageDto.setPageSize(40);
        List<TeacherLesson> needInsertList = Lists.newArrayList();
        int pageNum = 0;
        int totalPageNum = 1;
        do {
            pageDto.setPageNum(++pageNum);
            PkTeacherStatusReqDto reqDto = new PkTeacherStatusReqDto();
            reqDto.setSubjectId(7l);
            reqDto.setStartTime(new Date(1586880000000l));
            reqDto.setEndTime(new Date(1588780799000l));
            reqDto.setNodeId(1l);
            reqDto.setPageDto(pageDto);
            String result = getResult(url, reqDto);
            System.out.println("result=" + result);
            ApiResult response = JSONObject.parseObject(result, ApiResult.class);
//            System.out.println("api = " + response);
            List<PkTeacherStatusRespDto2> list = JSONObject.parseArray(response.getData().toString(), PkTeacherStatusRespDto2.class);
            Set<String> staffNos = list.stream().map(p -> p.getStaffNo()).collect(Collectors.toSet());
            List<TeacherListResp> staffList = DubboInterfaceClient.dubbo(staffNos);
            Map<String, TeacherListResp> staffMap = staffList.stream().collect(Collectors.toMap(p -> p.getStaffNo(), Function.identity()));
            for (PkTeacherStatusRespDto2 dto : list) {
                TeacherLesson lesson = new TeacherLesson();
                lesson.setChineseName(dto.getChineseName());
                lesson.setStaffNo(dto.getStaffNo());
                lesson.setTeacherUnitId(dto.getTeacherUnit().getId());
                lesson.setTeacherUnit(dto.getTeacherUnit().getName());
                List<String> dateList = dto.getSchedules().stream().filter(p -> p.getStatusEnum() != null && p.getStatusEnum().getId() == 1)
                        .map(p -> sdf.format(p.getDate())).distinct().collect(Collectors.toList());
                lesson.setLessonDateStr(dateList.stream().collect(Collectors.joining(",")));
                lesson.setTeacherType((long) staffMap.get(dto.getStaffNo()).getTypeEnum().getId());
                lesson.setTeacherTypeName(staffMap.get(dto.getStaffNo()).getTypeEnum().getName());
                needInsertList.add(lesson);
            }
//            System.out.println("list = " + list);
            if (!CollectionUtils.isEmpty(needInsertList)) {
                teacherLessonMapper.insertBatch(needInsertList);
            }
            Thread.sleep(1000);
            PageDto resultPageDto = response.getPageDto();
            totalPageNum = resultPageDto.getTotalPageNum();
        } while (totalPageNum >= pageNum);//totalPageNum >= pageNum


    }

    public String getResult(String url, PkTeacherStatusReqDto params){
        String returnValue = null;
        org.apache.http.client.HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 15000);
        try {
            HttpPost httppost = new HttpPost(url);
            httppost.addHeader("Content-Type","application/json;charset=UTF-8");
            httppost.addHeader("Cookie", "_const_huatu_jsession_id_=1588726296656.7ddf3439-2a19-4429-8234-ca0cfd16c453.paike.huatu.com/");
//            httppost.setHeader("Accept", "application/json");

            StringEntity entity = new StringEntity(JSONObject.toJSONString(params),Charset.forName("UTF-8"));
            httppost.setEntity(entity);

            System.out.println("请求地址："+url);
            System.out.println("请求参数："+params.toString());

            HttpResponse resp = httpclient.execute(httppost);
            if(resp.getStatusLine().getStatusCode() == 200) {
                HttpEntity he = resp.getEntity();
                String   respContent = EntityUtils.toString(he,"UTF-8");
                returnValue =  respContent;
            }
        }
        catch (SocketTimeoutException e) {
            e.printStackTrace();
            returnValue = "timeout";
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭连接,释放资源
            httpclient.getConnectionManager().shutdown();
        }
        return  returnValue;
    }

    public String send(String url, Map<String,String> map,String encoding) throws ParseException, IOException {
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

        System.out.println("请求地址："+url);
        System.out.println("请求参数："+nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
        httpPost.addHeader("Cookie", "_const_huatu_jsession_id_=1587959692275.c28f2db6-95ad-4d5e-9f35-1407618a4e2c.paike.huatu.com/");
//        httpPost.setHeader("Cookies", );


        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }



}
