package test;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostExample {
	/**
	
	public static final MediaType JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
	
	OkHttpClient client = new OkHttpClient();
	
	String post(String url,String json) throws IOException{
		
		RequestBody requestBody = RequestBody.create(JSON, json);
		
		Request request = new Request.Builder()
				.url(url)
				.post(requestBody)
				.build();
		
		Response response = client.newCall(request).execute();
		
		return response.body().string();	
	}

	String bowlingJson(String player1,String player2){
		return "'accessSecret':'7b27f200da73905693371c29cdad0',"
				+ "'act':'new',"
				+ "'egnVersion':'v2091.5',"
				+ "'special':'0',"
				+ "'sdkVersion':'2.5.0.0',"
				+"'apphash':'969bfed6',"
				+"'json':'%7B%0A%20%20%22body%22%20%3A%20%7B%0A%20%20%20%20%22json%22%20%3A%20%7B%0A%20%20%20%20%20%20%22typeId%22%20%3A%20%22%22%2C%0A%20%20%20%20%20%20%22fid%22%20%3A%20%2251%22%2C%0A%20%20%20%20%20%20%22longitude%22%20%3A%20%22%22%2C%0A%20%20%20%20%20%20%22isQuote%22%20%3A%20%220%22%2C%0A%20%20%20%20%20%20%22latitude%22%20%3A%20%22%22%2C%0A%20%20%20%20%20%20%22title%22%20%3A%20%22%25E4%25BB%258A%25E6%2596%2587%25E5%25AD%2597%25E5%258F%2591%25E9%2580%2581%25E6%25B5%258B%25E8%25AF%2595%22%2C%0A%20%20%20%20%20%20%22typeOption%22%20%3A%20%22%22%2C%0A%20%20%20%20%20%20%22location%22%20%3A%20%22%22%2C%0A%20%20%20%20%20%20%22isShowPostion%22%20%3A%20%221%22%2C%0A%20%20%20%20%20%20%22pollInfo%22%20%3A%20%7B%0A%0A%20%20%20%20%20%20%7D%2C%0A%20%20%20%20%20%20%22ti_id%22%20%3A%20%22%22%2C%0A%20%20%20%20%20%20%22aid%22%20%3A%20%22%22%2C%0A%20%20%20%20%20%20%22content%22%20%3A%20%22%255B%250A%2520%2520%257B%250A%2520%2520%2520%2520%2522type%2522%2520%253A%2520%25220%2522%252C%250A%2520%2520%2520%2520%2522infor%2522%2520%253A%2520%2522%25E4%25BB%258A%25E6%2596%2587%25E5%25AD%2597%25E5%258F%2591%25E9%2580%2581%25E6%25B5%258B%25E8%25AF%2595%2522%250A%2520%2520%257D%250A%255D%22%0A%20%20%20%20%7D%0A%20%20%7D%0A%7D',"
				+"accessToken:"+player1+","
				+"'platType':'5',"
				+"'forumKey':"+player2;
	}
	
	public static void main(String[] args) throws IOException{
		PostExample doPost = new PostExample();
		String json = doPost.bowlingJson("84771c5f186e1fe90733a4a453533", "uBdN2XGj1HzfmVEuGw");
		String response = doPost.post("http://bbs.appbyme.com/lornawang/upload/mobcent/app/web/index.php?r=forum/topicadmin", json);
		System.out.println(response);
	}
	 * @throws IOException 
	 * @throws JSONException 
	*/
	
	@Test
	public void run() throws IOException, JSONException{
		String url = "https://bbs.appbyme.com/lornawang/upload/mobcent/app/web/index.php?r=forum/topicadmin";
		OkHttpClient client = new OkHttpClient();
		//String json = "{'body' : '{ 'json' : '{'typeId' : '','fid' : '51','longitude' : '','isQuote' : '0','latitude' : '','title' : '今文字发送测试','typeOption' : '','location' : '','isShowPostion' : '1','pollInfo' : {},'ti_id' : '','aid' : '','content' : '[{'type' : '0','infor' : '今文字发送测试'}]}'}'}";
		
		JSONObject topicAdminReqJson = new JSONObject();
		
		JSONObject body = new JSONObject();
		
		JSONArray contentJsonArr = new JSONArray();
		JSONObject contentJson = new JSONObject();
		contentJson.put("type",0);
		contentJson.put("infor", "topicAdminApiTestCase1, this is content");
		contentJson.put("cover", "");
		contentJsonArr.put(contentJson);
		
		JSONObject pollInfo = new JSONObject();
		JSONArray itemArr = new JSONArray();
		pollInfo.put("item", itemArr);
		pollInfo.put("pollpreview", "");
		pollInfo.put("expiration", 0);
		pollInfo.put("isimage", 0);
		pollInfo.put("maxchoices", 1);
		pollInfo.put("multiple", 0);
		pollInfo.put("visible", 0);	
		
		JSONArray contentsArr = new JSONArray();
		JSONObject contentsObj = new JSONObject();
		contentsObj.put("cover","");
		contentsObj.put("infor","topicAdminApiTestCase1,this is contents");
		contentsObj.put("type",0);
		contentsArr.put(contentsObj);
		
		JSONObject typeOptionJsonObj = new JSONObject();
		JSONObject typeOptionsJsonObj = new JSONObject();
		
		JSONObject json = new JSONObject();
		
		json.put("aid", "");
		json.put("content", contentJsonArr.toString());
		json.put("contents", contentsArr);
		json.put("latitude", "");
		json.put("location", "");
		json.put("longitude", "");
		json.put("pollInfo", pollInfo);
		json.put("title", "topicAdminApiTestCase1,this is title");
		json.put("typeOption", typeOptionJsonObj.toString());
		json.put("typeOptions",typeOptionsJsonObj.toString());
		json.put("fid", 51);
		json.put("ti_id", 0);
		json.put("tid", 0);
		json.put("isAnonymous", 0);
		json.put("isHidden", 0);
		json.put("isOnlyAuthor", 0);
		json.put("isQuote", 0);
		json.put("isShowPostion", 0);	
		json.put("replyId", 0);
		json.put("sortId", 0);
		json.put("typeId", "");
		
		System.out.println("JSON:\n"+json);
		
		body.put("json", json);
		
		topicAdminReqJson.put("body", body);
		
		System.out.println("topicAdmin接口请求体中的JSON串为:\n"+topicAdminReqJson);
		
		
		//生成appHash
		String time = String.valueOf(System.currentTimeMillis());
		String authKey = "appbyme_key";
		String firstStr = time.substring(0, 5);	
		String md5Str = Str2MD5.MD5(firstStr+authKey);
		String appHashSub = md5Str.substring(9, md5Str.length()-15);
		System.out.println("appHash为："+appHashSub);
		
		
		
		FormBody bodyData = new FormBody.Builder()
					.add("act", "new")
					.add("packageName", "com.appbyme.app210292")
					.add("json", topicAdminReqJson.toString())
					.add("accessToken", "39fb46772d71479c143168dd1dfb9")
					.add("appName", "线上mobcent0607")
					.add("special", "0")
					.add("egnVersion", "v2091.5")
					.add("accessSecret", "cc31e65f75669bc4a93a53bca5302")
					.add("sdkVersion", "2.5.0.0")
					.add("imei", "860441037365553")
					.add("appHash", appHashSub)
					.add("forumKey", "QbqxoM65xkGgy0VDNr")
					.add("platType", "1")
					.add("imsi", "")
					.add("sdkType", "")
					.build();
		
		
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0;i<bodyData.size();i++){
			strBuilder.append(bodyData.name(i)+":"+bodyData.value(i)+"\n");
//			strBuilder.append("act"+":"+"new");
//			strBuilder.append("packageName"+":"+"com.appbyme.app210292");
//			strBuilder.append("json"+":"+topicAdminReqJson.toString());
//			strBuilder.append("accessToken"+":"+"5eddbb51dee4a3dda156104e29b95");
//			strBuilder.append("appName"+":"+"线上mobcent0607");
//			strBuilder.append("special"+":"+"0");
//			strBuilder.append("egnVersion"+":"+"v2091.5");
//			strBuilder.append("accessSecret"+":"+"7302dc7e7f996542c76c90a475531");
//			strBuilder.append("sdkVersion"+":"+"2.5.0.0");
//			strBuilder.append("imei"+":"+"860441037365553");
//			strBuilder.append("appHash"+":"+appHashSub);
//			strBuilder.append("forumKey"+":"+"QbqxoM65xkGgy0VDNr");
//			strBuilder.append("platType"+":"+"1");
//			strBuilder.append("imsi"+":"+"");
//			strBuilder.append("sdkType"+":"+"");
		}
		
		System.out.println("请求数据如下所示：\n"+strBuilder.toString());
		
//		RequestBody formBody = new FormBody.Builder()
//				.add("act", "new")
//				.add("packageName", "com.appbyme.app210292")
//				.add("forumType", "7")
//				.add("json", topicAdminReqJson.toString())
//				.add("accessToken", "5eddbb51dee4a3dda156104e29b95")
//				.add("appName", "线上mobcent0607")
//				.add("special","0")
//				.add("egnVersion", "v2091.5")
//				.add("accessSecret", "7302dc7e7f996542c76c90a475531")
//				.add("sdkVersion", "2.5.0.0")
//				.add("imei", "860441037365553")
//				.add("appHash", "194bfe84")
//				.add("forumKey", "QbqxoM65xkGgy0VDNr")
//				.add("platType", "1")
//				.add("imsi", "")
//				.add("sdkType", "")
//				.build();
		
//		System.out.println("请求体为：\n"+formBody.toString());
		
		Request request = new Request.Builder().url(url).post(bodyData).build();
		System.out.println(request.body().toString());
		
		Response response = client.newCall(request).execute();
		
		System.out.println("响应结果数据：\n"+response.body().string());
		
	}
}
