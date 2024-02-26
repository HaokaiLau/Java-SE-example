package edu.lhj.map_;

import java.util.Properties;

@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {
        //解读
        //1. Properties 继承  Hashtable
        //2. 可以通过 k-v 存放数据，当然key 和 value 不能为 null
        //增加
        Properties properties = new Properties();
        //properties.put(null, "abc");//抛出 空指针异常
        //properties.put("abc", null); //抛出 空指针异常
        properties.put("john", "黎明");//k-v
        properties.put("lucy", 100);
        properties.put("lic", 100);
        properties.put("lic", 88);//如果有相同的key,就会替换value的值

        System.out.println("properties=" + properties);

        //通过key来获取value
        System.out.println(properties.get("lic"));//88

        //删除
        properties.remove("lic");//删除key为"lic"的键值对
        System.out.println("properties=" + properties);

        //改
        properties.put("john", "约翰");
        System.out.println("properties=" + properties);
    }
}
