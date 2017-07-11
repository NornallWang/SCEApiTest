package Utils;

import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by goyoo on 2017/6/20.
 */
public class MD5 {
    /*
    public static void main(String[] args){
        String md5 = getMD5("asdf");
        System.out.println(md5);
    }
    */

    public static String getMD5(String str){

        // 生成一个MD5加密计算摘要
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //计算MD5函数
            //MessageDigest对象通过使用 update（）方法处理数据
            md5.update(str.getBytes());
            //System.out.println("----"+str);
            //对于给定数量的更新数据，digest 方法只能被调用一次。在调用 digest 之后，MessageDigest 对象被重新设置成其初始状态
            //System.out.println("----"+md5.digest());

            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1,md5.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "md5"+str;
        }
    }

    /**
     * 利用MD5进行加密
     *
     * @param str   待加密的字符串
     * @return      加密后的字符串
     * @throws NoSuchAlgorithmException     没有这种产生消息摘要的算法
     */
    public String EncoderByMD5(String str) throws NoSuchAlgorithmException {

        //确定计算方法
        //MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
        // 信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //BASE64Encoder进行加密
        BASE64Encoder base64en = new BASE64Encoder();

        //加密后的字符串处理
        String md5str = base64en.encode(md5.digest(str.getBytes()));
        return "md5Encoder"+md5str;
    }
}
