package edu.lhj.map_;

import java.util.*;

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //第一种遍历方式:先通过keySet集合取出所有的key,再通过key取出对应的value
        Set keySet = map.keySet();
        //1.通过增强for循环取出
        System.out.println("==通过增强for循环取出,再通过key取出对应的value==");
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        //2.通过迭代器遍历存放key的Set集合,在通过key取出对应的value
        System.out.println("==通过迭代器遍历存放key的Set集合,再通过key取出对应的value==");
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key =  iterator1.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二种遍历方式:通过Collection集合取出所有的value
        Collection collection = map.values();
        //1.通过增强for循环取出
        System.out.println("==通过增强for取出value==");
        for (Object value : collection) {
            System.out.println(value);
        }
        //2.通过迭代器循环取出
        System.out.println("==通过迭代器取出value==");
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);
        }

        //第三种遍历方式:通过EntrySet集合,直接遍历取出key和value(或者利用Entry类提供的两个get方法)
        Set entrySet = map.entrySet();
        //1.增强for
        System.out.println("==通过增强for取出entry(包含key和value)==");
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry);
//            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        //2.迭代器
        System.out.println("==通过迭代器取出entry(包含key和value)==");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object next =  iterator3.next();
            Map.Entry entry = (Map.Entry) next;
//            System.out.println(entry);
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
