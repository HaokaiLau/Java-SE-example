package edu.lhj.customgeneric;

import java.util.ArrayList;

public class CustomMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        //当调用方法,传入参数时,编译器就会确定类型
        car.fly("小鹏", 100);//String //Integer
        System.out.println("==================");
        car.fly(1.1, true);//Double //Boolean
        System.out.println("==================");
        Bus<String, ArrayList> bus = new Bus<>();
        bus.hi("巴士", new ArrayList());
    }
}
//泛型方法,可以定义在普通类中,也可以定义在泛型类中
class Car {//普通类
    public void run() {//普通方法

    }
    // <T, R>就是泛型,是提供给fly方法使用的
    public <T, R> void fly(T t, R r) {//泛型方法
        System.out.println(t.getClass());//String
        System.out.println(r.getClass());//Integer
    }
}
class Bus<E, Y> {//泛型类
    public <T, R> void run(T t, R r) {//泛型方法

    }
    //1.这个hi方法不是泛型方法
    //2.是hi方法使用了泛型类声明的泛型
    //3.泛型方法可以使用类声明的泛型,也可以使用自己声明的泛型
    public void hi(E e, Y y) {
        System.out.println(e.getClass());
        System.out.println(y.getClass());
    }
}