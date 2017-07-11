package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class StaicInnerDemo {
    public static void main(String[] args){

        Outer outer = new Outer();
        outer.showOuter();

        //�����ڲ������
        Outer.Inner inner = new Outer.Inner();
        inner.showInner();

    }
}

class Outer{
    private String oName = "�ⲿ��";
    private int oAge = 20;
    //����һ���ⲿ��ľ�̬����
    private static String oInfo = "�����ⲿ���еľ�̬����";

    public void showOuter(){
        System.out.println("����"+oName+"������Ϊ��"+oAge);

        //���ⲿ����ʾ�̬�ڲ����еķǾ�̬����
        Inner inner = new Inner();
        System.out.println("���ⲿ������ڲ����еķǾ�̬����iName���ȴ�����̬�ڲ������Ȼ��ʹ�ö�����е��ã����Ϊ��\n"+inner.iName);

        //���ⲿ����ʾ�̬�ڲ����еľ�̬����
        System.out.println("���ⲿ������ڲ����еľ�̬����iInfo�������ڲ���.��̬�������ķ�ʽ�����Ϊ��\n"+Inner.iInfo);
    }

    //����һ����̬�ڲ���
    static class Inner{
        private String iName = "�ڲ���";
        private int iAge = 10;
        //����һ���ڲ���ľ�̬����
        private static String iInfo = "�����ڲ����еľ�̬����";

        public void showInner(){
            System.out.println("����"+iName+"������Ϊ��"+iAge);

            //��̬�ڲ����з����ⲿ��ķǾ�̬����
            System.out.println("�Ӿ�̬�ڲ�����ͼ�����ⲿ��Ǿ�̬����oAge,���ʷ�ʽΪOuter.this.oName������ʧ�ܡ�"+"��̬�ڲ��಻�ܷ����ⲿ���еķǾ�̬����");

            //��̬�ڲ����з����ⲿ��ľ�̬����
            System.out.println("�ھ�̬�ڲ������Outer.oInfo�ķ�ʽ�������ⲿ���еľ�̬���������Ϊ��\n"+Outer.oInfo);
        }
    }

}