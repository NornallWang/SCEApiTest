package com.company.lorna.PloyCases;

/**
 * Created by goyoo on 2017/6/12.
 * 案例介绍：
 * 编写一个soldier类，描述具有普遍行为和属性的一个士兵对象
 * 编写陆军士兵、海军士兵、军官类来扩展Soldier类
 */
/*
    案例设计：
    建模一个Soldier类
    设计Soldier类的相关通用属性和方法
    建模一个陆军士兵、海军士兵、军官类来继承Soldier类，增加各自的特有的属性和方法，并重写相应的方法
 */

public class SoldierDemo {

    public static void main(String[] args){
        Officer officer = new Officer("军官Nornall");
        officer.giveCommand();
        System.out.println("************************");
        officer.giveCommand(officer.getSoldiers()[8]);  //让军官指挥的作战团队中的第8个士兵去实施攻击
    }

}

//定义一个士兵的父类，抽象类
abstract class Soldier{
    //定义通用的属性
    String sName;

    //构造方法将其属性进行初始化
    public Soldier(String sName){
        this.sName = sName;
    }

    //声明一个get方法，以便其子类获取属性
    public String getsName(){
        return sName;
    }

    public void start(){
        System.out.println("战前准备！！");
    }

    public abstract void attack();

    public void end(){
        System.out.println("结束战斗！！");
    }

    //定义一个普遍的行为
    public void action(){
        //第一步，准备工作
        start();
        //第二步：作战
        attack();   //因为不同种类的士兵实施攻击的方式不同，所以需要将其声明为一个抽象方法，让其子类实现具体的行为
        //第三步：结束战斗
        end();
    }

}

//定义一个士兵种类：陆军
class LandForce extends Soldier{

    //构造方法，交给父类实现
    public LandForce(String lName){
        super(lName);
    }

    //实现抽象类中的抽象方法
    public void attack(){
        System.out.println(getsName()+"使用步枪进行攻击！！");
    }
}

//定义一个士兵种类：海军
class Navy extends Soldier{

    //构造方法，交给父类实现
    public Navy(String nName){
        super(nName);
    }

    //实现抽象类中的抽象方法
    public void attack(){
        System.out.println(getsName()+"使用鱼雷进行攻击！！");
    }
}

//定义一个士兵种类：空军
class AirForce extends Soldier{

    //构造方法，交给父类实现
    public AirForce(String aName){
        super(aName);
    }

    //实现抽象类中的抽象方法
    public void attack(){
        System.out.println(getsName()+"使用战斗机进行攻击！！");
    }
}

//定义军官类
class Officer extends Soldier{

    //一个军官持有多个士兵
    private Soldier[] soldiers=new Soldier[10];

    //构造方法，交给父类实现
    public Officer(String oName){
        super(oName);
        //在构造方法中定义军官持有哪些士兵
        soldiers[0] = new LandForce("陆军Tom");
        soldiers[1] = new LandForce("陆军Jerry");
        soldiers[2] = new LandForce("陆军Jack");

        soldiers[3] = new Navy("海军Damond");
        soldiers[4] = new Navy("海军Herry");
        soldiers[5] = new Navy("海军Philip");

        soldiers[6] = new AirForce("空军Jason");
        soldiers[7] = new AirForce("空军David");
        soldiers[8] = new AirForce("空军Micheal");
        soldiers[9] = new AirForce("空军Laven");
    }

    //定义一个get方法，返回该军官所持有的所有士兵
    public Soldier[] getSoldiers(){
        return soldiers;
    }

    //实现抽象类中的抽象方法
    public void attack(){
        System.out.println(getsName()+"在后方指挥作战！！");
    }

    //定义属于军官自己的行为：发号施令，所有士兵一起参与作战，包括自己
    public void giveCommand(){
        for (int i=0;i<soldiers.length;i++){
            soldiers[i].action();   //让每个士兵调用其自身的模板方法
        }
        //调用自己的attack
        this.action();
    }

    //定义属于军官自己的行为：发号施令，让某个士兵去实施作战
    //重载前边的giveCommand方法，将Soldier对象作为引用参数
    public void giveCommand(Soldier soldier){
        soldier.action();
    }
}