package edu.lhj.interface_;

public interface AInterface {
    public int n1 = 10;
    //在接口中,抽象方法可以省略abstract
    public void hi();
    //在jdk8以后,在接口中可以有默认实现的方法,但是需要用default关键字进行修饰
    default public void ok() {
        System.out.println("ok");
    }
    //在jdk8以后,在接口中还可以有静态方法,但是需要用default关键字进行修饰
    public static void hello() {
        System.out.println("hello");
    }
}
