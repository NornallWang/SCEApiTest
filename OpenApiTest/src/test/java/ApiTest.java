import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import com.sohu.sce.open.utils.HTTPUtils;
import com.sohu.sce.open.utils.SceOpenApiConstant;
import com.sohu.sce.open.utils.SignatureUtils;

public class ApiTest {

	String domain = "http://bbs.appbyme.com/dzx31g/";

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

	@Test
	public void testGetDomain() {

		String uri = "/cs/apps/" + appid + "/domains";
		try {
			String sigature = SignatureUtils.signature(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void getAccountDepositTest() throws ClientProtocolException,IOException{
		String uri = "/cs/account/deposit";
		try{
		String sigature = SignatureUtils.signature(data, secret, "GET", uri, signatureMethod);
		data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

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

	@Test
	public void testAddDomain() {

		String uri = "/cs/apps/" + appid + "/domains";
		data.put("domain", new String[] { "hlytest2.sohuapps.com" });
		try {

			String sigature = SignatureUtils.signature(data, secret, "POST", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPost(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteDomain() {
		String uri = "/cs/apps/" + appid + "/domains";
		data.put("domain", new String[] { "sceopenapi2.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signature(data, secret, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
	@Test
	public void testCleanDomain() {
		String uri = "/cs/apps/" + appid + "/domains/clean";
		data.put("domain", new String[] { "hly*.csapps.sohuno.com" });
		try {

			String sigature = SignatureUtils.signature(data, secret, "DELETE", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doDelete(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetConfig() {
		String uri = "/cs/apps/" + appid + "/config";
		try {

			String sigature = SignatureUtils.signature(data, secret, "GET", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doGet(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPutConfig() {

		String uri = "/cs/apps/" + appid + "/config";

		data.put("is_schedule", new String[] { "true" });
		data.put("max_ins", new String[] { "3" });
		data.put("is_session", new String[] { "true" });
		data.put("container_type", new String[] { "text/xml; charset=UTF-8" });
		data.put("requests", new String[] { "100000" });
		try {

			String sigature = SignatureUtils.signature(data, secret, "PUT", uri, signatureMethod);
			data.put(SceOpenApiConstant.SIGNATURE, new String[] { sigature });

			System.out.println(data);
			String response = HTTPUtils.doPut(domain + uri, data, charset, null);
			System.out.println("=========================");
			System.out.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
