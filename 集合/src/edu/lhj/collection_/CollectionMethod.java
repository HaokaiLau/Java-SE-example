package edu.lhj.collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //用一个接口来接收
        List list = new ArrayList();
        //add:添加单个元素
        list.add("Tim");
        list.add(10);//把int自动装箱成Integer
        list.add(true);
        System.out.println("list=" + list);

        //remove:删除指定元素
//        list.remove(0);//删除指定下标的元素
        list.remove(true);//通过指定内容删除指定元素
        System.out.println("list=" + list);

        //contains:查找元素是否存在
        System.out.println(list.contains("Tim"));//返回一个布尔值,存在返回true,不存在返回false

        //size:获取元素个数
        System.out.println(list.size());

        //isEmpty:判断集合是否为空
        System.out.println(list.isEmpty());

        //clear:清空集合
        list.clear();
        System.out.println("list=" + list);

        //addAll:添加多个元素
        List list1 = new ArrayList();
        list1.add("西游记");
        list1.add("三国演义");
        list1.add("红楼梦");
        list1.add("水浒传");
        list.addAll(list1);
        System.out.println("list=" + list);

        //containsAll:查找多个元素是否都存在
        System.out.println(list.containsAll(list1));//true

        //removeAll:删除多个元素
        list.add("相对论");
        list.removeAll(list1);
        System.out.println("list=" + list);
    }
}
