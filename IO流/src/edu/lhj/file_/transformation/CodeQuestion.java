package edu.lhj.file_.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 如果文本文件的类型和编程软件设置的编码不一致会出现乱码的情况。
 * 设置文本文件的保存类型为ANSI,编程软件的编码格式是utf-8
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String pathname = "d:\\javacode\\FileIO\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(pathname));
        //由于编码格式不一致导致出现中文乱码问题
        //引出可以指定编码格式的转换流
        System.out.println(br.readLine());//lhj���ƿ�
        br.close();
    }
}
