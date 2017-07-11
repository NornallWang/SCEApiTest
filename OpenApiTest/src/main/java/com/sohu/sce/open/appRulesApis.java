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

public class appRulesApis {
	String domain = "http://10.31.84.185:8080";
	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String appid = "515682538";
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
	
	//创建规则
	@Test
	public void testCreateAnRule() throws SocketTimeoutException, IOException{
		String uri = "/cs/rules/515682538";
		data.put("name", new String[]{"morethan3"});
		data.put("rule", new String[]{"rule \"newRulefortestApi\":\r\n    when:\r\n        $varz := Performance((before_5mins_requests > 1))\r\n    then:\r\n        $varz.do_scale_up(1)"});
		data.put("description", new String[]{"当:<br/>\r\n        前5分钟请求数 大于 1<br/>\r\n执行:<br/>\r\n        [扩容] （1）个实例"});
		data.put("context", new String[]{"{\"conditions\":\"[[\\\"before_5mins_requests\\\",\\\"1\\\",\\\"1\\\"]]\",\"name\":\"sdfsdaf\",\"target\":\"1\",\"action\":\"do_scale_up\",\"clazz\":\"Performance\",\"ops\":\"[]\"}"});
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
	
	//获取应用下的所有规则定义
	@Test
	public void getAppRules() throws SocketTimeoutException, IOException{
		String uri = "/cs/rules/515682538";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
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
		
	//删除一个规则
	@Test
	public void deleteAnRule(){
		String uri  = "/cs/rules/515682538/2";
		//data.put("domain", new String[] { "sceopenapi2.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signature(data, secretKey, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//禁用一个规则
	@Test
	public void putMethodToDisabledAnRule() throws SocketTimeoutException, IOException{
		String uri = "/cs/rules/disable/515682538/13";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPut(domain+uri, data, charset, null);
			System.out.println("====================");
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
	
	//启用一个规则
	@Test
	public void putMethodToEnabledAnRule() throws SocketTimeoutException, IOException{
		String uri = "/cs/rules/enable/515682538/13";
		try {
			String signature = SignatureUtils.signature(data, secretKey, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[]{signature});
			System.out.println(data);
			String response = HTTPUtils.doPut(domain+uri, data, charset, null);
			System.out.println("====================");
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
	
	//更新一条规则的内容
	@Test
	public void testUpdateAnRule() throws SocketTimeoutException, IOException{
		String uri = "/cs/rules/update/515682538/13";
		data.put("rule", new String[]{"rule \"newRulefortestApi\":\r\n    when:\r\n        $varz := Performance((before_5mins_requests > 1))\r\n    then:\r\n        $varz.do_scale_up(1)"});
		data.put("description", new String[]{"当:<br/>\r\n        前5分钟请求数 大于 1<br/>\r\n执行:<br/>\r\n        [扩容] （1）个实例"});
		data.put("context", new String[]{"{\"conditions\":\"[[\\\"before_5mins_requests\\\",\\\"1\\\",\\\"1\\\"]]\",\"name\":\"sdfsdaf-UPDATE\",\"target\":\"1\",\"action\":\"do_scale_up\",\"clazz\":\"Performance\",\"ops\":\"[]\"}"});
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
	
	//获取所有支持的FACTS
	@Test
	public void testRuleAllFacts() throws SocketTimeoutException, IOException{
		String uri = "/cs/rules/facts";
		try {
			String sigature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取所有支持的actions
	@Test
	public void testRuleAllActions() throws SocketTimeoutException, IOException{
		String uri = "/cs/rules/actions";
		try {
			String sigature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
