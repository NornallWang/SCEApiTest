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

public class serviceApisTest {
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
	public void getOneStatusServiceInstanceInfo() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances";
		data.put("service_id", new String[]{"2"});
		//data.put("status", new String[]{"pending"});
		//data.put("status", new String[]{"running"});
		//data.put("status", new String[]{"stopped"});
		data.put("status", new String[]{"deleted"});
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
	
	//查询某个服务实例
	@Test
	public void getOneServiceInstanceInfo() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances/f231e08d-c4cf-42b5-adf6-c0d315dfcb09";
		data.put("access_token", new String[]{"8821a9ec172ed3ef2e3a9bd49f13b2ee"});
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
	
	//申请一个服务实例
	@Test
	public void applyOneServiceInstanceInfo() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances";
		//data.put("access_token", new String[]{"8821a9ec172ed3ef2e3a9bd49f13b2ee"});
		data.put("service_id", new String[]{"5"});
		try {
			String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			
			String response = HTTPUtils.doPut(domian + uri, data, charset, null);
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
	
	//卸载一个服务实例
	@Test
	public void deleteOneServiceInstanceInfo() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances/613730dd-50b2-40f5-a324-6fc3cfec6219";
		//data.put("access_token", new String[]{"8821a9ec172ed3ef2e3a9bd49f13b2ee"});
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
	
	//查询某个服务实例的认证token－目前仅限于mysql
	@Test
	public void getMysqlServiceToken() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances/a4751248-a20b-49a4-9e10-8fdfca3b8264/token";

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
	
	//获取某个appid的绑定服务实例信息
	@Test
	public void getAnAPPBindServiceInfo() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances/binds/656376568";
		//data.put("access_token", new String[]{"8821a9ec172ed3ef2e3a9bd49f13b2ee"});
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
	
	//获取某个appid与某个服务实例的绑定信息
	@Test
	public void getOneServiceInstanceBindApp() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances/binds/656376568/f231e08d-c4cf-42b5-adf6-c0d315dfcb09";
		//data.put("access_token", new String[]{"8821a9ec172ed3ef2e3a9bd49f13b2ee"});		
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
	
	//删除某个appid与某个服务实例的绑定信息
	@Test
	public void deleteOneServiceInstanceBindApp() throws SocketTimeoutException, IOException{
		String uri = "/cs/services/instances/binds/656376568/f231e08d-c4cf-42b5-adf6-c0d315dfcb09";		
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
	
	//添加某个appid与某个服务实例的绑定信息
		@Test
		public void bindOneServiceInstanceToApp() throws SocketTimeoutException, IOException{
			String uri = "/cs/services/instances/binds/656376568/f231e08d-c4cf-42b5-adf6-c0d315dfcb09";		
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
}
