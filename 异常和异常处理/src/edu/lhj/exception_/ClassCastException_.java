package edu.lhj.exception_;

public class ClassCastException_ {
    public static void main(String[] args) {
        //类型转换异常
        A b = new B();//向上转型
        B b2 = (B)b;//向下转型
        C c = (C)b;//企图把一个B类型的对象强转成一个C类型的对象
        //由于B类和C类没有任何关系,所以会抛出类型转换异常
    }
}

class A { }
class B extends A { }
class C extends A { }
