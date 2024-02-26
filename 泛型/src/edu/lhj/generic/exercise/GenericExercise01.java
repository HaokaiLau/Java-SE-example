package edu.lhj.generic.exercise;

import java.util.*;

@SuppressWarnings({"all"})
public class GenericExercise01 {
    public static void main(String[] args) {
        Student tim = new Student("Tim", 22);
        Student jackal = new Student("Jackal", 23);
        Student nice = new Student("Nice", 24);
        //HashMap
        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put(tim.name, tim);
        hashMap.put(jackal.name, jackal);
        hashMap.put(nice.name, nice);

        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        //1.使用迭代器遍历hashMap
        System.out.println("=====使用迭代器遍历HashMap=====");
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> student =  iterator.next();
            System.out.println(student.getKey() + "-" + student.getValue());
        }
        //2.使用增强for遍历hashMap
        System.out.println("=====使用增强for遍历HashMap=====");
        for (Map.Entry student : entries) {
            System.out.println(student.getKey() + "-" + student.getValue());
        }

        //HashSet
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(tim);
        hashSet.add(jackal);
        hashSet.add(nice);
        //hashSet.add(tim.name);在定义了泛型后该语句会报错
        //1.使用迭代器遍历HashSet
        System.out.println("=====使用迭代器遍历HashSet=====");
        Iterator<Student> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()) {
            Student student =  iterator1.next();
            System.out.println(student.name + "=" + student);
        }
        //2.使用增强for遍历HashSet
        System.out.println("=====使用增强for遍历HashSet=====");
        for (Student student : hashSet) {
            System.out.println(student.name + "=" + student);
        }

    }
}

class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}