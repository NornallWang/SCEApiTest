package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class MultiExtendsDemo {
    public static void main(String[] args){
        C c = new C();

        //通过c的引用对象调用其两个内部类,从而实现同时调用其两个内部类的方法
        System.out.println();
        c.getC2A().showA();
        c.getC2B().showB();

        //直接调用其内部类的方法
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

//既要调用A类中的showA方法，又可以调用B类中的showB方法
class C {
    //声明一个内部类继承A类
    class InnerC2A extends A{
        public void showA(){
            super.showA();
        }
    }

    //声明一个内部类继承B类
    class InnerC2B extends B{
        public void showB(){
            super.showB();
        }
    }

    //获取InnerC2A的对象实例
    public InnerC2A getC2A(){
        return new InnerC2A();
    }

    //获取InnerC2B的对象实例
    public InnerC2B getC2B(){
        return  new InnerC2B();
    }

    //为了C类直接调用其内部类的方法，可以这么写
    public void showA(){
        new InnerC2A().showA();
    }

    public void showB(){
        new InnerC2B().showB();
    }
}
