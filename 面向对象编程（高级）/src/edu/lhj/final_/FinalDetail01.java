package edu.lhj.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        C c = new C();
        E e = new E();
        //虽然final修饰的方法不能被重写,但是继承后仍然可以调用
        e.say();
    }
}

class A {
    //1.final修饰的属性又叫常量,一般用XX_XX_XX来命名
    //2.final修饰的属性在定义时,必须赋初始值,并且以后都不能修改,赋值可以在一下位置之一进行:
    //1.在属性定义时 2.在构造器中 3.在代码块中
    public final double TAX_RATE = 0.08;
    public final double TAX_RATE2;
    public final double TAX_RATE3;
    //在代码块中赋值
    {
        TAX_RATE3 = 2.2;
    }
    //在构造器中赋值
    public A(double TAX_RATE2) {
        this.TAX_RATE2 = 1.1;
    }
}

class B {
    //final修饰静态属性时,只能在定义时赋值或在静态代码块中赋值
    public static final double TAX_RATE4 = 3.3;
    public static final double TAX_RATE5;
    //静态代码块
    static {
        TAX_RATE5 = 4.4;
    }
}

//final修饰的类无法被继承,但依然可以实例化
final class C { }

class D {
    //如果类不是final类但含有final修饰的方法,则该类可以继承,但final方法不能重写
    public final void say() {
        System.out.println("say方法被调用...");
    }
}
class E extends D {
    //'say()' cannot override 'say()' in 'edu.lhj.final_.D'; overridden method is final
//    public void say() {
//        System.out.println("say方法被调用...");
//    }
}