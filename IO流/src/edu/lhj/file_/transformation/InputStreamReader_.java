package edu.lhj.file_.transformation;

import java.io.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 演示使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream 转成字符流  InputStreamReader, 指定编码 gbk
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String pathname = "d:\\javacode\\FileIO\\a.txt";
        //1.创建字节流 FileInputStream对象
        //FileInputStream fis = new FileInputStream(pathname);
        //2.创建转换流对象,传入字节流对象,指定编码格式为gbk
        //InputStreamReader isr = new InputStreamReader(fis,"gbk");
        //3.创建处理流对象,传入转换流对象
        //BufferedReader br = new BufferedReader(isr);

        //在日常开发中,会把1 2 3步合并为一步
        BufferedReader br = new BufferedReader(
                                    new InputStreamReader(
                                            new FileInputStream(pathname),"gbk"));

        System.out.println(br.readLine());
        //关闭最外层流
        br.close();
    }
}
