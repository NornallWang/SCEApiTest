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
    //����һ���ַ�����
    private char[] value;
    private int count;  //����һ�����������ַ������д�ŵ��ַ�����

    //�޲ι��췽��
    public MyStringBuilder(){
        value = new char[16];   //Ĭ��16���ַ����ַ�����
    }

    //����
    public MyStringBuilder(int capacity){
        value = new char[capacity]; //����һ��capacity��С������������
    }

    //����
    public MyStringBuilder(String str){
        value = new char[str.length()+16];
    }

    //�õ��ַ������еĴ�ŵ��ַ�����������count�����е�ֵ
    public int length(){
        return count;
    }

    public int capacity(){
        return value.length;    //����length�����ԣ����Ƿ���
    }

    //ʵ���ַ�����׷��
    public MyStringBuilder append(String str){
        int len = str.length();  //��ȡҪ��ӵ��ַ����ĳ���
        //����Ҫ���ϱ������ַ����������ж��Ƿ񳬹�����
        //ȷ���ַ������ܷŽ�ȥ����ӵ��ַ���,���ڵĻ�Ҫ����
        ensureCapacity(count+len);
    }

    //���Ա����ṩ���������ṩ
    private void ensureCapacity(int capacity){
        //
        if(capacity-value.length>0){
            //���ݳ�����������С��������
            int newCapacity = value.length*2+2; //���ݺ�����ַ������������С
            //���ݺ󣬽�ԭ���Ŀ�����ȥ
           value = Arrays.copyOf(value,newCapacity);
        }
    }
}
