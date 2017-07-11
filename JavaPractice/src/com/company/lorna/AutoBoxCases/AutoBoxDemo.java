package com.company.lorna.AutoBoxCases;

/**
 * Created by goyoo on 2017/6/16.
 */
public class AutoBoxDemo {

    public static void main(String[] args){

        //声明一个基本数据类型：int
        int i = 10;
        //声明一个基本数据类型：double
        double j = 10.5;

        //把基本数据类型赋值给引用类型，基本类型会在编译的时候自动装箱
        Integer ii = i;
        //System.out.println("ii="+ii);
        System.out.println("ii="+ii.intValue());    //上边写法和此写法的结果是一致的

        Double jj = j;
        System.out.println("jj="+j);

        //把包装类（引用类型）赋值给基本数据类型的时候，会自动拆箱
        //i = ii;
        i = ii.intValue();  //上边的写法和此写法的结果是一致的
        System.out.println("i="+i);
        //j = jj;
        j = jj.doubleValue();   //上边的写法和此写法的结果是一致的
        System.out.println("j="+j);

        //把基本数据类型赋值给Object
        Object o = i;
        System.out.println("o="+o);

        Integer b = (Integer) o;
        System.out.println("b="+b.intValue());

    }
}
