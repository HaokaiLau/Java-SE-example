package edu.lhj.main_;

public class Main01 {

    //静态属性
    private static String name = "Tim";

    public static void print() {
        System.out.println("Jack");
    }

    public static void main(String[] args) {
        //main方法可以直接调用类中的静态属性
        System.out.println(name);
        //main方法也可以直接调用类中的静态方法
        Main01.print();
        //但是不能直接访问该类中的非静态属性和方法,必须先创建对象才能通过该对象去访问该类中的非静态对象和方法
    }
}
