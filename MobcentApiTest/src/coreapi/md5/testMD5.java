package coreapi.md5;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class testMD5 {
	public static String app_key="tantan_test";
	public static String fileName="E:\\Softwares\\jars\\appmodels.txt";
/*	
	public HashMap<String, Object> getHeaders() {
		HashMap<String,Object> headers = new HashMap<String, Object>();
		String random = String.valueOf(System.currentTimeMillis());
		headers.put("Xiaoyun-Random", random);
		headers.put("Xiaoyun-Auth", Str2MD5.MD5(random+":"+app_key));
		headers.put("Content-Type", "application/json");
		return headers;
	}
*/
	
/*	
	body.put("appid", shequ.getForumId());
	body.put("username", shequ.getAdminName());
	body.put("password",shequ.getAdminPassword());
	body.put("tablepre", shequ.getTablePre());
	body.put("email", shequ.getAdminEmail());
	body.put("secretkey", shequ.getSecretKey());
	body.put("model", shequ.getDiscuzTemplate());
	body.put("forumkey", appData.getString("forumKey"));
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String random = String.valueOf(System.currentTimeMillis());
		//String str = new Str2MD5().MD5(random+":"+app_key);
		//System.out.println(str);
		
		HashMap<String,Object> headers = Str2MD5.getHeaders();
		String random = headers.get("Xiaoyun-Random").toString();
		System.out.println(random);
		
		String auth = headers.get("Xiaoyun-Auth").toString();
		System.out.println(auth);
		
		/**
		 * 检查自增长方法是否可用
		 */
		/**
		for(int x=0;x<20;x++){
			int appid = Str2MD5.getId();
			System.out.println(appid);
		}
		**/
		/**
		 * 检查是否可从数组中获取模板
		 */	
		String model = new Str2MD5().getModel2();
		System.out.println(model);
		/*
		for (int i = 0; i < 20; i++) {
			System.out.println(Str2MD5.getModel2());
		}
		*/
		System.out.println("**************");
		String model2=new Str2MD5().getModel();
	}
		
		
	
}
