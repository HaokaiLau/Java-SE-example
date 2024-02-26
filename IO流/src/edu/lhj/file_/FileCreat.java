package edu.lhj.file_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class FileCreat {
    public static void main(String[] args) {

    }

    /* 方式一
    new File(String pathname)//根据路径构建一个File对象
     */
    @Test
    public void create01() {
        String pathname = "d:\\javacode\\FileIO\\news1.txt";
        File file = new File(pathname);

        try {
            file.createNewFile();//必须要执行createNewFile()方法才能真正的把文件创建出来
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* 方式二
    new File(File parent,String child)//根据父目录 + 子路径来创建文件
     */
    @Test
    public void create02() {
        File parent = new File("d:\\javacode\\FileIO");
        String child = "news2.txt";
        File file = new File(parent, child);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* 方式三
    new File(String parent,String child)//根据父目录 + 子路径来创建文件
     */
    @Test
    public void create03() {
        String parent = "d:\\javacode\\FileIO";
        String chile = "news3.txt";
        File file = new File(parent, chile);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //下面四个都是抽象类
    //InputStream //字节输入流
    //OutputStream //字节输出流
    //Reader //字符输入流
    //Writer //字符输出流
}

