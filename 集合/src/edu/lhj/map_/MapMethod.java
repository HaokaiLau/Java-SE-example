package edu.lhj.map_;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", new Book(" ", 100));//添加成功
        map.put("邓超", "孙俪");//替换了key为"邓超"的value的值
        map.put("王宝强", "马蓉");//添加成功
        map.put("宋喆", "马蓉");//添加成功
        map.put("刘令博", null);//添加成功
        map.put(null, "刘亦菲");//添加成功
        map.put("鹿晗", "关晓彤");//添加成功
        System.out.println("map=" + map);

        //remove 根据key删除映射关系
        map.remove(null);
        System.out.println("map=" + map);

        //get 根据key获取value的值
        Object o1 = map.get("鹿晗");
        System.out.println(o1);

        //size 获取元素的个数
        System.out.println("map.size()=" + map.size());

        //isEmpty 判断个数是否为0
        Map map2 = new HashMap();
        System.out.println(map.isEmpty());//false
        System.out.println(map2.isEmpty());//true

        //clear 清除k-v
//        map.clear();
//        System.out.println("map=" + map);

        //containsKey 查找key是否存在  containsValue 查找value是否存在
        System.out.println(map.containsKey("lhj"));//false
        System.out.println(map.containsValue("马蓉"));//true
    }
}

@SuppressWarnings({"all"})
class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
