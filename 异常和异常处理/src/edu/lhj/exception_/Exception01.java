package edu.lhj.exception_;

public class Exception01 {
    public static void main(String[] args) {
        //算术异常
        int num1 = 10;
        int num2 = 0;
        //当执行到 num1 / num2 时,程序会抛出异常 ArithmeticException(算术异常)
        //抛出该异常后,程序就会退出,下面的代码就不再执行
        //这样的程序好吗? 不好,因为不应该出现了一个不算致命的问题就导致整个程序崩溃
        //所以java设计者提供了一个异常处理机制来解决这个问题

        //如果程序员感觉一段代码可能会抛出异常,可以使用try-catch异常处理机制来解决
        //从而保证我们程序的健壮性
        //使用方法:将改代码块选中,输入Ctrl + Alt + T,然后从选择列表中选择try/catch
        //作用:当运行到该代码出现异常时,程序会捕获该异常,并继续向下执行
        try {
            int res = num1 / num2;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("程序继续运行...");
    }
}
