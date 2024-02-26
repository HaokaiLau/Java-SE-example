package edu.lhj.abstract_;

public class AbstractDetail02 {
    public static void main(String[] args) {

    }
}

//抽象类的本质还是类,同样可以存在非抽象方法、构造器、静态属性等
abstract class AA {
    //静态属性
    public static int id;
    //抽象方法,是不能有方法体的
    //抽象方法不能使用private、final、static修饰,因为这些关键字与重写是相违背的
    public abstract void say();
    //非抽象方法
    public void hi() { }
    //构造器
    public AA() { }
}
class BB extends AA {
    //如果一个类继承了一个抽象类,则必须实现(重写)该抽象类中所有的抽象方法,除非他自己也声明为抽象类
    @Override
    public void say() {

    }
}
