package edu.lhj.file_.transformation;

import java.io.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 把字节流 FileOutputStream 转成一个字符流 OutputStreamWriter,指定编码gbk
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String pathname = "d:\\javacode\\FileIO\\a2.txt";
        BufferedWriter bw = new BufferedWriter(
                                    new OutputStreamWriter(
                                            new FileOutputStream(pathname), "gbk"));
        bw.write("hi,我是刘浩楷");
        bw.close();//同样是关闭最外层流
        System.out.println("文件以指定编码格式保存成功~");
    }
}
