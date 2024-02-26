package edu.lhj.innerclass_;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.f1();
    }
}
class Outer02 {//外部类
    private int n1 = 10;
    private void f3() {//外部类的一个私有方法
        System.out.println("这是外部类的一个私有方法");
    }
    public void f1() {//外部类的一个方法
        //1.局部内部类是定义在外部类中的局部位置,通常定义在方法中
        //3.局部内部类无法添加访问修饰符,但可以添加final关键字
        //4.作用域:仅仅在定义它的方法体或者代码块中
        class Inner02 {//内部类(本质上仍然是一个类,可以拥有类的五大成员)
            //2.内部类可以访问外部类中的所有成员,包括私有的成员
            public void f2() {//内部类的一个方法
                //5.局部内部类可以直接访问外部类的成员
                //7.如果外部类和局部内部类的成员重名时,默认遵循就近原则,如果想指定访问
                // 外部类的成员,可以使用(外部类名.this.成员名)进行调用
                int n1 = 100;
                //Outer02.this本质是外部类的对象,即哪个对象调用了f2,Outer02.this就是哪个对象
                System.out.println("外部类的n1=" + Outer02.this.n1);
                System.out.println("内部类的n1=" + n1);
                f3();
            }
        }
        //6.外部类可以在定义内部类的方法中创建该内部类的对象,然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f2();
    }
}