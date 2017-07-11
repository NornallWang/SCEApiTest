package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Str2MD5 {
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
        System.out.println("MD5(" + sourceStr + ",32) = " +result);
        }catch(NoSuchAlgorithmException e) {
        System.out.println(e);
    }
    return result;
}
	
	public static HashMap<String, Object> getHeaders() {
		HashMap<String,Object> headers = new HashMap<String, Object>();
		String random = String.valueOf(System.currentTimeMillis());
		headers.put("Xiaoyun-Random", random);
		headers.put("Xiaoyun-Auth", new Str2MD5().MD5(random+":"+"tantan_test"));
		return headers;
	}
	
	public static final String getKey(int length) {
        char[] numAndLetters = null;
        Random randkey = null;
        Object initLock = new Object();
        if (length < 1)
            return null;
        if (randkey == null) {
            synchronized (initLock) {
                randkey = new Random();
                numAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
            }
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numAndLetters[randkey.nextInt(61)];
        }
        return new String(randBuffer);
    }
	
	public static int getId(){
		return id++;
	}
	
	/**
	 * 从数组中读取模板
	 * @return 
	 */
	
	public static String getModel(){
		String fileName = "E:\\Softwares\\jars\\appmodels.txt";	
		List modelfromFile = ReadFromFile.lreaderFileByString(fileName);
		//定义一个int类型的变量index作为list的角标
		//使用Math.random（random() 方法可返回介于 0 ~ 1 之间的一个随机数。），产生0-(arr.length-1)的整数值,也是数组的索引
		
		String model ="";
		for(int i=0;i<modelfromFile.size();i++){
			int index = (int)(Math.random()*modelfromFile.size());
			model = (String)modelfromFile.get(index);
			System.out.println(model);
		}
		
		return model;
		
		
		
		/**
		int i;
		List<String> models = new ArrayList<String>();
		models.add("xqjj");
		models.add("meijia");
		models.add("xqty");
		models.add("xqdt");
		models.add("fwty"); 
		models.add("news");
		models.add("coffee");
		models.add("locallife");
		models.add("education");
		models.add("health");
		models.add("eportal");
		models.add("healthcare");
		models.add("fc01");
		models.add("");
		models.add("");
		models.add("");
		models.add("");
		
		
		//List的第一种遍历方式:因为list有顺序，利用size()和get()方法获取
		//for(i=0;i<models.size();i++){
		//	System.out.println((models.get(i)));
		//}
		//return modelfromFile;
		*/

	}

	
	public static String getModel2(){
		String models[] = new String[]{"xqjj","meijia","xqty","xqdt","fwty","fwdt","news","coffee","locallife","education","health","eportal","healthcare","fc01","ly01","ly02","jy01","jy02","jy03","jy04","zf01","zf02","zf03","zf04","sh01","sm01","sm02","sm03","sm04","sm05","sm06","sm07","sm08","sm09","wx01"};
		Random ran = new Random();
		int s = ran.nextInt(models.length)%(models.length-0+1) + 0;
		return models[s];
	
		
	}

}