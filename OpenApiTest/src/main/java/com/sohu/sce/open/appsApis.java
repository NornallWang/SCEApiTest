package com.sohu.sce.open;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.sohu.sce.open.utils.HTTPUtils;
import com.sohu.sce.open.utils.SceOpenApiConstant;
import com.sohu.sce.open.utils.SignatureUtils;

public class appsApis {
	//String domain = "https://api.cloudscape.sohu.com";
	String domain = "http://10.31.84.185:8080";
	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String accessKey = "a9446f0896f2651b6fd62bf2a3192544";
	String secretKey = "0792e6e4f8f8d3c00da386d87e94ac98";
	Map<String, String[]> data = new HashMap<String, String[]>();
	
	@Before
	public void setUp(){
		long timestamp = System.currentTimeMillis();
		data.put(SceOpenApiConstant.TIMESTAMP, new String[]{String.valueOf(timestamp)});
		data.put(SceOpenApiConstant.ACCESS_KEY, new String[]{accessKey});
		data.put(SceOpenApiConstant.SIGNATURE_METHOD, new String[]{signatureMethod});
		data.put(SceOpenApiConstant.SIGNATURE_VERSION, new String[]{"1.0"});
		data.put(SceOpenApiConstant.VERSION, new String[]{"1.0"});
	}
	
	//列出我所管理的APP列表
	@Test
	public void getAccountApps() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			String response = HTTPUtils.doGet(domain+uri, data, charset, null);
			System.out.println("===================");
			System.out.println(response);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//列出应用的详情
	@Test
	public void getAccountAppInfo() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/124626234";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			String response = HTTPUtils.doGet(domain+uri,data , charset, null);
			System.out.println("=======================");
			System.out.println(response);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建app
	@Test
	public void testCreateApp() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps";
		data.put("name", new String[] { "apitest-lorna-createapp" });
		data.put("type", new String[]{"web"});
		//data.put("is_test", new String[]{"ture"});
		data.put("container_type",new String[]{"text/xml,charset=utf-8"});
		data.put("description", new String[]{"lornawang create a web app for testing the createApi"});		
		try {

			String sigature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//列出我所管理的APP的实例列表
	@Test
	public void getAppInstances() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/124626234/instances";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			String response = HTTPUtils.doGet(domain+uri, data, charset, null);
			System.out.println("============");
			System.out.println(response);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//导出应用的堆栈日志
	@Test
	public void testAppDumstack() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/124626234/dumpstack";	
		try {

			String sigature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//文件上传
	@Test
	public void testUploadFile() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/925096729/2";
		try {

			String sigature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			data.put("filepath", new String[]{"I://SCE4/"});
			data.put("filename", new String[]{"925096729.zip"});
			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//检测文件是否存在
	@Test
	public void checkFileExsitOrNot() throws SocketTimeoutException, IOException {
		String uri = "/cs/apps/925096729/2/check";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			String response = HTTPUtils.doGet(domain+uri, data, charset, null);
			System.out.println("===================");
			System.out.println(response);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//下载程序包
	@Test
	public void getAppVersion() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/925096729/2";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			String response = HTTPUtils.doGet(domain+uri, data, charset, null);
			System.out.println("===================");
			System.out.println(response);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
