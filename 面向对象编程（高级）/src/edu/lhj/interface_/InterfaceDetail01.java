package edu.lhj.interface_;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        //new IA();错误,接口无法被实例化
    }
}

//1.接口不能被实例化
//2.接口中默认所有方法的访问权限都是public,接口中的抽象方法可以省略abstract关键字
//3.一个普通类要实现该接口,就必须把该接口中所有的抽象方法都实现
//4.当抽象类实现一个接口时,可以不用实现接口中的抽象方法
interface IA {
    void hi();
    void say();
}

class Cat implements IA {//alt + Enter可快速实现接口中所有的抽象方法

    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}

abstract class Dog implements IA{

}
