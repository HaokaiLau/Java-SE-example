package edu.lhj.collection_.exercise_;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class HashSetExercise01 {
    public static void main(String[] args) {

        /*
         定义一个Employee类，该类包含：private成员属性name,age 要求:
         创建3个Employee 对象放入 HashSet中
         当 name和age的值相同时，认为是相同员工, 不能添加到HashSet集合中
         */

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("Tim", 25));
        hashSet.add(new Employee("Nice", 24));
        hashSet.add(new Employee("Tim", 25));
        System.out.println("hashSet = " + hashSet);
        //当前如果不做任何处理,这里新建的三个对象都会加入到hashSet里面去,因为这是三个不同的对象
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //如果name 和 age的值相同,则返回相同的hash值
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
