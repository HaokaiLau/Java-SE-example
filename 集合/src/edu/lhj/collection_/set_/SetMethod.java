package edu.lhj.collection_.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        //1.Set接口的实现类的对象(Set接口对象),不能存放重复的元素,且只能添加一个null
        //2.Set接口对象存放数据是无序的(即添加的顺序和取出的顺序不一致)
        //3.取出的顺序虽然与添加的顺序不一致,但是是固定的,不会一会儿一变
        Set set = new HashSet();
        set.add("Tim");
        set.add("Jackal");
        set.add("Tim");//重复元素
        set.add("Howie");
        set.add(null);
        set.add(null);//再次添加null
        System.out.println(set);

        //遍历方式
        //1.使用迭代器遍历
        System.out.println("=====使用迭代器遍历=====");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("next = " + next);
        }

        //2.使用增强for
        System.out.println("=====使用增强for=====");
        for (Object obj : set) {
            System.out.println("obj = " + obj);
        }

        //由于Set接口没有提供get方法,所以无法使用普通for循环对set集合进行遍历
    }
}
