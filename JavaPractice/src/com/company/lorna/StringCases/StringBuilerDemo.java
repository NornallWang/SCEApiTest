package com.company.lorna.StringCases;

/**
 * Created by goyoo on 2017/7/4.
 */
public class StringBuilerDemo {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();//无参构造方法，默认开辟了16个字符的空间
        // StringBuilder str2 = new StringBuilder(100); //初始化了容量大小为100的字符串
        //StringBuilder str3 = new StringBuilder("abc"); //初始化一个默认字符串

        str.append("hello");    //追加，只要不超过默认的16，则默认为其容量为16
        str.append(8);
        str.append(1.5);
        str.append(true);

        System.out.println(str.length());
        System.out.println(str.capacity()); //容量大小

        str.insert(5,"world");   //插入字符串
        System.out.println(str.toString());

        //替换操作
        str.replace(5,10,"Nornall");
        System.out.println(str);

        //首次出现的下标
        System.out.println(str.indexOf("Nornall"));

        //反转的方法
        System.out.println(str.reverse());

    }
}
