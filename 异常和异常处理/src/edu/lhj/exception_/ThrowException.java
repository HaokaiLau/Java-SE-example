package edu.lhj.exception_;

public class ThrowException {
    public static void main(String[] args) {
        try {
            ThrowException.ReturnMethodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ThrowException.ReturnMethodB());
    }

    public static void ReturnMethodA() {
        try {
            System.out.println("进入方法A");//1
            throw new RuntimeException("制造异常");//抛出异常 3
        } finally {
            System.out.println("进入A方法的finally...");//2
        }
    }
    public static int ReturnMethodB() {
        try {
            System.out.println("进入方法B");//4
            return 1;//最后
        } finally {
            System.out.println("进入B方法的finally...");//5
        }
    }
}
