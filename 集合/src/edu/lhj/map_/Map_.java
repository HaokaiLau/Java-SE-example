package edu.lhj.map_;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        /*
        1.Map接口实现类的特点。用于保存具有映射关系的数据:Key-Value(双列元素)
        与Collection接口实现类的区别,Collection用于保存单列元素(Value的值是固定的)
        2.Map中的 key 和 value可以是任意类型的元素，会封装到HashMap$Node对象中
        3.Map中的key不允许重复,原因和前面Collcetion接口的实现类HashSet一样(hash值和内容都不能相同)
        但是和HashSet不同的是,Map是把新元素替换旧元素,而HashSet是无法添加
        4.Map中的value可以重复
        5.Map的key可以为null,value也可以为空,但是key为null只能有一个,value为null可以有多个
        6.常用String类作为Map的key(但key是一个Object类型)
        7.key和value之间存在单向一对一的关系,即通过指定的key总能找到一个对应的value
         */

        Map map = new HashMap();
        map.put("No.1", "Tim");
        map.put("No.2", "Nice");
        map.put("No.1", "Jackal");//当有相同的key时,就等价于替换(底层只对key进行判断)
        map.put("No.3", "Tim");
        map.put(null, null);
        map.put(null, "abc");//替换前面key为null的位置上的元素
        map.put("No.4", null);
        map.put("No.5", null);
        map.put("No.6", null);

        System.out.println("map=" + map);

        System.out.println(map.get("No.1"));//通过key找出对应的value
    }
}
