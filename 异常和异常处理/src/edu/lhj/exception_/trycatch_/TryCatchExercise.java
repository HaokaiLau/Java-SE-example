package edu.lhj.exception_.trycatch_;

import java.util.Scanner;

public class TryCatchExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String str = "";
        while (true) {
            System.out.print("请输入一个整数:");
            str = scanner.next();
            try {
                num =  Integer.parseInt(str);//当用户输入的字符串不是整数时,可能会抛出数字格式化异常
                break;

            } catch (NumberFormatException e) {//出现异常则执行catch
                //执行完catch后会跳出整个try-catch然后继续向下执行
                System.out.println("你输入的不是整数...");
            }finally {//无论是否出现异常,finally都会执行
                System.out.println("finally被调用...");
            }
        }
        System.out.println("你输入了一个整数" + num);
    }
}
