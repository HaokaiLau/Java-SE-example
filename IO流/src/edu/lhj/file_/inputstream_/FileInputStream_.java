package edu.lhj.file_.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    //使用read()方法
    //弊端:单个单个字节的读取效率很低
    @Test
    public void FileInput() {
        String pathname = "D:\\javacode\\FileIO\\hello.txt";
        int readDate = 0;//用于接收从文件输入的内容
        FileInputStream fileInputStream = null;//用于接收FileInputStream对象

        //read()方法,每次从输入流中读取一个字节的数据,依次读取到文件的末尾,如果没有输入可用,该方法会被阻止
        //如果返回一个-1,则表示文件读取完毕
        try {
            //创建一个FileInputStream对象,把文件路径传进去
            fileInputStream =  new FileInputStream(pathname);
            while ((readDate = fileInputStream.read()) != -1) {
                //由于read方法返回的数据是int的类型,所以还要转型成char才能正常显示
                System.out.print((char) readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//当使用输入流/输出流时,执行完操作一定要关闭文件流,释放资源
            try {
                fileInputStream.close();//关闭文件流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用read(byte[] b)方法
    //可以读取多个字节(取决于b字节数组的长度)
    @Test
    public void FileInput02() {
        String pathname = "D:\\javacode\\FileIO\\hello.txt";
        byte[] bytes = new byte[8];
        int readLen = 0;//用于接收从文件输入的内容的长度
        FileInputStream fileInputStream = null;//用于接收FileInputStream对象

        //read(byte[] b)方法,每次从输入流中读取最多b.length的数据,依次读取到文件的末尾,
        // 如果没有输入可用,该方法会被阻止
        //返回-1,则表示文件读取完毕
        //读取的长度超过b.length,则最多读取b.length的数据,返回b.length的长度
        //读取的长度不足b.length,则返回读取的长度
        //即正常读取,每次返回读取的长度
        try {
            //创建一个FileInputStream对象,把文件路径传进去
            fileInputStream =  new FileInputStream(pathname);
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//当使用输入流/输出流时,执行完操作一定要关闭文件流,释放资源
            try {
                fileInputStream.close();//关闭文件流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
