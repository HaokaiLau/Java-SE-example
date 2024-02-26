package edu.lhj.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littlemonkey = new LittleMonkey("吉吉");
        littlemonkey.Climbing();
        littlemonkey.swimming();
        littlemonkey.run();
    }
}
//1.接口和继承解决的问题不一样
//继承的价值主要在于解决代码的复用性和可维护性
//接口的价值主要在于设计好各种规范,让其他类去实现这些方法
//2.接口比继承更加灵活
//继承是满足is - a的关系,而接口只需要满足like - a的关系
//3.接口在一定程度上实现代码的解耦

//鱼游泳的能力
interface Fishable {
    void swimming();
}
//小狗跑的能力
interface Dogable {
    void run();
}

//父类Monkey,带有爬树的方法
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Climbing() {
        System.out.println(name + " 会爬树");
    }
}
//LittleMonkey类继承Monkey类
class LittleMonkey extends Monkey implements Fishable,Dogable{//继承只能是单继承,但可以通过实现多个接口来扩展子类的功能

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "经过学习,学会了像鱼儿一样游泳");
    }

    @Override
    public void run() {
        System.out.println(getName() + "经过学习,学会了像狗一样跑");
    }
}