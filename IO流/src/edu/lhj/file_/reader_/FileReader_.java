package edu.lhj.file_.reader_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class FileReader_ {
    public static void main(String[] args) {

    }

    //使用read()方法一次读取一个字符,返回-1表示读取完毕
    @Test
    public void fileReader01() {
        String pathname = "d:\\javacode\\FileIO\\code.txt";
        int readDate = 0;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(pathname);
            //使用read()方法
            while ((readDate = fileReader.read()) != -1) {
                System.out.print((char) readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();//关闭文件流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //使用read(char[] c)一次读取最多c.length个字符,返回-1表示读取完毕
    @Test
    public void fileReader02() {
        String pathname = "d:\\javacode\\FileIO\\code.txt";
        int readLen = 0;
        char[] chars = new char[8];
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(pathname);
            //使用read(char[] c)方法
            while ((readLen = fileReader.read(chars)) != -1) {
                System.out.print(new String(chars,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();//关闭文件流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
