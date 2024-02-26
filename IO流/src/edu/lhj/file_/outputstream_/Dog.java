package edu.lhj.file_.outputstream_;

import java.io.Serializable;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Dog implements Serializable {

    //自定义的类必须要实现Serializable接口或者Externalizable接口才能把对象序列化保存到文件中
    //我们推荐是实现Serializable接口,因为Externalizable接口中含有需要实现的方法
    private String name;
    private int age;
    //序列化的类中建议添加serialVersionUID(序列版本号),提高版本的兼容性
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

