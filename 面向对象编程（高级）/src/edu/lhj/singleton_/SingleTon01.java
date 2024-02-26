package edu.lhj.singleton_;

public class SingleTon01 {
    public static void main(String[] args) {
        //通过类中的getInstance方法来获取返回的对象
        Person instance = Person.getInstance();
        System.out.println(instance);
    }
}

 //饿汉式(单例设计模式的一种)
 //1.把构造器私有化(防止在类的外部直接创建对象)
 //2.直接在类中创建静态对象(该对象是static)
 // 3.暴露一个public权限的instance静态方法来返回静态对象
class Person {
    private String name;
    //直接在类中创建对象
    private static Person p = new Person("小明");

    //把构造器私有化
    private Person(String name) {
        this.name = name;
    }

    //暴露一个public的instance静态方法来提供对象
    public static Person getInstance() {
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
