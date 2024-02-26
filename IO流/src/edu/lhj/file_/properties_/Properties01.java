package edu.lhj.file_.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 使用传统方法读取properties文件的内容
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        //传统方法,使用while循环配合split分割方法循环读取文件内容
        //效率低,复用性差
        while ((line = br.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + "的值是" + split[1]);
        }
    }
}
