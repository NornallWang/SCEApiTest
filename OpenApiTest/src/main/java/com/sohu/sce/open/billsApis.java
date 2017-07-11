package com.sohu.sce.open;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.sohu.sce.open.utils.HTTPUtils;
import com.sohu.sce.open.utils.SceOpenApiConstant;
import com.sohu.sce.open.utils.SignatureUtils;

public class billsApis{
	String domain = "https://api.cloudscape.sohu.com";
	String signatureMethod = "HmacSHA1";
	String charset = "UTF-8";
	String appid = "656376568";
	String accessKey = "718ff2dcf3fd3a38cb18c145e7011776";
	String secretKey = "4126eddbe93e82314ab3f0adcb52c33e";
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
	
	//获取所有资源最新单价
	@Test
	public void getBillsPrice() {

		String uri = "/cs/bills/price";
		try {
			
			data.put("resource_type", new String[]{"memcache"});
			String sigature = SignatureUtils.signature(data, secretKey, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });
			//data.put("log_type", new String[]{"access"});
			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//获取一种或多种资源在一段时间内的总金额
	@Test
	public void getBillsResourceAmount() {

		String uri = "/cs/bills/resources/amount";
		try {
			data.put("resource_type", new String[]{"all"});
			data.put("appid", new String[]{"656376568"});
			data.put("begin_time", new String[]{"2014-10-20 00:00:00"});
			data.put("end_time", new String[]{"2014-11-20 00:00:00"});
			
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
	
	//获取一种或多种资源在一段时间内的消费账单（分页）
	@Test
	public void getBillsResource() {

		String uri = "/cs/bills/resources";
		try {
			data.put("resource_type", new String[]{"redis"});
			//data.put("appid", new String[]{"656376568"});
			data.put("begin_time", new String[]{"2014-10-19 00:00:00"});
			data.put("end_time", new String[]{"2014-11-20 00:00:00"});
			data.put("cur_page", new String[]{"1"});
			data.put("page_size", new String[]{"20"});
			
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
	
	//获取一种资源在一段时间内的消费明细（分页）
	@Test
	public void getOneResourceBillDetails() {

		String uri = "/cs/bills/resources/details";
		try {
			data.put("resource_type", new String[]{"app"});
			data.put("instance_id", new String[]{"f9dde02a-65b3-11e4-a36d-00163e14db77"});
			data.put("begin_time", new String[]{"2014-11-06 00:00:00"});
			data.put("end_time", new String[]{"2014-11-08 00:00:00"});
			data.put("cur_page", new String[]{"1"});
			data.put("page_size", new String[]{"20"});
			
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
