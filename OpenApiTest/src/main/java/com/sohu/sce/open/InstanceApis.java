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

public class InstanceApis {
	String domian = "http://10.31.84.185:8080";
	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String appid ="656376568";
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
	
	//获取应用下的所有实例
	@Test
	public void getAppInstances() throws SocketTimeoutException, IOException{
		String uri = "/cs/apps/147319268/deploy";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod );
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doGet(domian+uri, data, charset, null);
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
	
	//重启实例，进程级别的重启
	@Test
	public void postAppInstances() throws SocketTimeoutException, IOException{
		String uri = "/cs/instances/5e656044-ed8c-11e4-8d2e-00163e19aa1b/restart";
		try {
			data.put("version", new String[]{String.valueOf(1)});
			String signature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod );
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPost(domian + uri, data, charset, null);
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
	
	//停止实例
		@Test
		public void postStopAppInstances() throws SocketTimeoutException, IOException{
			String uri = "/cs/instances/cedd0752-6baa-11e4-ab8c-00163e134bdb/stop";
			try {
				String signature = SignatureUtils.signature(data, secretKey, "POST", uri, signatureMethod );
				data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
				System.out.println(data);
				String response = HTTPUtils.doPost(domian + uri, data, charset, null);
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
		
		//删除实例
		@Test
		public void deleteAppInstances() throws SocketTimeoutException, IOException{
			String uri = "/cs/instances/cedd0752-6baa-11e4-ab8c-00163e134bdb";
			try {
				String signature = SignatureUtils.signature(data, secretKey, "DELETE", uri, signatureMethod );
				data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
				//data.put("version", new String[]{String.valueOf(5)});
				System.out.println(data);
				String response = HTTPUtils.doDelete(domian + uri, data, charset, null);
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
		
		//开启SSH登录实例的功能
		@Test
		public void putInstanceSSHopen() throws SocketTimeoutException, IOException{
			String uri = "/cs/instances/727933fe-ec8c-11e4-8443-00163e19aa1b/ssh/open";
			try {
				String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod );
				data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
				//data.put("version", new String[]{String.valueOf(5)});
				System.out.println(data);
				String response = HTTPUtils.doPut(domian + uri, data, charset, null);
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
		
		//获取实例IP和Port
		@Test
		public void getInstanceIPandPort() throws SocketTimeoutException, IOException{
			String uri = "/cs/instances/72676aac-ec8c-11e4-8443-00163e19aa1b/ssh";
			try {
				String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod );
				data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
				//data.put("version", new String[]{String.valueOf(5)});
				System.out.println(data);
				String response = HTTPUtils.doGet(domian + uri, data, charset, null);
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
		
		//关闭SSH登录实例的功能
		@Test
		public void putInstanceSSHclose() throws SocketTimeoutException, IOException{
			String uri = "/cs/instances/72676aac-ec8c-11e4-8443-00163e19aa1b/ssh/close";
			try {
				String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod );
				data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
				//data.put("version", new String[]{String.valueOf(5)});
				System.out.println(data);
				String response = HTTPUtils.doPut(domian + uri, data, charset, null);
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
		
	
}
