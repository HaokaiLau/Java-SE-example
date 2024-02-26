package edu.lhj.file_.outputstream_;

import java.io.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class BufferedCopy02 {
    public static void main(String[] args) {
//        String srcPathname = "D:\\javacode\\FileIO\\灵魂莲华阿狸.jpg";
//        String destPathname = "D:\\javacode\\FileIO\\picture\\灵魂莲华阿狸.jpg";
        //字节流可以操作二进制文件,还可以操作文本文件,而字符流不能操作二进制文件
        String srcPathname = "D:\\javacode\\FileIO\\code.txt";
        String destPathname = "D:\\javacode\\FileIO\\code3.txt";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        int readLen = 0;
        byte[] b = new byte[1024];

        try {
            bis = new BufferedInputStream(new FileInputStream(srcPathname));
            bos = new BufferedOutputStream(new FileOutputStream(destPathname));
            while ((readLen = bis.read(b)) != -1) {
                bos.write(b,0,readLen);
            }
            System.out.println("拷贝完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
