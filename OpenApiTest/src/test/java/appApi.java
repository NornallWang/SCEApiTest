import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class appApi {
	@Test
	//user login
	public void userLoginTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://bbs.appbyme.com/dzx31g/mobcent/app/web/index.php?r=user/login&username=admin&password=admin&type=login");
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
	@Test
	//get config 鑾峰彇app鐨勭浉鍏抽厤缃俊鎭�
	public void checkApiConfigTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://api.cloudscape.sohuce.com/apps/215530131/config?access_token=f26675de178eed0e72cba11e98108210");
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

	@Test
	//妫�煡apps
	public void checkApiAppsTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://api.cloudscape.sohuce.com/apps?access_token=f26675de178eed0e72cba11e98108210");
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
	@Test
	//妫�煡app 10446
	public void checkApiAppTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://api.cloudscape.sohuce.com/apps/215530131?access_token=f26675de178eed0e72cba11e98108210");
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
	
	@Test
	//鏂板缓app
	public void createAppTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		   // 鐩爣鍦板潃   
	     HttpPost httppost = new HttpPost("http://api.cloudscape.sohuce.com/apps?access_token=f26675de178eed0e72cba11e98108210");   
	     System.out.println("璇锋眰: " + httppost.getRequestLine());
	     System.out.println("----------------------------------------");  
	    // 鏋勯�鏈�畝鍗曠殑瀛楃涓叉暟鎹�  
	     StringEntity reqEntity = new StringEntity("name=newebapp&is_test=false&description=test");   
	    // 璁剧疆绫诲瀷   
	     reqEntity.setContentType("application/x-www-form-urlencoded");   
	    // 璁剧疆璇锋眰鐨勬暟鎹�  
	     httppost.setEntity(reqEntity);   
	     
        try {
            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
            HttpResponse response = httpClient.execute(httppost);
 
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
	@Test
	//鍒楀嚭鎸囧畾APP鐨勫疄渚嬪垪琛�
	public void checkApiInstancesTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://api.cloudscape.sohuce.com/apps/215530131/instances?access_token=f26675de178eed0e72cba11e98108210");
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
	@Test
	// 鍋滄app锛屽嵆鍋滄璇ュ簲鐢ㄤ笅鎵�湁鐨勫疄渚嬪鍣�
	public void stopAppTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		   // 鐩爣鍦板潃   
	     HttpPost httppost = new HttpPost("http://api.cloudscape.sohuce.com/apps/215530131/stop?access_token=f26675de178eed0e72cba11e98108210");   
	     System.out.println("璇锋眰: " + httppost.getRequestLine());
	     System.out.println("----------------------------------------");  
	    // 鏋勯�鏈�畝鍗曠殑瀛楃涓叉暟鎹�  
	     StringEntity reqEntity = new StringEntity("appid=10446");   
	    // 璁剧疆绫诲瀷   
	     reqEntity.setContentType("application/x-www-form-urlencoded");   
	    // 璁剧疆璇锋眰鐨勬暟鎹�  
	     httppost.setEntity(reqEntity);   
	     
        try {
            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
            HttpResponse response = httpClient.execute(httppost);
 
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
	@Test
	// 鎸囧畾鐗堟湰閲嶅惎app
	public void restartAppTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		   // 鐩爣鍦板潃   
	     HttpPost httppost = new HttpPost("http://api.cloudscape.sohuce.com/apps/215530131/restart?access_token=f26675de178eed0e72cba11e98108210");   
	     System.out.println("璇锋眰: " + httppost.getRequestLine());
	     System.out.println("----------------------------------------");  
	    // 鏋勯�鏈�畝鍗曠殑瀛楃涓叉暟鎹�  
	     StringEntity reqEntity = new StringEntity("appid=10446&version=1");   
	    // 璁剧疆绫诲瀷   
	     reqEntity.setContentType("application/x-www-form-urlencoded");   
	    // 璁剧疆璇锋眰鐨勬暟鎹�  
	     httppost.setEntity(reqEntity);   
	     
        try {
            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
            HttpResponse response = httpClient.execute(httppost);
 
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
	@Test
	// 鍐呴儴鎺ュ彛锛屽仠姝㈠疄渚�
	public void stopInstancesTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		   // 鐩爣鍦板潃   
	     HttpPost httppost = new HttpPost("http://api.cloudscape.sohuce.com/instances/ab376680-6324-11e4-8b55-00163e482fd9/stop?access_token=f26675de178eed0e72cba11e98108210");   
	     System.out.println("璇锋眰: " + httppost.getRequestLine());
	     System.out.println("----------------------------------------");  

	     
        try {
            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
            HttpResponse response = httpClient.execute(httppost);
 
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
	@Test
	// 閲嶅惎瀹炰緥锛岃繘绋嬬骇鍒殑閲嶅惎
	public void restartInstancesTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		   // 鐩爣鍦板潃   
	     HttpPost httppost = new HttpPost("http://api.cloudscape.sohuce.com/instances/ab376680-6324-11e4-8b55-00163e482fd9/restart?access_token=f26675de178eed0e72cba11e98108210");   
	     System.out.println("璇锋眰: " + httppost.getRequestLine());
	     System.out.println("----------------------------------------");  
  
	     
        try {
            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
            HttpResponse response = httpClient.execute(httppost);
 
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
	@Test
	//鍒犻櫎瀹炰緥
	public void deleteInstancesTest()throws ClientProtocolException, IOException{

		HttpClient httpClient = new DefaultHttpClient();
		HttpDelete delete = new HttpDelete("http://api.cloudscape.sohuce.com/instances/ab376680-6324-11e4-8b55-00163e482fd9/?access_token=f26675de178eed0e72cba11e98108210");

	        System.out.println("璇锋眰: " + delete.getRequestLine());
		     System.out.println("----------------------------------------");  
	  
		     
	        try {
	            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
	        	HttpResponse response = new DefaultHttpClient().execute(delete);
	           
	 
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
    
	@Test
	//鑾峰彇褰撳墠app鎵�湁鐨勭増鏈俊鎭�
	public void checkApiVersionTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://api.cloudscape.sohuce.com/apps/215530131/versions?access_token=f26675de178eed0e72cba11e98108210");
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
	@Test
	// 閲嶅惎瀹炰緥锛岃繘绋嬬骇鍒殑閲嶅惎
	public void restartAPPTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		   // 鐩爣鍦板潃   
	     HttpPost httppost = new HttpPost("http://api.cloudscape.sohuce.com/apps/215530131/restart?access_token=f26675de178eed0e72cba11e98108210");   
	     System.out.println("璇锋眰: " + httppost.getRequestLine());
	     System.out.println("----------------------------------------");  
  
	     
        try {
            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
            HttpResponse response = httpClient.execute(httppost);
 
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
	@Test
	//鑾峰彇褰撳墠app鎵�嫢鏈夌殑鎵�湁鍩熷悕
	public void getDomainTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://api.cloudscape.sohuce.com/apps/215530131/domains?access_token=f26675de178eed0e72cba11e98108210");
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
	@Test
	public void cleanDomainTest()throws ClientProtocolException, IOException{
	
        //鏋勯�HttpClient鐨勫疄渚�
		HttpClient httpClient = new DefaultHttpClient();
		HttpDelete delete = new HttpDelete("http://api.cloudscape.sohuce.com/apps/215530131/domains/clean?access_token=f26675de178eed0e72cba11e98108210");
		
 
	        System.out.println("璇锋眰: " + delete.getRequestLine());
		     System.out.println("----------------------------------------");  

	        try {
	            // 鍙戦�璇锋眰锛岃繑鍥炲搷搴�
	        	HttpResponse response = new DefaultHttpClient().execute(delete);
	           
	 
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
	@Test


	//check abtest
	public void checkAbtestTest()throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		HttpUriRequest request = new HttpGet("http://api.cloudscape.sohuce.com/apps/215530131/versions/abtest?access_token=f26675de178eed0e72cba11e98108210");
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
