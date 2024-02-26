package edu.lhj.collection_.exercise_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        System.out.println("list=" + list);
        //在2号位插入一个元素"韩顺平教育"
        list.add(1,"韩顺平教育");
        System.out.println("list=" + list);
        //获取第5个元素
        System.out.println(list.get(4));
        //获取第6个元素
        System.out.println(list.remove(5));
        //修改第7个元素
        System.out.println(list.set(6,"lhj"));
        //使用迭代器遍历集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.print(" element=" + next);
        }
        iterator = list.iterator();
    }
}
