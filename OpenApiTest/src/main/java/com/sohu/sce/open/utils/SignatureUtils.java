package com.sohu.sce.open.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class SignatureUtils {


	public final static String ALGORITHM_TYPE_HMAC_SHA1 = "HmacSHA1";

	public final static String CHARSET_UTF8 = "UTF-8";



	/**
	 * 
	 *  签名算法
	 * @param parameterMap
	 * @param secret
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	@SuppressWarnings("restriction")
	public static String signature(Map<String, String[]> parameterMap, String secret, String method, String uri,
			String algorithm) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
		System.out.println(secret+"|"+method+"|"+uri+"|"+algorithm);
		// (1) 按参数名进行升序排列，并对key 和value做url编码
		List<String> list = new ArrayList<String>();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			for(String value:entry.getValue()){
				list.add(URLEncoder.encode(entry.getKey(), CHARSET_UTF8) + "=" + URLEncoder.encode(value, CHARSET_UTF8));	
			}
		}

		Collections.sort(list);
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			buf.append(list.get(i));
			if (i < list.size() - 1) {
				buf.append("&");
			}
		}

		// (2) 做url编码
		String rtn = URLEncoder.encode(buf.toString(), CHARSET_UTF8);
		System.out.println(rtn);
		// (3) 构�?签名�?
		rtn = method.toUpperCase() + "\n" + uri + "\n" + rtn;
		// (4) 签名
		byte[] rawHmac = hmac(rtn.getBytes(CHARSET_UTF8), secret.getBytes(CHARSET_UTF8), algorithm);
		// (5) base64
		BASE64Encoder base64Encoder = new BASE64Encoder();
		rtn= base64Encoder.encode(rawHmac);
		rtn=rtn.replace(" ", "+");
		String sigature = URLEncoder.encode(rtn,CHARSET_UTF8);
		System.out.println("sigature:>>"+sigature);
		return sigature;
	}
 

	public static byte[] hmac(byte[] data, byte[] key, String algorithm) throws NoSuchAlgorithmException,
			InvalidKeyException, UnsupportedEncodingException {

		SecretKeySpec signingKey = new SecretKeySpec(key, algorithm);
		Mac mac = Mac.getInstance(algorithm);
		mac.init(signingKey);
		byte[] rawHmac = mac.doFinal(data);
		return rawHmac;
	}
}
