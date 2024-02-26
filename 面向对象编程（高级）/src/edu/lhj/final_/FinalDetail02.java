package edu.lhj.final_;

public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BB.n1);
    }
}

final class AA {
    //final不能修饰构造器
    //一般来说,如果类已经用final修饰,就没必要在把方法用final修饰
//    public final void call() { }
    public void call() { }
}

class BB {
    //static和final往往搭配使用,不会导致类加载,效率更高
    public final static int n1 = 888;
    static {
        System.out.println("BB 的静态代码块被调用...");
    }
}
