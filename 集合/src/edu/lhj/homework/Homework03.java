package edu.lhj.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println("m=" + m);

        //将jack的工资改为2600
        m.put("jack", 2600);

        //为所有员工加薪100
        Set keySet = m.keySet();
        for (Object key : keySet) {
            m.put(key, (Integer)(m.get(key)) + 100);
        }

        //遍历m
        Set entrySet = m.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry);
        }

        //遍历所有的value
        Collection collection = m.values();
        for (Object obj : collection) {
            Integer value = (Integer) obj;
            System.out.println("工资:" + value + "元");
        }

    }
}
