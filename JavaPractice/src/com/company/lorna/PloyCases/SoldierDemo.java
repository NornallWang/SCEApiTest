package com.company.lorna.PloyCases;

/**
 * Created by goyoo on 2017/6/12.
 * �������ܣ�
 * ��дһ��soldier�࣬���������ձ���Ϊ�����Ե�һ��ʿ������
 * ��д½��ʿ��������ʿ��������������չSoldier��
 */
/*
    ������ƣ�
    ��ģһ��Soldier��
    ���Soldier������ͨ�����Ժͷ���
    ��ģһ��½��ʿ��������ʿ�������������̳�Soldier�࣬���Ӹ��Ե����е����Ժͷ���������д��Ӧ�ķ���
 */

public class SoldierDemo {

    public static void main(String[] args){
        Officer officer = new Officer("����Nornall");
        officer.giveCommand();
        System.out.println("************************");
        officer.giveCommand(officer.getSoldiers()[8]);  //�þ���ָ�ӵ���ս�Ŷ��еĵ�8��ʿ��ȥʵʩ����
    }

}

//����һ��ʿ���ĸ��࣬������
abstract class Soldier{
    //����ͨ�õ�����
    String sName;

    //���췽���������Խ��г�ʼ��
    public Soldier(String sName){
        this.sName = sName;
    }

    //����һ��get�������Ա��������ȡ����
    public String getsName(){
        return sName;
    }

    public void start(){
        System.out.println("սǰ׼������");
    }

    public abstract void attack();

    public void end(){
        System.out.println("����ս������");
    }

    //����һ���ձ����Ϊ
    public void action(){
        //��һ����׼������
        start();
        //�ڶ�������ս
        attack();   //��Ϊ��ͬ�����ʿ��ʵʩ�����ķ�ʽ��ͬ��������Ҫ��������Ϊһ�����󷽷�����������ʵ�־������Ϊ
        //������������ս��
        end();
    }

}

//����һ��ʿ�����ࣺ½��
class LandForce extends Soldier{

    //���췽������������ʵ��
    public LandForce(String lName){
        super(lName);
    }

    //ʵ�ֳ������еĳ��󷽷�
    public void attack(){
        System.out.println(getsName()+"ʹ�ò�ǹ���й�������");
    }
}

//����һ��ʿ�����ࣺ����
class Navy extends Soldier{

    //���췽������������ʵ��
    public Navy(String nName){
        super(nName);
    }

    //ʵ�ֳ������еĳ��󷽷�
    public void attack(){
        System.out.println(getsName()+"ʹ�����׽��й�������");
    }
}

//����һ��ʿ�����ࣺ�վ�
class AirForce extends Soldier{

    //���췽������������ʵ��
    public AirForce(String aName){
        super(aName);
    }

    //ʵ�ֳ������еĳ��󷽷�
    public void attack(){
        System.out.println(getsName()+"ʹ��ս�������й�������");
    }
}

//���������
class Officer extends Soldier{

    //һ�����ٳ��ж��ʿ��
    private Soldier[] soldiers=new Soldier[10];

    //���췽������������ʵ��
    public Officer(String oName){
        super(oName);
        //�ڹ��췽���ж�����ٳ�����Щʿ��
        soldiers[0] = new LandForce("½��Tom");
        soldiers[1] = new LandForce("½��Jerry");
        soldiers[2] = new LandForce("½��Jack");

        soldiers[3] = new Navy("����Damond");
        soldiers[4] = new Navy("����Herry");
        soldiers[5] = new Navy("����Philip");

        soldiers[6] = new AirForce("�վ�Jason");
        soldiers[7] = new AirForce("�վ�David");
        soldiers[8] = new AirForce("�վ�Micheal");
        soldiers[9] = new AirForce("�վ�Laven");
    }

    //����һ��get���������ظþ��������е�����ʿ��
    public Soldier[] getSoldiers(){
        return soldiers;
    }

    //ʵ�ֳ������еĳ��󷽷�
    public void attack(){
        System.out.println(getsName()+"�ں�ָ����ս����");
    }

    //�������ھ����Լ�����Ϊ������ʩ�����ʿ��һ�������ս�������Լ�
    public void giveCommand(){
        for (int i=0;i<soldiers.length;i++){
            soldiers[i].action();   //��ÿ��ʿ�������������ģ�巽��
        }
        //�����Լ���attack
        this.action();
    }

    //�������ھ����Լ�����Ϊ������ʩ���ĳ��ʿ��ȥʵʩ��ս
    //����ǰ�ߵ�giveCommand��������Soldier������Ϊ���ò���
    public void giveCommand(Soldier soldier){
        soldier.action();
    }
}