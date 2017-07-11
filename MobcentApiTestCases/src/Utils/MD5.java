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

        // ����һ��MD5���ܼ���ժҪ
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //����MD5����
            //MessageDigest����ͨ��ʹ�� update����������������
            md5.update(str.getBytes());
            //System.out.println("----"+str);
            //���ڸ��������ĸ������ݣ�digest ����ֻ�ܱ�����һ�Ρ��ڵ��� digest ֮��MessageDigest �����������ó����ʼ״̬
            //System.out.println("----"+md5.digest());

            // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
            // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
            return new BigInteger(1,md5.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "md5"+str;
        }
    }

    /**
     * ����MD5���м���
     *
     * @param str   �����ܵ��ַ���
     * @return      ���ܺ���ַ���
     * @throws NoSuchAlgorithmException     û�����ֲ�����ϢժҪ���㷨
     */
    public String EncoderByMD5(String str) throws NoSuchAlgorithmException {

        //ȷ�����㷽��
        //MessageDigest ��ΪӦ�ó����ṩ��ϢժҪ�㷨�Ĺ��ܣ��� MD5 �� SHA �㷨��
        // ��ϢժҪ�ǰ�ȫ�ĵ����ϣ�����������������С�����ݣ�������̶����ȵĹ�ϣֵ
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //BASE64Encoder���м���
        BASE64Encoder base64en = new BASE64Encoder();

        //���ܺ���ַ�������
        String md5str = base64en.encode(md5.digest(str.getBytes()));
        return "md5Encoder"+md5str;
    }
}
