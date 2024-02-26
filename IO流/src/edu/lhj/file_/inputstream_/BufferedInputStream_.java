package edu.lhj.file_.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class BufferedInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void bufferedInputStream01() {
        String pathname = "d:\\javacode\\FileIO\\b.txt";
        int readDate = 0;
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(pathname));
            while ((readDate = bis.read()) != -1) {
                System.out.print((char) (readDate));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void bufferedInputStream02() {
        String pathname = "d:\\javacode\\FileIO\\b.txt";
        int readLen = 0;
        byte[] bytes = new byte[8];
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(pathname));
            while ((readLen = bis.read(bytes)) != -1) {
                System.out.print(new String(bytes,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
