package com.sohu.sce.open.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/**
 * @author lornawang
 * 
 */
public class HTTPUtils {

	public final static String DEFAULT_CHARSET = "UTF-8";

	public final static String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";

	public final static String XML_CONTENT_TYPE = "application/xml";

	public final static int DEFAULT_TIMEOUT = 40000;


	/**
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws SocketTimeoutException
	 */
	public static String doGet(String url) throws SocketTimeoutException, IOException {
		return doGet(url, DEFAULT_CHARSET);
	}

	/**
	 * 
	 * @param url
	 * @param data
	 * @param charset
	 * @return
	 * @throws IOException
	 * @throws SocketTimeoutException
	 */
	public static String doGet(String url, Map<String, String[]> data, String charset) throws SocketTimeoutException,
			IOException {
		if (url.lastIndexOf("/") == (url.length() - 1)) {
			url = url.substring(0, url.length() - 1);
		}

		StringBuilder queryString = new StringBuilder(url);

		if (data != null && data.size() > 0) {
			queryString.append("?");
		}
		for (Entry<String, String[]> entry : data.entrySet()) {
			for (String value : entry.getValue()) {
				if ("".equals(value)) {
					continue;
				}
				queryString.append(entry.getKey()).append("=").append(URLEncoder.encode(value, charset)).append("&");
			}
		}

		if (queryString.lastIndexOf("&") == queryString.length() - 1) {
			return doGet(queryString.substring(0, queryString.length() - 1), charset);
		}

		return doGet(queryString.toString(), charset);
	}

	public static String doGet(String url, Map<String, String[]> data, String charset, Map<String, String> headerMap)
			throws SocketTimeoutException, IOException {
		String queryString = buildQueryString(url, data, charset);
		if (queryString.lastIndexOf("&") == queryString.length() - 1) {
			return doGet(queryString.substring(0, queryString.length() - 1), charset, headerMap);
		}

		return doGet(queryString.toString(), charset, headerMap);
	}

	private static String buildQueryString(String url, Map<String, String[]> data, String charset)
			throws UnsupportedEncodingException {

		if (url.lastIndexOf("/") == (url.length() - 1)) {
			url = url.substring(0, url.length() - 1);
		}
		StringBuilder queryString = new StringBuilder(url);

		if (data != null && data.size() > 0) {
			queryString.append("?");
		}
		for (Entry<String, String[]> entry : data.entrySet()) {
			for (String value : entry.getValue()) {
				System.out.println(entry.getKey()+"-"+value);
				if (StringUtils.isEmpty(value)) {
					continue;
				}
				queryString.append(entry.getKey()).append("=").append(URLEncoder.encode(value, charset)).append("&");
			}
		}
		return queryString.toString();

	}

	/**
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws SocketTimeoutException
	 */
	public static String doGet(String url, String charset) throws SocketTimeoutException, IOException {

		HttpGet httpGet = new HttpGet(url);

		httpGet.addHeader("Content-Type", "text/xml; charset=" + charset);

		return sendRequest(httpGet, charset);
	}

	/**
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws SocketTimeoutException
	 */
	public static String doGet(String url, String charset, Map<String, String> headerMap)
			throws SocketTimeoutException, IOException {
		System.out.println("url=" + url);
		HttpGet httpGet = new HttpGet(url);

		//httpGet.addHeader("Content-Type", "text/xml; charset=" + charset);
		httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + charset);

		if (headerMap != null) {
			for (String key : headerMap.keySet()) {
				httpGet.addHeader(key, headerMap.get(key));
			}
		}

		return sendRequest(httpGet, charset);

		// HttpClient client = new DefaultHttpClient();
		// client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT,
		// DEFAULT_TIMEOUT);
		//
		// HttpResponse response = client.execute(httpGet);
		//
		// String responseContent = "";
		// int statusCode = response.getStatusLine().getStatusCode();
		//
		// if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
		// HttpEntity responseEntity = response.getEntity();
		// try {
		// responseContent = EntityUtils.toString(responseEntity, charset);
		// EntityUtils.consume(responseEntity);
		// } catch (IOException e) {
		// logger.error("", e);
		// }
		// } else if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY ||
		// statusCode == HttpStatus.SC_MOVED_PERMANENTLY) {
		// responseContent =
		// response.getFirstHeader(HttpHeaders.LOCATION).getValue();
		// } else {
		// HttpEntity responseEntity = response.getEntity();
		// try {
		// responseContent = EntityUtils.toString(responseEntity, charset);
		// EntityUtils.consume(responseEntity);
		// } catch (IOException e) {
		// logger.error("", e);
		// }
		// }
		//
		// client.getConnectionManager().shutdown();
		//
		// return responseContent;
	}

	/**
	 * 默认采用UTF-8编码
	 * 
	 * @param url
	 * @param data
	 * @return
	 * @throws SocketTimeoutException
	 * @throws IOException
	 */
	public static String doPost(String url, Map<String, String[]> data) throws SocketTimeoutException, IOException {
		return doPost(url, data, DEFAULT_CHARSET);
	}

	/**
	 * 
	 * @param url
	 * @param data
	 * @param charset
	 * @return
	 * @throws SocketTimeoutException
	 * @throws IOException
	 */
	public static String doPost(String url, Map<String, String[]> data, String charset) throws SocketTimeoutException,
			IOException {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		for (Entry<String, String[]> entry : data.entrySet()) {
			for (String value : entry.getValue()) {
				if ("".equals(value)) {
					continue;
				}
				formparams.add(new BasicNameValuePair(entry.getKey(), value));
			}
		}

		UrlEncodedFormEntity requestEntity = null;
		try {
			requestEntity = new UrlEncodedFormEntity(formparams, charset);
		} catch (UnsupportedEncodingException e) {
		}

		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(requestEntity);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + charset);

		return sendRequest(httpPost, charset);
	}



	

	/**
	 * @param httpUriRequest
	 * @return
	 * @throws IOException
	 * @throws SocketTimeoutException
	 */
	private static String sendRequest(HttpUriRequest httpUriRequest, String charset) throws SocketTimeoutException,
			IOException {
		HttpClient client = new DefaultHttpClient();
		client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, DEFAULT_TIMEOUT);

		HttpResponse response = client.execute(httpUriRequest);

		String responseContent = "";
		int statusCode = response.getStatusLine().getStatusCode();

		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity responseEntity = response.getEntity();
			try {
				responseContent = EntityUtils.toString(responseEntity, charset);
				EntityUtils.consume(responseEntity);
			} catch (IOException e) {
			  e.printStackTrace();
			}
		} else if (statusCode == HttpStatus.SC_MOVED_TEMPORARILY || statusCode == HttpStatus.SC_MOVED_PERMANENTLY) {
			responseContent = response.getFirstHeader(HttpHeaders.LOCATION).getValue();
		} else {
			HttpEntity responseEntity = response.getEntity();
			try {
				responseContent = EntityUtils.toString(responseEntity, charset);
				EntityUtils.consume(responseEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		client.getConnectionManager().shutdown();

		return responseContent;
	}

	public static String doPost(String url, Map<String, String[]> data, String charset, Map<String, String> headerMap)
			throws SocketTimeoutException, IOException {
		System.out.println("url=" + url);
		HttpPost httpPost = new HttpPost(url);

		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		if (headerMap != null) {
			for (String key : headerMap.keySet()) {
				httpPost.addHeader(key, headerMap.get(key));
			}
		}

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();

		for (Entry<String, String[]> entry : data.entrySet()) {
			for (String value : entry.getValue()) {
				if ("".equals(value)) {
					continue;
				}
				formparams.add(new BasicNameValuePair(entry.getKey(), value));
			}
		}

		UrlEncodedFormEntity requestEntity = null;
		try {
			requestEntity = new UrlEncodedFormEntity(formparams, charset);
			httpPost.setEntity(requestEntity);

			return sendRequest(httpPost, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public static String doDelete(String url, Map<String, String[]> data, String charset, Map<String, String> headerMap)
			throws SocketTimeoutException, IOException {
		url = buildQueryString(url, data, charset);
		HttpDelete httpDelete = new HttpDelete(url);

		httpDelete.addHeader("Content-Type", "text/xml; charset=" + charset);

		if (headerMap != null) {
			for (String key : headerMap.keySet()) {
				httpDelete.addHeader(key, headerMap.get(key));
			}
		}

		return sendRequest(httpDelete, charset);

	}

	public static String doPut(String url, Map<String, String[]> data, String charset, Map<String, String> headerMap)
			throws SocketTimeoutException, IOException {
		List<NameValuePair> list = new ArrayList<NameValuePair>();

		for (Entry<String, String[]> entry : data.entrySet()) {
			for (String value : entry.getValue()) {
				list.add(new BasicNameValuePair(entry.getKey(), value));
			}
		}

		HttpPut httpPut = new HttpPut(url);
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list, charset);
		httpPut.setEntity(formEntity);

		httpPut.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
		if (headerMap != null) {
			for (String key : headerMap.keySet()) {
				httpPut.addHeader(key, headerMap.get(key));
			}
		}
		return sendRequest(httpPut, charset);

	}
}
