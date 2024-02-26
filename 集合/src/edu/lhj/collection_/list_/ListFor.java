package edu.lhj.collection_.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Tim");
        list.add("Jackal");
        list.add("Nice");
        list.add("Howie");
        System.out.println("list=" + list);

        //1.使用迭代器对集合进行遍历
        Iterator iterator = list.iterator();
        System.out.println("=====迭代器=====");
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }

        //2.使用增强for对集合进行遍历
        System.out.println("=====增强for=====");
        for (Object o : list) {
            System.out.println(o);
        }

        //3.使用for循环对集合进行遍历
        System.out.println("=====for循环=====");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
