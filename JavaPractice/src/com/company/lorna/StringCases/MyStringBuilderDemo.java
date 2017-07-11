package com.company.lorna.StringCases;

import java.util.Arrays;

/**
 * Created by goyoo on 2017/7/4.
 */

public class MyStringBuilderDemo {
    public static void main(String[] args){

    }
}

class MyStringBuilder{
    //声明一个字符数组
    private char[] value;
    private int count;  //声明一个变量保存字符数组中存放的字符个数

    //无参构造方法
    public MyStringBuilder(){
        value = new char[16];   //默认16个字符的字符数组
    }

    //重载
    public MyStringBuilder(int capacity){
        value = new char[capacity]; //开辟一个capacity大小的容量的数组
    }

    //重载
    public MyStringBuilder(String str){
        value = new char[str.length()+16];
    }

    //得到字符数组中的存放的字符个数，返回count变量中的值
    public int length(){
        return count;
    }

    public int capacity(){
        return value.length;    //数组length是属性，不是方法
    }

    //实现字符串的追加
    public MyStringBuilder append(String str){
        int len = str.length();  //获取要添加的字符串的长度
        //长度要叫上本来的字符个数，并判断是否超过容量
        //确保字符数组能放进去所添加的字符串,大于的话要扩容
        ensureCapacity(count+len);
    }

    //仅对本类提供，不对外提供
    private void ensureCapacity(int capacity){
        //
        if(capacity-value.length>0){
            //数据超出了容量大小，则扩容
            int newCapacity = value.length*2+2; //扩容后的新字符数组的容量大小
            //扩容后，将原来的拷贝过去
           value = Arrays.copyOf(value,newCapacity);
        }
    }
}
