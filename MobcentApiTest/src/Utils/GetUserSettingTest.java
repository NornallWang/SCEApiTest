package Utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class GetUserSettingTest {

	//userGetsetting
	@Test
	public void checkApiConfigTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("https://bbs.appbyme.com/lornawang/upload/mobcent/app/web/index.php?r=user/login&password=MOBCENT%2540hacker%2523007&egnVersion=v2091.5&sdkVersion=2.5.0.0&isValidation=1&apphash=391a9711&username=MOBCENT%2540hacker%2523007&accessToken=b4788f18b7da6f71ae9d60eb16338&type=login&accessSecret=66b176249af02314125d0de64dc52&forumKey=QbqxoM65xkGgy0VDNr");
		System.out.println("----------------------------------------");  
		// 鎵撳嵃璇锋眰淇℃伅
        System.out.println(request.getRequestLine());
        try {
            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
            HttpResponse response = httpClient.execute(request);
 
            // 鎵撳嵃鍝嶅簲淇℃伅
            System.out.println(response.getStatusLine());
       //     HttpResponse response1 = httpclient.executeMethod(response1);
            String cont = EntityUtils.toString(response.getEntity());
            System.out.println(cont);
        } catch (ClientProtocolException e) {
            // 鍗忚閿欒
            e.printStackTrace();
        } catch (IOException e) {
            // 缃戠粶寮傚父
            e.printStackTrace();
        }
		
	}
}
