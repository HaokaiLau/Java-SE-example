package edu.lhj.file_.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class FileCopy_ {
    public static void main(String[] args) {

    }

    @Test
    public void fileCopy() {
        //完成图片文件的拷贝,从D:\javacode\FileIO\灵魂莲华阿狸.jpg
        //拷贝到D:\javacode\FileIO\picture\灵魂莲华阿狸.jpg
        // 思路分析
        //1.创建文件输入流,把文件输入到内存中
        //2.创建文件输出流,把文件从内存中输出到另一个文件中
        String srePathname = "D:\\javacode\\FileIO\\灵魂莲华阿狸.jpg";
        String destPathname = "D:\\javacode\\FileIO\\picture\\灵魂莲华阿狸.jpg";
        int readLen = 0;
        byte[] bytes = new byte[1024];
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srePathname);
            fileOutputStream = new FileOutputStream(destPathname);
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                //读取后就通过fileOutputStream输出到文件中,注意是边读边写
                //注意要读多少长写多长,不能使用bytes.length,
                // 否则最后一次读取不足bytes.length时可能会造成文件的缺失
                fileOutputStream.write(bytes,0,readLen);
            }
            System.out.println("拷贝完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();//关闭文件输入流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();//关闭文件输出流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
