package edu.lhj.codeblock;


public class CodeBlockDetail04 {
    public static void main(String[] args) {
        Son son = new Son();
    }
}
//若存在继承关系,则调用顺序如下:(原理:静态相关的在类加载时就会被调用)
//1.父类的静态代码块和静态属性(优先级一样,存在多个则按定义顺序调用)
//2.子类的静态代码块和静态属性(优先级一样,存在多个则按定义顺序调用)
//3.父类的普通代码块和普通属性(优先级一样,存在多个则按定义顺序调用)
//4.父类的构造器
//5.父类的普通代码块和普通属性(优先级一样,存在多个则按定义顺序调用)
//6.子类的构造器
class GrandParents {
    //普通属性
    private int n6 = getN6();
    public int getN6() {
        System.out.println("GrandParents 的普通属性被调用");
        return 100;
    }
    //静态属性
    private static int n3 = getN3();
    public static int getN3() {
        System.out.println("GrandParents 的静态属性被调用");
        return 100;
    }
    //无参构造器
    public GrandParents() {
        //super()(这里隐藏了一个super())
        System.out.println("GrandParents 的无参构造器被调用");
    }
    //普通代码块
    {
        System.out.println("GrandParents 的普通代码块被调用");
    }
    //静态代码块
    static {
        System.out.println("GrandParents 的静态代码块被调用");
    }
}
class Parents extends GrandParents{
    //无参构造器
    public Parents() {
        //super()(这里隐藏了一个super())
        System.out.println("Parents 的无参构造器被调用");
    }
    //普通代码块
    {
        System.out.println("Parents 的普通代码块被调用");
    }
    //静态代码块
    static {
        System.out.println("Parents 的静态代码块被调用");
    }
    //静态属性
    private static int n4 = getN4();
    public static int getN4() {
        System.out.println("Parents 的静态属性被调用");
        return 100;
    }
}
class Son extends Parents{
    //无参构造器
    public Son() {
        //super()(这里隐藏了一个super())
        System.out.println("Son 的无参构造器被调用");
    }
    //普通代码块
    {
        System.out.println("Son 的普通代码块被调用");
    }
    //静态代码块
    static {
        System.out.println("Son 的静态代码块被调用");
    }
    //静态属性
    private static int n5 = getN5();
    public static int getN5() {
        System.out.println("Son 的静态属性被调用");
        return 100;
    }
}