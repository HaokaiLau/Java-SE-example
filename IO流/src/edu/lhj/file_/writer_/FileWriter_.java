package edu.lhj.file_.writer_;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void fileWriter01() {
        String pathname = "d:\\javacode\\FileIO\\note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c','d','e'};
        String str = "遇见彩虹,吃定彩虹";

        try {
            fileWriter = new FileWriter(pathname);
            //1.write(int):写入单个字符
            //fileWriter.write('H');
            //2.write(char[] c):写入一个字符数组
            //fileWriter.write(chars);
            //3.write(char[] c,off,len):写入一个字符数组的指定部分
            //fileWriter.write(chars,0,4);
            //4.write(String):写入一个字符串
            //fileWriter.write(str);
            //5.write(String,off,len):写入一个字符串的指定部分
            fileWriter.write(str,0,4);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    //一定要关闭文件流或者刷新文件流才能真正把数据写入到文件中
                    fileWriter.close();//关闭文件流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
