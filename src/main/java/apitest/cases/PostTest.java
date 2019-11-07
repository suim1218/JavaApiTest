package apitest.cases;

import apitest.config.TestConfig;
import apitest.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class PostTest {


    @Test(dataProvider = "loginData", description = "用户登录接口")
    public void login(String userName, String passWord, String result){
        // 声明url
        String url = TestConfig.loginUrl;

        // 定义参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        BasicNameValuePair basicNameValuePair1 = new BasicNameValuePair("username", userName);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("password", passWord);
        params.add(basicNameValuePair1);
        params.add(basicNameValuePair2);

        // 声明HttpUtils对象
        HttpUtils httpUtils = new HttpUtils();

        // 将返回值转换成Json格式
        String response = httpUtils.postListParams(params,url);
        JSONObject responseJson = new JSONObject(response);
        //断言
        Assert.assertEquals(responseJson.getString("message"), result);


    }

    @Test(dataProvider = "loginData", description = "用户登录接口")
    public void login2(String userName, String passWord, String result) {
        // 声明url

        String url = TestConfig.loginUrl2;

        // 定义参数
        JSONObject params = new JSONObject();
        params.put("username",userName);
        params.put("password",passWord);
//        System.out.println(params);

        // 声明HttpUtils对象
        HttpUtils httpUtils = new HttpUtils();

        // 将返回值转换成Json格式
        String response = httpUtils.postJsonParams(params,url);
        JSONObject responseJson = new JSONObject(response);
        //断言
        Assert.assertEquals(responseJson.getString("message"), result);


    }

    // 定义对象数组
    @DataProvider(name = "loginData")
    public Object[][] LoginData() {

        return new Object[][]{
                {"admin", "admin123456", "login success"},
                {"admin", "admin1234567", "username or password error"}
        };
    }
}
