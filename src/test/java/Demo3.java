
import com.wlqk.cn.GunsApplication;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: zc
 * @CreateDate: 2019/7/30 16:59
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = GunsApplication.class)
//@WebAppConfiguration
public class Demo3 {
    //配置您申请的KEY
    public  final String APPKEY = "3ca901b7f62bcb2bece4f4f7589c510f";
    public  final String url = "http://v.juhe.cn/sms/send";//请求接口地址
    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            String codeNum = RandomUtil.randomNumbers(6);
            Map params = new HashMap();//请求参数
            params.put("mobile", "15275041535");//接收短信的手机号码
            params.put("tpl_id", "144129");//短信模板ID，请参考个人中心短信模板设置
            params.put("tpl_value", "#code#=" + "999999");//变量名和变量值对。如果你的变量名或者变量值中带有#&=中的任意一个特殊符号，请先分别进行urlencode编码后再传递，<a href=" " target="_blank">详细说明></a >
            params.put("key", APPKEY);//应用APPKEY(应用详细页查询)
            String result = HttpUtil.post(url, params);
        }
    }


    public static String Get(String httpUrl) throws IOException {
        // 发送http请求数据
        String url = "http://"+""+":"+"15672"+httpUrl;
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // 设置BasicAuth
        CredentialsProvider provider = new BasicCredentialsProvider();
        // Create the authentication scope
        AuthScope scope = new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT, AuthScope.ANY_REALM);
        // Create credential pair，在此处填写用户名和密码
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("", "");
        // Inject the credentials
        provider.setCredentials(scope, credentials);
        // Set the default credentials provider
        httpClientBuilder.setDefaultCredentialsProvider(provider);
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        String result = "";
        HttpGet httpGet = null;
        HttpResponse httpResponse = null;
        org.apache.http.HttpEntity entity = null;
        httpGet = new HttpGet(url);
        try {
            httpResponse = closeableHttpClient.execute(httpGet);
            entity = httpResponse.getEntity();
            if( entity != null ){
                result = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 关闭连接
        closeableHttpClient.close();

        return result;
    }

    @Test
    public void test2(){
        Map params = new HashMap();//请求参数
        params.put("projectId","1111111111");
        params.put("investorId","2222222222");
        params.put("loginUserId","222");
        String result = HttpUtil.get("http://192.168.0.2:15672/api/exchanges/%2F/Explain_TopicExchange/bindings/destination");
        System.out.println(result);
    }

}
