package edu.lhj.file_.standard;

import java.util.Scanner;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class InputAndOutput {
    public static void main(String[] args) {
        //System.in
        //是System类中的一个属性public static final InputStream in = null;
        //编译类型是InputStream
        //运行类型是BufferedInputStream
        //表示标准输入(从键盘输入)
        System.out.println(System.in.getClass());//class java.io.BufferedInputStream

        //System.out
        //是System类中的一个属性public static final PrintStream out = null;
        //编译类型是PrintStream
        //运行类型是PrintStream
        //表示标准输出(输出到显示器)
        System.out.println(System.out.getClass());//class java.io.PrintStream

        System.out.println("hello,world");

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println("next = " + next);
    }
}
