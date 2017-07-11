package topicapis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	static int id = 5500000;
	
	public static String MD5(String sourceStr) {
    String result= "";
    try{
        MessageDigest md= MessageDigest.getInstance("MD5");
        md.update(sourceStr.getBytes());
        byte b[] =md.digest();
        int i;
        StringBuffer buf=new StringBuffer("");
        for(int offset = 0; offset < b.length; offset++) {
            i=b[offset];if(i < 0)
                i+= 256;if(i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        result=buf.toString();
        //System.out.println("MD5(" + sourceStr + ",32) = " +result);
        return "MD5(" + sourceStr + ",32) = "+result;
        }catch(NoSuchAlgorithmException e) {
        System.out.println(e);
    }
    return result;
}
	
}
