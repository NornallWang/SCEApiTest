package com.company.lorna.StringCases;

/**
 * Created by goyoo on 2017/7/4.
 */
public class StringBuilerDemo {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();//�޲ι��췽����Ĭ�Ͽ�����16���ַ��Ŀռ�
        // StringBuilder str2 = new StringBuilder(100); //��ʼ����������СΪ100���ַ���
        //StringBuilder str3 = new StringBuilder("abc"); //��ʼ��һ��Ĭ���ַ���

        str.append("hello");    //׷�ӣ�ֻҪ������Ĭ�ϵ�16����Ĭ��Ϊ������Ϊ16
        str.append(8);
        str.append(1.5);
        str.append(true);

        System.out.println(str.length());
        System.out.println(str.capacity()); //������С

        str.insert(5,"world");   //�����ַ���
        System.out.println(str.toString());

        //�滻����
        str.replace(5,10,"Nornall");
        System.out.println(str);

        //�״γ��ֵ��±�
        System.out.println(str.indexOf("Nornall"));

        //��ת�ķ���
        System.out.println(str.reverse());

    }
}
