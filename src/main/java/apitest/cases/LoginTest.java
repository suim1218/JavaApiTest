package apitest.cases;

import apitest.config.TestConfig;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class LoginTest {

    final static Logger Log = Logger.getLogger(String.valueOf(LoginTest.class));

    @BeforeTest(description = "测试准备工作,获取HttpClient对象")
    public void beforeTest() {
        TestConfig.client = HttpClientBuilder.create().build();

    }


    @Test(dataProvider = "loginData", description = "用户登录接口")
    public void login(String username, String password, String result) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        BasicNameValuePair basicNameValuePair1 = new BasicNameValuePair("username", username);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("password", password);
        params.add(basicNameValuePair1);
        params.add(basicNameValuePair2);
        Log.info("参数是：【"+params+"】");

        //将参数信息添加到方法中
        StringEntity entity = new UrlEncodedFormEntity(params);
        //执行post方法
        try {
            post.setEntity(entity);
            //声明一个对象来进行响应结果的存储
            HttpResponse response = TestConfig.client.execute(post);
            //获取响应结果将格式转化为Json数据
            String response2 = EntityUtils.toString(response.getEntity(), "utf-8");
            JSONObject responseJson = new JSONObject(response2);
            //断言
            Assert.assertEquals(responseJson.getString("message"), result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 定义对象数组
    @DataProvider(name = "loginData")
    public Object[][] LoginData() {
        return new Object[][]{
                {"admin", "admin1234561", "login success"},
                {"admin", "admin1234567", "username or password error"}
        };
    }
}





