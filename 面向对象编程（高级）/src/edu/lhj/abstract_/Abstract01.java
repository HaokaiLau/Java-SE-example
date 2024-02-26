package edu.lhj.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
        Cat cat = new Cat("小白");
        cat.eat();
    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //    public void eat() {
//        System.out.println("动物在吃东西,但不知道在吃什么");
//    }
    //这里的eat即使实现了,也没什么意义
    //即父类的不确定性,我们考虑把该方法设计成抽象方法
    //所谓的抽象方法就是没有实现的方法,没有实现的意思就是没有方法体
    //当一个类中存在抽象方法,则要把该类改为抽象类
    //一般抽象类会被继承,由其子类来重写抽象方法并实现
    public abstract void eat();
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}