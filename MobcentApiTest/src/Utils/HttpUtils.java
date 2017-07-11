package Utils;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
	//get«Î«Û
	public static String doGet(String url,String charset){
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("Content-type", "application/json;charset="+charset);
		
		return null;
	}
	
	//∑¢ÀÕhttpRequest«Î«Û
	public static String sendRequest(HttpUriRequest httpUriRequest,String charset){
		HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(httpUriRequest);
			String responseContent = "";
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HttpStatus.SC_OK){
				HttpEntity responseEntity = response.getEntity();
				responseContent = EntityUtils.toString(responseEntity, charset);
				EntityUtils.consume(responseEntity);
			}else if(statusCode == HttpStatus.SC_MOVED_TEMPORARILY || statusCode == HttpStatus.SC_MOVED_PERMANENTLY){
				responseContent = response.getFirstHeader(responseContent).getValue();
			}else{
				
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return charset;
		
		
	}

}
