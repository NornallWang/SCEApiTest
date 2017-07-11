package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class MultiExtendsDemo {
    public static void main(String[] args){
        C c = new C();

        //ͨ��c�����ö�������������ڲ���,�Ӷ�ʵ��ͬʱ�����������ڲ���ķ���
        System.out.println();
        c.getC2A().showA();
        c.getC2B().showB();

        //ֱ�ӵ������ڲ���ķ���
        c.showA();
        c.showB();
    }
}

class A{
    public void showA(){
        System.out.println("A");
    }
}

class B{
    public void showB(){
        System.out.println("B");
    }
}

//��Ҫ����A���е�showA�������ֿ��Ե���B���е�showB����
class C {
    //����һ���ڲ���̳�A��
    class InnerC2A extends A{
        public void showA(){
            super.showA();
        }
    }

    //����һ���ڲ���̳�B��
    class InnerC2B extends B{
        public void showB(){
            super.showB();
        }
    }

    //��ȡInnerC2A�Ķ���ʵ��
    public InnerC2A getC2A(){
        return new InnerC2A();
    }

    //��ȡInnerC2B�Ķ���ʵ��
    public InnerC2B getC2B(){
        return  new InnerC2B();
    }

    //Ϊ��C��ֱ�ӵ������ڲ���ķ�����������ôд
    public void showA(){
        new InnerC2A().showA();
    }

    public void showB(){
        new InnerC2B().showB();
    }
}
