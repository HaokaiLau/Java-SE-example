package edu.lhj.file_.reader_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String pathname = "d:\\javacode\\FileIO\\code.txt";
        //创建BufferedReader对象,把FileReader对象传入构造器
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathname));
        //readLine() 按行读取,效率高,读取完毕返回null
        String line;//用于接收readLine()返回的内容
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流,这里注意,使用处理流(包装流),只需要关闭外层流即可,因为底层会自动关闭节点流
        //即这里只需要关闭BufferedReader,底层会自动关闭FileReader
        bufferedReader.close();
    }
}
