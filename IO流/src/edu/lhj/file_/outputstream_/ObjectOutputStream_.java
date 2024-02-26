package edu.lhj.file_.outputstream_;

import java.io.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * ObjectOutputStream是用来保存值+类型的
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filePath = "d:\\javacode\\FileIO\\date.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到 d:\javacode\FileIO\date.dat
        oos.writeInt(100);// int -> Integer (实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("韩顺平教育");//String
        //保存一个dog对象
        oos.writeObject(new Dog("旺财", 10));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}

