package edu.lhj.file_.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String pathname = "d:\\javacode\\FileIO\\ok.txt";
        //创建BufferedWriter对象,把FileWriter对象传入构造器
        //如果不想使用覆盖写入,想使用追加写入的模式,在字节流构造器里添加true
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathname,true));
        //使用write(String str)
        //想要换行需要插入换行符
        bufferedWriter.write("ok,可行的");
        bufferedWriter.newLine();//插入一个和系统相关的换行是最好的
        bufferedWriter.write("ok2,可行的");
        bufferedWriter.newLine();
        bufferedWriter.write("ok3,可行的");
        bufferedWriter.newLine();

        bufferedWriter.close();//只需要关闭外层流即可
    }
}
