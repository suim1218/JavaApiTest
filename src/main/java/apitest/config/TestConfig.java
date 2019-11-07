package apitest.config;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;


public class TestConfig {

    //登陆接口uri
    public static String address = "http://localhost:8002";
    public static String loginUri = "/login";
    public static String loginUri2 = "/login2";
    public static String getArticleUri = "/get_article";
    public static String loginUrl = address + loginUri;
    public static String loginUrl2 = address + loginUri2;
    public static String getArticleUrl = address + getArticleUri;

    //用来存储cookies信息的变量
    public static CookieStore store;

    //声明http客户端
//    public static DefaultHttpClient defaultHttpClient;
//    public static HttpClient client;
    public static CloseableHttpClient client;

    // 数据库配置
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://localhost:3306/blog";
    public static String USER = "root";
    public static String PASSWORD = "";

}
