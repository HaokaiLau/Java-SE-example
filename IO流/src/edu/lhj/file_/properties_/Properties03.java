package edu.lhj.file_.properties_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 使用Properties类来创建/修改properties文件
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //创建文件
        //如果要修改文件内容,则直接在setProperty方法中修改k-v的值即可
        //1.使用setProperty方法编写k-v的值
        //public Object setProperty(String key,String value)
        properties.setProperty("ip","168.192.1.1");
        properties.setProperty("user","汤姆");//这里如果是中文,则以中文对应的unicode码的形式保存
        properties.setProperty("pwd","88888888");

        //2.使用store方法将k-v存储到文件即可
        // store(java.io.Writer writer,String comments)
        // store(java.io.OutputStream out,String comments)
        //comments 注释
        properties.store(new FileOutputStream("src\\mysql2.properties"),null);
        System.out.println("保存配置文件成功!");
    }
}
