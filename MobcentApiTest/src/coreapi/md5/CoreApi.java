package coreapi.md5;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CoreApi {
	
	
	
	//post
	public static String creatAppPostWithJson(String url) throws UnsupportedEncodingException{
		//new一个HttpClient对象
		HttpClient httpClient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(url);
		
//		HttpClient client = new HttpClient();
//		PostMethod method = new PostMethod(url);
//		method.addRequestHeader("Content-Type", "application/json");
		
		String respContent = null;
		
		//String postUrl = "http://coreapi-app.v2.yoo.yunpro.cn/app";
		//调用HttpClient的PostMethod方法发送请求URL
		//PostMethod poster = new PostMethod(postUrl);
		
		/**
		 * 使用PostMethod方法添加请求header
		 */
		//获取header中的random和auth值
		String random = String.valueOf(System.currentTimeMillis());//将系统时间定义为Xiaoyun-Random
		System.out.println("用户生成auth的随机数为:"+random);
		String auth = Str2MD5.MD5(random+"tantan_test");//调用Str2MD5类中的MD5方法，将系统时间生成的random+"tantan_key"生成一个md字符串		
		
		//将上边获取到的random和auth值添加给poster
//		poster.addRequestHeader("Xiaoyun-Auth",auth);
//		poster.addRequestHeader("Xiaoyun-Random", random);
//		poster.addRequestHeader("Content-Type", "application/json");
		
		httpPost.addHeader("Xiaoyun-Auth",auth);
		httpPost.addHeader("Xiaoyun-Random", random);
		//httpPost.addHeader("Content-Type", "application/json");
		
		
		/**
		 * 构建post data数据
		 *
		 */
		//获取Body Data中的数据
		int appid = Str2MD5.getId();
		String username = "admin";
		String password = "lorna";
		String tablepre = "pre_";
		String email = "lornatest@gmail.com";
		String secretkey = "123456789";
		String model = Str2MD5.getModel();
		String forumkey = Str2MD5.getKey(18);
			
		
		JsonObject data = new JsonObject();
		data.addProperty("appid", appid);
		data.addProperty("username",username);
		data.addProperty("password", password);
		data.addProperty("tablepre", tablepre);
		data.addProperty("email", email);
		data.addProperty("secretkey", secretkey);
//		data.addProperty("model", model);
		data.addProperty("forumkey", forumkey);
		
		//String postdata = data.toString();
		StringEntity entity = new StringEntity(data.toString(),"utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httpPost.setEntity(entity);
		System.out.println();
		
		/**
		 * 获取请求响应数据
		 */
		try {
			HttpResponse resp = httpClient.execute(httpPost);
			if(resp.getStatusLine().getStatusCode() == 200){
				HttpEntity httpEn = resp.getEntity();
				respContent = EntityUtils.toString(httpEn,"UTF-8");
			}
						
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return respContent;
				
	}
	
	public static void main(String[] args) throws Exception{
		
			String result = creatAppPostWithJson("http://coreapi-app.v2.yoo.yunpro.cn/app");
			System.out.println(result);
		
	}

}
