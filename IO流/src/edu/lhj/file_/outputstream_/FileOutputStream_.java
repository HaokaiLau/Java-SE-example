package edu.lhj.file_.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void FileOutput() {
        String pathname = "D:\\javacode\\FileIO\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //得到 FileOutputStream对象 对象
            // 说明
            //1. new FileOutputStream(filePath) 创建方式，当写入内容是，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容是，是追加到文件后面
            fileOutputStream = new FileOutputStream(pathname);
            //写入一个字节
            //fileOutputStream.write('H');//
            //写入一个字节数组
            String str = "hsp,world!";
            //str.getBytes() 可以把 字符串-> 字节数组
            //fileOutputStream.write(str.getBytes());
            /*
            write(byte[] b, int off, int len) 将 len字节从位于偏移量 off的指定字节数组写入此文件输出流
             */
            fileOutputStream.write(str.getBytes(), 0, 3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();//关闭文件流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
