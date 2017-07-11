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
		//newһ��HttpClient����
		HttpClient httpClient = new DefaultHttpClient();		
		HttpPost httpPost = new HttpPost(url);
		
//		HttpClient client = new HttpClient();
//		PostMethod method = new PostMethod(url);
//		method.addRequestHeader("Content-Type", "application/json");
		
		String respContent = null;
		
		//String postUrl = "http://coreapi-app.v2.yoo.yunpro.cn/app";
		//����HttpClient��PostMethod������������URL
		//PostMethod poster = new PostMethod(postUrl);
		
		/**
		 * ʹ��PostMethod�����������header
		 */
		//��ȡheader�е�random��authֵ
		String random = String.valueOf(System.currentTimeMillis());//��ϵͳʱ�䶨��ΪXiaoyun-Random
		System.out.println("�û�����auth�������Ϊ:"+random);
		String auth = Str2MD5.MD5(random+"tantan_test");//����Str2MD5���е�MD5��������ϵͳʱ�����ɵ�random+"tantan_key"����һ��md�ַ���		
		
		//���ϱ߻�ȡ����random��authֵ��Ӹ�poster
//		poster.addRequestHeader("Xiaoyun-Auth",auth);
//		poster.addRequestHeader("Xiaoyun-Random", random);
//		poster.addRequestHeader("Content-Type", "application/json");
		
		httpPost.addHeader("Xiaoyun-Auth",auth);
		httpPost.addHeader("Xiaoyun-Random", random);
		//httpPost.addHeader("Content-Type", "application/json");
		
		
		/**
		 * ����post data����
		 *
		 */
		//��ȡBody Data�е�����
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
		 * ��ȡ������Ӧ����
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
