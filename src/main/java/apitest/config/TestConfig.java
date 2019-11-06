package apitest.config;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;


public class TestConfig {

    //登陆接口uri
    public static String address = "http://localhost:8001";
    public static String loginUri = "/login";
    public static String loginUrl = address + loginUri;

    //用来存储cookies信息的变量
    public static CookieStore store;

    //声明http客户端
//    public static DefaultHttpClient defaultHttpClient;
    public static HttpClient client;
    // 数据库配置
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://localhost:3306/blog";
    public static String USER = "root";
    public static String PASSWORD = "";

}
