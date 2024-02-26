package edu.lhj.file_.homework;

import java.io.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 把作业2使用的文件格式改一下
 * 在作业3中使用转换流解决中文乱码问题
 */
public class Homework03 {
    public static void main(String[] args) {
        String filePath = "d:\\javacode\\FileIO\\code.txt";
        BufferedReader br = null;
        String readData = "";
        int line = 0;
        try {
            //br = new BufferedReader(new FileReader(filePath));
            //使用转换流,把文件编码格式设置成gbk
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
            while ((readData = br.readLine()) != null) {
                System.out.println(++line + "    " + readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
