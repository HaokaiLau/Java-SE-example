package edu.lhj.file_.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("d:\\javacode\\FileIO\\a4.txt"));
        printWriter.print("hi,你好");
        printWriter.close();
    }
}
