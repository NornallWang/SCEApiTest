package Utils;

/**
 * Created by goyoo on 2017/6/21.
 */
public class Apphash {

    public static void main(String[] args){
        Apphash apphash = new Apphash();
        System.out.println(apphash.getApphash());

    }

    public String getApphash(){
        String auth_key = "appbyme_key";

        String currentTime = String.valueOf(System.currentTimeMillis());
        //System.out.println("当前时间戳："+currentTime);
        String subStr = currentTime.substring(0,5)+auth_key;
        //System.out.println("当前时间戳链接auth_key:"+subStr);
        String md5Str = MD5.getMD5(subStr);
        //System.out.println("md5出来的字符串"+md5Str);
        String apphash = md5Str.substring(8,16);
        //System.out.println("从md5出来的字符串中的第9位开始，截取8位："+apphash);

        return apphash;
    }

}
