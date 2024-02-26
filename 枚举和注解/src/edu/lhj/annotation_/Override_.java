package edu.lhj.annotation_;

public class Override_ {
    public static void main(String[] args) {
        B b = new B();
        b.say();
    }
}

class A {
    public void say() {
        System.out.println("hi");
    }
}

class B extends A{
    //1. @Override注解放在say方法前,表示子类的fly方法重写了父类的fly方法
    //2.这里写了 @Override注解,编译器就会去检查该方法是否真的重写了父类中的同名
    // 方法,如果你的确重写了,则编译通过,如果没有构成重写,则编译错误,@Override注解
    //就相当于对该方法是否重写了进行了一次语法校验
    @Override //说明
    public void say() {
        System.out.println("你好");
    }
}
