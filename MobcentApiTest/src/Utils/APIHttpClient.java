package Utils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class APIHttpClient {
	
	//�ӿڵ�ַ
	private String apiURL = "http://coreapi-app.v2.yoo.yunpro.cn/app";
	private Log Logger = LogFactory.getLog(this.getClass());
	private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
	
	private HttpClient httpClient = null;
	private HttpPost httpPost = null;
	
	private long startTime = 0L;
	private long endTime = 0L;
	private int status = 0;
	
	/**
	 * �ӿڵ�ַ
	 * @param url
	 */
	public APIHttpClient(String url){
		if(url != null){
			this.apiURL = url;
		}
		if(apiURL != null){
			httpClient = new DefaultHttpClient();
			httpPost = new HttpPost(apiURL);
		}
	}
	
	@SuppressWarnings("deprecation")
	public String doPostWithJson(String parameters){
		String body = null;
		Logger.info("parameters:"+parameters);
		
		if(httpPost!=null&parameters!=null&&"".equals(parameters.trim())){
			JSONArray jsonObject = JSONArray.fromObject(parameters);
			
			Logger.info("json"+jsonObject.toString());
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				//����һ��NameValuePair���飬���ڴ洢��Ҫ���͵Ĳ���
				params.add(new BasicNameValuePair("data", parameters));
				
				//��Ӳ���
				
				httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
				
				startTime = System.currentTimeMillis();
				
				//���ñ���
				HttpResponse httpResponse = httpClient.execute(httpPost);
				
				endTime = System.currentTimeMillis();
				
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				
				Logger.info("��Ӧ��Ϊ��"+statusCode);
				Logger.info("����API��ʱ����λ�����룩��"+(endTime-startTime));
				
				if(statusCode!=HttpStatus.SC_OK){
					Logger.info("Method failed:"+httpResponse.getStatusLine());
					status = 1;
				}
				
				//��ȡ��Ӧʵ������
				body = EntityUtils.toString(httpResponse.getEntity());

			} catch (IOException e) {
				// ���������쳣
				Logger.error("exception occurred!\n"+ExceptionUtils.getFullStackTrace(e));
				
				//�������
				status = 3;
			}finally{
				Logger.info("���ýӿ�״̬��"+status);
			}
				
		}	
		
		return body;
	}
	
	/**
	 * 0.�ɹ���1��ִ�з���ʧ��; 2.Э�����; 3.�������
	 * @return
	 */
	public int getStatus(){
		return status;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
	
	public long getStartTime(){
		return startTime;
	}
	
	public long getEndTime(){
		return endTime;
	}
	

}
