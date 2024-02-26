package edu.lhj.file_.homework;

import java.io.*;
import java.util.Properties;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String propertiesPath = "src\\dog.properties";
        File file = new File(propertiesPath);
        if (!file.exists()) {
            properties.setProperty("name","tom");
            properties.setProperty("age","5");
            properties.setProperty("color","yellow");
            properties.store(new FileWriter("src\\dog.properties"),null);
            System.out.println("配置文件创建成功");
        }else {
            System.out.println("文件已存在");
            properties.load(new FileReader(propertiesPath));
            properties.list(System.out);
            System.out.println("文件读取成功");
        }
        //getProperty方法返回String类型
        //get方法返回Object类型
        String name = properties.getProperty("name");//String
        int age = Integer.parseInt(properties.getProperty("age"));//String -> int
        String color = properties.getProperty("color");//String
        Dog dog = new Dog(name,age,color);
        System.out.println(dog);
        System.out.println("Dog对象输出到屏幕成功");

        //把dog对象序列化保存到文件中
        String filePath = "d:\\javacode\\FileIO\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dog);
        oos.close();//关闭流
        System.out.println("Dog对象序列化完成");
        deserialize(filePath);
    }

    public static void deserialize(String filePath) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            System.out.println(ois.readObject());
            System.out.println("文件反序列化成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
