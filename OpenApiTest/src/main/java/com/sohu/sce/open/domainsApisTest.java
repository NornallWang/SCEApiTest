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

public class domainsApisTest {
	String domian = "http://10.31.84.185:8080";
	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String appid ="147319268";
	String accessKey="a9446f0896f2651b6fd62bf2a3192544";
	String secretKey="0792e6e4f8f8d3c00da386d87e94ac98";
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
	
	@Test
	public void getAppDomains() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/147319268/domains";
		
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			
			String response = HTTPUtils.doGet(domian + uri, data, charset, null);
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
	
	//增加新的域名
	@Test
	public void postAppDomain() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/147319268/domains";
		data.put("domain", new String[]{"apitest2.nornall.com"});
		try {
			String signature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			
			String response = HTTPUtils.doPost(domian + uri, data, charset, null);
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
	
	//删除域名
	@Test
	public void deleteAppDomain() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/147319268/domains";
		data.put("domain", new String[]{"apitest.nornall.com"});
		try {
			String signature = SignatureUtils.signature(data, secretKey, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			
			String response = HTTPUtils.doDelete(domian + uri, data, charset, null);
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
	
	//清除所有自定义域名，只保留云景分配的默认域名
	@Test
	public void deleteAllUserDomains() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/147319268/domains/clean";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			
			String response = HTTPUtils.doDelete(domian + uri, data, charset, null);
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
