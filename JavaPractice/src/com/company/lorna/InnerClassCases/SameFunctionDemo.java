package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class SameFunctionDemo {
    public static void main(String[] args){
        Son son = new Son();
        son.show();
        son.getShow();
    }
}

//����һ�������࣬������һ�����󷽷���������Ϊshow
abstract class Parent{
    public abstract void show();
}

//����һ���ӿڣ�������һ��������������Ϊshow
interface IShow{
    public abstract void show();
}

//Ŀ�꣺ʵ��ͬʱ���ýӿںͳ������е�ͬ������
//����һ���࣬�̳г�����Parent
class Son extends Parent{
    //ʵ�ֳ������еĳ��󷽷�
    public void show(){
        System.out.println("���ǳ�����Parent�г��󷽷�show�ľ���ʵ��");
    }

    //����һ���ڲ��࣬�̳нӿ�IShow��ʵ����show����
    private class InnerClassA implements IShow{
        //ʵ�ּ̳��ԵĽӿ��еķ���
        public void show() {
            System.out.println("���ǽӿ�IShow�еķ���show�ľ���ʵ��");
        }
    }

    //����һ������getShow���Ա���������ڲ����е�show����
    public void getShow(){
        new InnerClassA().show();
    }
}