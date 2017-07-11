package test;

import org.junit.Test;

public class CreateAppHash {
	String time = String.valueOf(System.currentTimeMillis());
	String authKey = "appbyme_key";
	
	@Test
	public void getAppHash(){	
		String firstStr = time.substring(0, 5);	
		String md5Str = Str2MD5.MD5(firstStr+authKey);
		
		String appHashSub = md5Str.substring(9, md5Str.length()-15);
		
		System.out.println(appHashSub);
		
	}
}
