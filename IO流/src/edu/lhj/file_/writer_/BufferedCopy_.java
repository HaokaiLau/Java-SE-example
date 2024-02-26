package edu.lhj.file_.writer_;

import java.io.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class BufferedCopy_ {
    public static void main(String[] args) {

        //注意
        //1.BufferedReader和BufferedWriter是安装字符操作
        //2.不要用来操作二进制文件,这样可能会导致文件的损坏

        String srcPath = "d:\\javacode\\FileIO\\code.txt";
        String targetPath = "d:\\javacode\\FileIO\\code2.txt";
        String line;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(srcPath));
            bw = new BufferedWriter(new FileWriter(targetPath));
            //读取文件
            while ((line = br.readLine()) != null) {
                //写入文件
                bw.write(line);
                //换行
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                //判断BufferedReader和BufferedWriter
                //不为空就关闭流
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
