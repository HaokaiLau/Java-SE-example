package edu.lhj.file_;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info() {
        File file = new File("d:\\javacode\\FileIO\\news1.txt");

        //调用相应的方法获得对应的信息
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件的名字=" + file.getName());
        System.out.println("文件的绝对路径=" + file.getAbsolutePath());
        System.out.println("文件的父级目录=" + file.getParent());
        System.out.println("文件的大小(字节)=" + file.length());//12个字节三个字母加3个中文
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("判断是否是一个文件=" + file.isFile());//T
        System.out.println("判断是否是一个目录=" + file.isDirectory());//F
    }
}
