package edu.lhj.file_.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "d:\\javacode\\FileIO\\mytemp";
        File file = new File(directoryPath);
        BufferedWriter bw = null;
        if (!file.exists()) {
            file.mkdir();
            System.out.println("创建目录成功");
        }else {
            System.out.println("该目录已存在,创建失败");
        }

        String filePath = directoryPath + "\\hello.txt";
        file = new File(filePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                bw = new BufferedWriter(new FileWriter(filePath));
                bw.write("hello,world");
                System.out.println("文件创建成功");
            }else {
                System.out.println("文件创建失败");
            }
        }else {
            System.out.println("文件已存在,请勿重复创建");
        }

        //关闭流
        if (bw != null) {
            bw.close();
        }
    }
}
