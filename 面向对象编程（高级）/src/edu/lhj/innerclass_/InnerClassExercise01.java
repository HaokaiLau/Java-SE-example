package edu.lhj.innerclass_;

public class InnerClassExercise01 {
    public static void main(String[] args) {//此时主方法变成了外部类
        //传统方法,先把类实例化对象,再把对象作为参数传进去
        f1(new Car());
        //使用匿名内部类,把匿名内部类直接作为参数传进方法中
        f1(new IE() {//内部类
            @Override
            public void show() {
                System.out.println("这是一幅画...");
            }
        });
    }
    public static void f1(IE ie) {
        ie.show();
    }
}

interface IE {
    void show();
}

//传统方法,先创建一个类,然后实现接口,再实例化对象
class Car implements IE{

    @Override
    public void show() {
        System.out.println("这是一辆车");
    }
}
