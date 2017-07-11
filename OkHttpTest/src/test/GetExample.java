package test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetExample {
	
	OkHttpClient client = new OkHttpClient();
	
	String run(String url) throws IOException{
	
		/**
		Request request = new Request.Builder()
				//.url(url)
				.url("http://bbs.appbyme.com/lornawang/upload/mobcent/app/web/index.php?r=forum/postlist&pageSize=10&egnVersion=v2091.5&order=0&sdkVersion=2.5.0.0&apphash=969bfed6&boardId=2&topicId=1277&accessToken=84771c5f186e1fe90733a4a453533&page=1&accessSecret=7b27f200da73905693371c29cdad0&forumKey=uBdN2XGj1HzfmVEuGw")
				.build();
		*/
		
		//ÃÌº”«Î«ÛÕ∑
		Request request = new Request.Builder()
				.url("http://bbs.appbyme.com/lornawang/upload/mobcent/app/web/index.php?r=user/getsetting&getSetting=%7B%0A%20%20%22body%22%20%3A%20%7B%0A%20%20%20%20%22postInfo%22%20%3A%20%7B%0A%20%20%20%20%20%20%22forumIds%22%20%3A%20%220%22%0A%20%20%20%20%7D%0A%20%20%7D%0A%7D&egnVersion=v2091.5&sdkVersion=2.5.0.0&apphash=969bfed6&accessToken=84771c5f186e1fe90733a4a453533&accessSecret=7b27f200da73905693371c29cdad0&forumKey=uBdN2XGj1HzfmVEuGw")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.72 Safari/537.36 Appbyme")
				.addHeader("Cookie", "00hS_2132_lastact=1490343476%09index.php%09; 00hS_2132_sid=qZA62P; 00hS_2132_lastcheckfeed=27%7C1490342986; 00hS_2132_ulastactivity=f49a%2BPYUPHj03O1YvL9oqGLMta%2B%2BpgNdyo7eIfBlXH7ONSHn8x0O; 00hS_2132_lastvisit=1490335146; 00hS_2132_saltkey=L33t8taN")
				.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
				.build();
				
		Response response = client.newCall(request).execute();
		
		if(!response.isSuccessful()) throw new IOException("Unexpected code"+response);
		
			System.out.println("Host:"+response.header("Host"));
			System.out.println("Date"+response.header("Date"));
			System.out.println("Vary:"+response.header("Vary"));
		
		return response.body().string();
	}

}
