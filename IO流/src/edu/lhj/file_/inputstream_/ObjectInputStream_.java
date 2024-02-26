package edu.lhj.file_.inputstream_;

import edu.lhj.file_.outputstream_.Dog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        //指定反序列化文件的路径
        String filePath = "d:\\javacode\\FileIO\\date.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取
        //解读
        //1. 读取(反序列化)的顺序需要和你保存数据(序列化)的顺序一致
        //2. 否则会出现异常
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object o = ois.readObject();
        System.out.println("运行类型=" + o.getClass());
        System.out.println("对象信息:" + o);

        //1.如果我们想要调用Dog类中的方法,需要向下转型
        //2.注意,需要我们将Dog类的定义放到本类可以引用的位置
        Dog dog = (Dog) o;
        System.out.println(dog.getName() + dog.getAge());

        ois.close();//关闭流
        System.out.println("数据反序列化完成");

    }
}
