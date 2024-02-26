package edu.lhj.codeblock;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        A a = new A();
    }
}

//代码块在一个的调用顺序为:
//1.第一步先调用静态代码块和静态属性初始化,静态代码块和静态属性初始化优先级一样,如果有多个
//静态代码块和静态属性初始化,则按他们定义的顺序调用
//2.第二部调用普通代码块和普通属性初始化,普通代码块和普通属性初始化优先级一样,如果有多个
//普通代码块和普通属性初始化,则按他们定义的顺序调用
//3.最后才调用构造器
class A {
    //无参构造器
    public A() {
        System.out.println("A 的无参构造器被调用");
    }

    //普通代码块
    {
        System.out.println("A 的普通代码块被调用");
    }

    //静态代码块
    static {
        System.out.println("A 的静态代码块被调用");
    }

    //普通属性
    private int n2 = getN2();
    //静态属性
    private static int n1 = getN1();

    public static int getN2() {
        System.out.println("A 的普通属性被调用");
        return 200;
    }

    public static int getN1() {
        System.out.println("A 的静态属性被调用");
        return 100;
    }
}