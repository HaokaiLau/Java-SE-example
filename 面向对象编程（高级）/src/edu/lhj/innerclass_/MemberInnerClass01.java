package edu.lhj.innerclass_;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.say();
        //外部其他类,使用内部成员类的三种方法
        //1.用外部类的对象新建一个内部类的对象然后使用
        Outer05.Inner05 inner = outer05.new Inner05();
        inner.f1();
        System.out.println(inner.n2);
        //2.在外部类中编写一个getInnerInstance方法返回Inner05的实例,用外部类的对象直接
        //调用getInner05Instance方法即可接收内部类的对象
        Outer05.Inner05 innerInstance = outer05.getInnerInstance();
        System.out.println(innerInstance.n2);
        //3.相当于前两种方法合在一起,直接创建外部类对象再创建内部类对象
        Outer05.Inner05 inner005 = new Outer05().new Inner05();
        System.out.println(inner005.n2);
    }
}

class Outer05 {//外部类
    private int n2 = 200;
    private int n1 = 99;
    private String name = "Tim";
    //注意:成员内部类定义在外部类成员的位置(局部内部类定义在外部类的方法或者代码块中)
    //(匿名内部类可以当做实参传递,也可以直接作为对象建立)
    public class Inner05 {//成员内部类
        public int n2 = 100;
        public void f1() {
            //成员内部类和局部内部类一样,可以访问外部类中的所有成员,包括私有的
            System.out.println("name= " + name +
                    "\tn1= " + n1 + "\t外部类的n2= " + Outer05.this.n2);
        }
    }
    public Inner05 getInnerInstance() {
        return new Inner05();
    }

    public void say() {//定义一个方法
        //在方法中调用成员内部类
        Inner05 inner05 = new Inner05();
        inner05.f1();
        System.out.println(inner05.n2);
    }
}