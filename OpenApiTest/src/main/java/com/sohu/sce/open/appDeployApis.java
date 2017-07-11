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

public class appDeployApis {
	String domain = "http://10.31.84.185:8080";
	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String appid = "515682538";
	String accessKey = "a9446f0896f2651b6fd62bf2a3192544";
	String secretKey = "0792e6e4f8f8d3c00da386d87e94ac98";
	Map<String,String[]> data = new HashMap<String,String[]>();
	
	@Before
	public void setUp(){
		long timestamp = System.currentTimeMillis();
		data.put(SceOpenApiConstant.TIMESTAMP, new String[]{String.valueOf(timestamp)});
		data.put(SceOpenApiConstant.ACCESS_KEY, new String[]{accessKey});
		data.put(SceOpenApiConstant.SIGNATURE_METHOD, new String[]{signatureMethod});
		data.put(SceOpenApiConstant.SIGNATURE_VERSION, new String[]{"1.0"});
		data.put(SceOpenApiConstant.VERSION, new String[]{"1.0"});
	}
	
	//部署一个应用
	@Test
	public void putDepolyApps() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/515682538/deploy";
		try {
			data.put("version", new String[]{"6"});
			String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPut(domain+uri, data, charset, null);
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
	
	@Test
	public void postRestartApp() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/515682538/restart";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPost(domain+uri, data, charset, null);
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
