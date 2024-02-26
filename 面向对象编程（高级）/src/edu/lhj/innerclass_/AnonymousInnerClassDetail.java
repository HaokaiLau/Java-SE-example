package edu.lhj.innerclass_;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.f1();
    }
}

class Outer04 {
    private int n1 = 99;
    public void f1() {
        //底层:class 匿名内部类 extends Person{}
        Person person = new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法...");
            }
        };
        person.hi();//动态绑定,运行类型是Outer04$1

        new Person() {
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法哈哈哈...");
            }
        }.hi();//因为匿名内部类的本质既是一个类也是一个对象,所以还可以直接调用方法
    }
}

class Person {//普通类 还可以是接口、抽象类
    public void hi() {
        System.out.println("Person hi()");
    }
}
