package com.company.lorna.AutoBoxCases;

/**
 * Created by goyoo on 2017/6/16.
 */
public class AutoBoxDemo {

    public static void main(String[] args){

        //����һ�������������ͣ�int
        int i = 10;
        //����һ�������������ͣ�double
        double j = 10.5;

        //�ѻ����������͸�ֵ���������ͣ��������ͻ��ڱ����ʱ���Զ�װ��
        Integer ii = i;
        //System.out.println("ii="+ii);
        System.out.println("ii="+ii.intValue());    //�ϱ�д���ʹ�д���Ľ����һ�µ�

        Double jj = j;
        System.out.println("jj="+j);

        //�Ѱ�װ�ࣨ�������ͣ���ֵ�������������͵�ʱ�򣬻��Զ�����
        //i = ii;
        i = ii.intValue();  //�ϱߵ�д���ʹ�д���Ľ����һ�µ�
        System.out.println("i="+i);
        //j = jj;
        j = jj.doubleValue();   //�ϱߵ�д���ʹ�д���Ľ����һ�µ�
        System.out.println("j="+j);

        //�ѻ����������͸�ֵ��Object
        Object o = i;
        System.out.println("o="+o);

        Integer b = (Integer) o;
        System.out.println("b="+b.intValue());

    }
}
