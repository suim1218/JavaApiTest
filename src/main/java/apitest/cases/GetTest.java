package apitest.cases;


import apitest.config.TestConfig;
import apitest.utils.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GetTest {

    @Test(dataProvider = "titleData", description = "查询接口")
    public void getArticle(String title, String result){
        // 声明url
        String url = TestConfig.getArticleUrl;

        // 定义参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        BasicNameValuePair basicNameValuePair1 = new BasicNameValuePair("title", title);
        params.add(basicNameValuePair1);

        // 生成URL
        String paramsString = URLEncodedUtils.format(params,"UTF-8");

        // 声明HttpUtils对象
        HttpUtils httpUtils = new HttpUtils();
        String response = httpUtils.doGet(paramsString,url);

        // 将返回值转换成Json格式
        JSONObject responseJson = new JSONObject(response);
//        System.out.println(responseJson);
        //断言
        Assert.assertEquals(responseJson.getString("message"), result);


    }
    // 定义对象数组
    @DataProvider(name = "titleData")
    public Object[][] LoginData() {
        return new Object[][]{
                {"", "success"},
                {"aaa", "query result is empty"}
        };
    }
}
