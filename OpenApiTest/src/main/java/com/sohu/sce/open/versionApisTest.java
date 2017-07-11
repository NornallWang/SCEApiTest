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

public class versionApisTest {
	String domian = "https://api.cloudscape.sohu.com";
	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String appid ="656376568";
	String accessKey="718ff2dcf3fd3a38cb18c145e7011776";
	String secretKey="4126eddbe93e82314ab3f0adcb52c33e";
	Map<String, String[]> data = new HashMap<String, String[]>();

	@Before
	public void setUp(){
		data.put(SceOpenApiConstant.ACCESS_KEY, new String[] { accessKey });
		long timestamp = System.currentTimeMillis();
		data.put(SceOpenApiConstant.TIMESTAMP, new String[] { String.valueOf(timestamp) });
		data.put(SceOpenApiConstant.SIGNATURE_METHOD, new String[] { signatureMethod });
		data.put(SceOpenApiConstant.SIGNATURE_VERSION, new String[] { "1.0" });
		data.put(SceOpenApiConstant.VERSION, new String[] { "1.0" });
	}
	
	//获取当前应用所有的版本信息
	@Test
	public void versionApisTest() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/versions";
		
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doGet(domian +uri, data, charset, null);
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
	
	//添加一个新的版本
	@Test
	public void addNewVersionApi() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/versions";
		
		try {
			data.put("description", new String[]{"this is an api test for adding an new Version"});
			String signature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPost(domian +uri, data, charset, null);
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
	
	//修改当前版本描述信息
	@Test
	public void updateVersionDescription() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/versions/5";
		
		try {
			data.put("version", new String[]{"5"});
			data.put("description", new String[]{"this is an api test for adding an new Version"});
			String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPut(domian +uri, data, charset, null);
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
	
	//设置应用的当前版本
	@Test
	public void setAppCurrentVersion() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/versions/4";
		
		try {
			data.put("version", new String[]{"4"});
			data.put("is_restart", new String[]{"true"});
			String signature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPost(domian +uri, data, charset, null);
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
	
	//设置灰度发布状态
	@Test
	public void setAppABtestStatus() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/versions/abtest";
		data.put("is_abtest", new String[]{"false"});
		data.put("version", new String[]{"5"});
		
		try {
			String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPut(domian +uri, data, charset, null);
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
	
	
	//获取灰度发布状态
	@Test
	public void getAppABtestStatus() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/versions/abtest";
		
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doGet(domian +uri, data, charset, null);
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
