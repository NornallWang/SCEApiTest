package com.sohu.sce.open;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import com.sohu.sce.open.utils.HTTPUtils;
import com.sohu.sce.open.utils.SceOpenApiConstant;
import com.sohu.sce.open.utils.SignatureUtils;

public class accountApis {
	String domain = "https://api.cloudscape.sohu.com";

	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String appid ="656376568";
	String accessKey="718ff2dcf3fd3a38cb18c145e7011776";
	String secret="4126eddbe93e82314ab3f0adcb52c33e";
	Map<String, String[]> data = new HashMap<String, String[]>();

	@Before
	public void setUp() {
		
		
		data.put(SceOpenApiConstant.ACCESS_KEY, new String[] { accessKey });
		long timestamp = System.currentTimeMillis();
		data.put(SceOpenApiConstant.TIMESTAMP, new String[] { String.valueOf(timestamp) });
		data.put(SceOpenApiConstant.SIGNATURE_METHOD, new String[] { signatureMethod });
		data.put(SceOpenApiConstant.SIGNATURE_VERSION, new String[] { "1.0" });
		data.put(SceOpenApiConstant.VERSION, new String[] { "1.0" });
	}
	
	//获取某个用户充值列表信息
	@Test
	public void getAccountDepositTest() throws ClientProtocolException,IOException{
		String uri = "/cs/account/deposit";
		try{
		data.put("order_type", new String[]{"system_in"});
		data.put("begin_time", new String[]{"2014-10-05 16:22:28"});
		data.put("end_time", new String[]{"2014-11-22 16:22:28"});
		data.put("cur_page", new String[]{"1"});
		data.put("page_size", new String[]{"5"});
			
		String sigature = SignatureUtils.signature(data, secret, "GET", uri, signatureMethod);
		data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
		System.out.println(data);
		String response = HTTPUtils.doGet(domain + uri, data, charset, null);
		System.out.println("=========================");
		System.out.println(response);
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
			
	} 
	
	//获取某个用户的余额信息
	@Test
	public void getAccountMoney() throws SocketTimeoutException, IOException{
		String uri = "/cs/account";
		try {
			String signature = SignatureUtils.signature(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			String response = HTTPUtils.doGet(domain+uri, data, charset, null);
			System.out.println("============================================");
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
