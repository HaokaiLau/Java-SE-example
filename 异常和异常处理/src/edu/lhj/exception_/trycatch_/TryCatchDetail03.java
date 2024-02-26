package edu.lhj.exception_.trycatch_;

public class TryCatchDetail03 {
    public static void main(String[] args) {
        //try-finally 程序出现异常时,也不会捕获异常,转而执行finally中的代码,然后程序退出
        try {
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        } finally {
            System.out.println("finally被执行...");
        }
        System.out.println("程序继续执行...");
    }
}
