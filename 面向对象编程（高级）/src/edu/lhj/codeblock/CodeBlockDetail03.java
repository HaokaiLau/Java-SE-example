package edu.lhj.codeblock;

public class CodeBlockDetail03 {
    public static void main(String[] args) {
        new BBB();
    }
}

class AAA {
    //普通代码块
    {
        System.out.println("AAA 的普通代码块被调用");
    }
    //AAA的无参构造器
    public AAA() {
        //super()(这里隐藏了一个super())
        System.out.println("AAA 的无参构造器被调用");
    }
}
class BBB extends AAA {
    //BBB的无参构造器
    public BBB() {
        //super()(这里隐藏了一个super())
        System.out.println("BBB 的无参构造器被调用");
    }
}