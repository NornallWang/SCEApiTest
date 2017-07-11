package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class LocalInnerDemo {

    public static void main(String[] args){
        LocalOuter outer = new LocalOuter();
        outer.showOuter();

    }

}

class LocalOuter{
    private String name = "�ⲿ���еı���name";
    private static String info = "�ⲿ���еľ�̬����info";
    private int age = 10;

    public void showOuter(){
        //�������
        String name = "�������ڵı���name";
        int age = 20;
        final String info = "�������ڵĳ���info";

        //����һ���ֲ��ڲ���
        class LocalInner{
            //��������
            private String name = "�ֲ��ڲ����еı���name";
            private int age = 30;

            //�����ֲ��ڲ���ķ���
            public void showInner(){
                System.out.println("�ֲ��ڲ����еķ���showInner");
                System.out.println(name);   //�ֲ��ڲ����еķ�����ִ�����������ڵı���
                System.out.println("�ھֲ��ڲ����д�ӡ�ⲿ���еı���name====>"+LocalOuter.this.name);
                System.out.println("�ھֲ��ڲ����д�ӡ�ⲿ���еľ�̬����info====>"+LocalOuter.info);
                System.out.println("�ֲ��ڲ���ֻ�ܷ���������ķ������еĳ���=====>"+info);
            }
        }

        //�ֲ��ڲ���������ɺ󣬷��ɴ�������󣬴Ӷ������䷽��
        LocalInner inner = new LocalInner();
        inner.showInner();
    }

}
