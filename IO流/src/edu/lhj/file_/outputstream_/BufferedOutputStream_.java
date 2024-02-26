package edu.lhj.file_.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class BufferedOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void bufferedOutputStream01() {
        String pathname = "d:\\javacode\\FileIO\\b2.txt";
        String str = "lhj is studying";
        BufferedOutputStream bos = null;

        try {
            bos = new BufferedOutputStream(new FileOutputStream(pathname));
            bos.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
