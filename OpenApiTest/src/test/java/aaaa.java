
public class aaaa {
	try {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		method.addRequestHeader("Content-Type", "application/json");
		if (json != null) {
			logger.debug("url" + url + " data:" + json.toJSONString());
			ByteArrayRequestEntity requestEntity = new ByteArrayRequestEntity(json.toJSONString().getBytes());
			method.setRequestEntity(requestEntity);
		} else {
			logger.debug("url" + url + " data:null");
		}
		client.executeMethod(method);

		if (method.getStatusLine().getStatusCode() != 200) {
			logger.debug(method.getStatusLine().getStatusCode());
			InputStream stream = method.getResponseBodyAsStream();
			String result = IOUtils.toString(stream, "UTF-8");
			logger.debug("******result:" + result);
			JSONObject r = (JSONObject) JSONObject.parse(result);
			throw new MobcentException(url + " ¥ÌŒÛ£∫" + r.getString("err"));
		}

		InputStream stream = method.getResponseBodyAsStream();
		String result = IOUtils.toString(stream, "UTF-8");
		logger.debug("url" + url + " data:" + json.toJSONString() + " result:" + result);
		method.releaseConnection();
		return result;
		//  Õ∑≈¡¨Ω”

	} catch (HttpException e) {
		throw new MobcentException(e);
	} catch (IOException e) {
		throw new MobcentException(e);
	}
}
