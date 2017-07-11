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

public class securityApisTest {
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
	
	//查询某个状态的服务实例
	@Test
	public void getAnAppSecurities() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/security";
		
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
	
	//新增应用的安全配置信息
	@Test
	public void addAnAppSecurities() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/security";
		data.put("ua_list", new String[]{"(?!.*(?i)Opera|.*(?i)Firefox|.*(?i)Maxthon).*(?i)MSIE\\s+[6]\\.\\d"});
		//data.put("ip_white_list", new String[]{"10.121.35.85"});
		data.put("ip_black_list", new String[]{"192.168.2.142"});
		//data.put("rate", new String[]{"150"});
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
	
	//删除ip的安全配置信息
	@Test
	public void deleteIPSecurityRule() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/security/ip";
		//data.put("ip", new String[]{"192.168.2.142"});
		//data.put("type", new String[]{"black"});
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
	
	//删除ua的安全配置信息
	@Test
	public void deleteUaSecurityRule() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/security/ua";
		data.put("ua", new String[]{"(?!.*(?i)Opera|.*(?i)Firefox|.*(?i)Maxthon).*(?i)MSIE\\s+[6]\\.\\d"});
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
		
	//删除rate的安全配置信息
	@Test
	public void deleteRateSecurityRule() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/656376568/security/rate";
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
