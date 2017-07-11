package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/14.
 */
public class MemberInnerClass {
    public static void main(String[] args){
        //�����ⲿ��Ķ���
        OuterOne outerOne = new OuterOne();

        /*
        //�����ڲ���Ķ���
        OuterOne.InnerOne innerOne = outerOne.new InnerOne();
        //�����ڲ����еķ���
        innerOne.innerShow();
        */

        outerOne.outerShow();

    }
}

//����һ���࣬��Ϊ�ⲿ��
class OuterOne{
    //���Ժͷ���
    private String name = "�ⲿ��";
    private int age = 12;

    public void outerShow(){
        System.out.println("����"+name+",����Ϊ��"+age);
        //�ⲿ������ڲ��࣬��Ҫ�����ڲ���Ķ���
        InnerOne innerOne = new InnerOne();
        innerOne.innerShow();
    }

    //�����ڲ���
    public class InnerOne{
        //�ڲ�������Ժͷ���
        private String name = "�ڲ���";
        private int age2 = 13;
        private static final int number = 88;        //��Ա�ڲ����п���������̬�ĳ���

        //�ڳ�Ա�ڲ����в���������̬�ĳ�Ա��������̬�����Ժͷ�����
        //private static int staticAge = 20;

        public void innerShow(){
            System.out.println("����"+name+",����Ϊ��"+age2+"������һ����̬��������number��ֵΪ��"+number);

            //���ڲ����з����ⲿ��ĳ�Ա����
            System.out.println("�������ڲ����з��ʵ���"+OuterOne.this.name+",����Ϊ"+OuterOne.this.age);

            //��Ա�ڲ������ֱ�ӷ����ⲿ��ķ���������
            System.out.println("��Ա�ڲ������ֱ�ӷ����ⲿ��ķ��������ԣ�����Ϊ�����ⲿ��ķ���");
            System.out.print("���ǳ�Ա�ڲ��࣬��ֱ�ӷ��ʵ����ⲿ�෽�������ʽ��Ϊ��");
            //outerShow();
            System.out.println();
            System.out.println("�����ڳ�Ա�ڲ�����ֱ�ӷ��ʵ����ⲿ������name�����ʽ��Ϊ��"+age);



        }
    }
}
