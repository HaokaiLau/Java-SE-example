package edu.lhj.generic;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args) {

        /* 解读
        1.ArrayList<Dog> 表示存放到集合中的元素类型只能是Dog及其子类
        2.如果编译器发现添加的元素的类型不满足要求,就会报错
        3.在遍历的时候就可以直接取出Dog类型而不是Object类型
        4.public class ArrayList<E> 中的E表示泛型
         */

        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("小白", 5));
        arrayList.add(new Dog("小黄", 5));
        arrayList.add(new Dog("小黑", 6));
        //假如不小心添加了一个猫类对象
        //arrayList.add(new Cat("三花", 6));

        //遍历
        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

        Person<String> person1 = new Person<>("lhj");
        person1.show();//显示person1的运行类型
         /*
            你可以这样理解，上面的Person类
            class Person {
                String s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
                public Person(String s) {//E也可以是参数类型
                    this.s = s;
                }
                public String f() {//返回类型使用E
                    return s;
                }
            }
         */
        Person<Integer> person2 = new Person<>(100);
        person2.show();//显示person2的运行类型
        /*
            class Person {
                Integer s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
                public Person(Integer s) {//E也可以是参数类型
                    this.s = s;
                }
                public Integer f() {//返回类型使用E
                    return s;
                }
            }
         */
    }
}


class Person<E> {
    E s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

    public Person(E s) {//E也可以是参数类型
        this.s = s;
    }

    public E f() {//返回类型使用E
        return s;
    }

    public void show() {
        System.out.println(s.getClass());//显示s的运行类型
    }
}

class Dog {
    private String name;
    private int age;

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
        return "Dog [name=" + name +
                ", age=" + age +
                ']';
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
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
        return "Dog [name=" + name +
                ", age=" + age +
                ']';
    }
}
