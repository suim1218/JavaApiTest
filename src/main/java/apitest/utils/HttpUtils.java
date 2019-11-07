package apitest.utils;

import apitest.config.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.net.URI;
import java.util.List;

public class HttpUtils {
    /**
     *
     * @param params 接口参数
     * @param url 接口请求地址
     * @return
     */
    public static String postListParams(List params, String url){
        // 接口响应数据
        String result = "";
        // 创建HttpClient对象
        HttpClient client = HttpClientBuilder.create().build();
        // 创建HttpPost对象，以post方式提交接口请求
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            //声明一个对象来进行响应结果的存储
            HttpResponse response = client.execute(httpPost);
            //获取响应结果将格式转化为String数据
            result = EntityUtils.toString(response.getEntity(), "utf-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String postJsonParams(JSONObject params, String url){
        // 接口响应数据
        String result = "";
        // 创建HttpClient对象
        HttpClient client = HttpClientBuilder.create().build();
        // 创建HttpPost对象，以post方式提交接口请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("content-type","application/json");
        try {
            httpPost.setEntity(new StringEntity(params.toString(),"utf-8"));
//            System.out.println(params.getClass());
            //声明一个对象来进行响应结果的存储
            HttpResponse response = client.execute(httpPost);
            //获取响应结果将格式转化为String数据
            result = EntityUtils.toString(response.getEntity(), "utf-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String doGet(String params, String url){
        // 接口响应数据
        String result = "";
        // 创建HttpClient对象
        HttpClient client = HttpClientBuilder.create().build();
        // 创建HttpPost对象，以post方式提交接口请求
        HttpGet httpGet = new HttpGet();
        url +=("?"+params);
//        System.out.println(url);
        try {
            httpGet.setURI(new URI(url));
            //声明一个对象来进行响应结果的存储
            HttpResponse response = client.execute(httpGet);
            //获取响应结果将格式转化为String数据
            result = EntityUtils.toString(response.getEntity(), "utf-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
