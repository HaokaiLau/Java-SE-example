package edu.lhj.singleton_;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        System.out.println(instance);
    }
}

//懒汉式(单例设计模式的一种)
//1.把构造器私有化(防止在类的外部直接创建对象)
//2.直接在类中创建静态对象,但不进行初始化(该对象是static)
//3.暴露一个public权限的instance静态方法,添加判断,若对象为空则对对象进行初始化,然后返回对象
//与饿汉式的区别:在调用instance方法时不会立即对对象进行初始化,直到用户调用
// instance方法时才对对象进行初始化,减少了资源的浪费
class Cat {
    private String name;
    //定义一个静态属性
    private static Cat cat = null;

    //构造器私有化
    private Cat(String name) {
        this.name = name;
    }

    //public权限的instance静态方法
    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("小白");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}