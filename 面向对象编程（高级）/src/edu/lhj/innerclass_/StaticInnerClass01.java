package edu.lhj.innerclass_;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer06 outer06 = new Outer06();
        outer06.say();
        //1.因为静态内部类可以直接通过类名的形式直接访问,前提是满足访问权限
        Outer06.Inner06 inner006 = new Outer06.Inner06();
        inner006.f1();
        //2.编写一个getInnerInstance方法,返回一个Inner对象,通过
        //调用getInnerInstance方法来接收对象
        Outer06.Inner06 innerInstance = outer06.getInnerInstance();
        innerInstance.f1();
        //3.编写一个静态的getInnerInstance_方法,返回一个Inner对象,
        //直接用外部类名.getInnerInstance_来接收对象
        Outer06.Inner06 innerInstance_ = Outer06.getInnerInstance_();
        innerInstance_.f1();
    }
}

class Outer06 {
    private static int n1 = 100;
    private static String name = "Jack";
    private static void cry() {
        System.out.println("小孩在哭...");
    }
    //静态内部类
    //1.放在外部类的成员位置
    //2.用static修饰符修饰
    //3.可以添加四种权限修饰符(public,protected,默认,private),因为它的本质是一个类,同时也是一个成员
    static class Inner06 {
        public void f1() {
            //可以访问外部类的所有静态成员,包含私有的,但不能访问非静态成员
            System.out.println("n1= " + n1 + "\tname= " + name);
            cry();
        }
    }
    public Inner06 getInnerInstance() {
        return new Inner06();
    }
    public static Inner06 getInnerInstance_() {
        return new Inner06();
    }
    //访问静态内部类:先创建内部类对象再访问
    public void say() {
        Inner06 inner06 = new Inner06();
        inner06.f1();
    }
}
