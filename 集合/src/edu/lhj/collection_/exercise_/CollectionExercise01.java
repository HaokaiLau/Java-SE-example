package edu.lhj.collection_.exercise_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        Dog dog1 = new Dog("小白", 3);
        Dog dog2 = new Dog("小黄", 4);
        Dog dog3 = new Dog("大黄", 5);
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);

        //使用迭代器来遍历list集合
        Iterator iterator = list.iterator();
        System.out.println("=====使用迭代器=====");
        while (iterator.hasNext()) {
            Object o1 =  iterator.next();
            System.out.println("dog=" + o1);
        }
        iterator = list.iterator();

        //使用增强for来遍历list集合
        System.out.println("=====使用增强for=====");
        for (Object o2 : list) {
            System.out.println("dog=" + o2);
        }

    }
}
