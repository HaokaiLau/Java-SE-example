package edu.lhj.codeblock;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        //类被加载的情况举例:
        //1.创建对象实例时,类被加载
//        AA aa = new AA();
        //2.创建子类对象实例时,父类也会被加载
//        BB bb = new BB();
        //3.使用类的静态成员(静态属性、静态方法)时,类也会被加载
//        System.out.println(Cat.num);

        //静态代码块是在类加载时执行的,而且只会执行一次
        //而普通代码块是在创建对象的时候执行,创建一个对象就执行一次
//        DD dd = new DD();
//        DD dd1 = new DD();
        System.out.println(DD.n1);
    }
}

class DD{
    public static int n1 = 8888;
    //静态代码块
    static {
        System.out.println("DD类的静态代码块1被执行...");
    }
    //非静态代码块
    {
        System.out.println("DD类的非静态代码块1被执行...");
    }
}

class Cat{
    public static int num = 999;
    //静态代码块
    static {
        System.out.println("Cat类的静态代码块1被执行...");
    }
}

class BB extends AA{
    //静态代码块
    static {
        System.out.println("BB类的静态代码块1被执行...");
    }
}

class AA{
    //静态代码块
    static {
        System.out.println("AA类的静态代码块1被执行...");
    }
}
