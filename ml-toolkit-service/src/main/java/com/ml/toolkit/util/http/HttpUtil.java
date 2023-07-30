package com.ml.toolkit.util.http;

import com.ml.toolkit.common.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ml
 * @date 2023年02月08日 21:10
 */
@Slf4j
public class HttpUtil implements Serializable {

    private static final long serialVersionUID = -9130826395729257318L;

    public static <V> V post(String url, Map<String, String> param, Map<String, String> headers, HttpFun<V> fun) throws Exception {
        // 使用context方式
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> list = listByMap(param);
        UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(list, "UTF-8");
        httpPost.setEntity(postEntity);

        if (ObjectUtil.isNotEmpty(headers)) {
            for (String key : headers.keySet()) {
                httpPost.setHeader(key, headers.get(key));
            }
        }
        try {
            HttpResponse httpResponse = client.execute(httpPost);
            return fun.handlerHttpResponseCallback(httpResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流并释放资源
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<NameValuePair> listByMap(Map<String, String> param) {
        List<NameValuePair> list = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(param)) {
            for (String key : param.keySet()) {
                list.add(new BasicNameValuePair(key, param.get(key)));
            }
        }
        return list;
    }

    public static String findResponseContent(HttpResponse httpResponse) {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();

        // 判断响应实体是否为空
        if (entity != null) {
            try {
                return EntityUtils.toString(entity);
            } catch (IOException e) {
               log.error("findResponseContent error", e);
            }
        }
        return  null;
    }

}
