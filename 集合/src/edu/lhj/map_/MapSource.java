package edu.lhj.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"Tim");
        map.put(2,"Howie");

        //解读
        //1. k-v 最后是 HashMap$Node,node = newNode(hash, key, value, null)
        //2. k-v 为了方便程序员的遍历，还会创建 EntrySet 集合 ，该集合存放的元素的类型 Entry(Entry是Map中的一个静态内部类),
        // 而一个Entry对象就有k,v (EntrySet<Entry<K,V>>) 即： transient Set<Map.Entry<K,V>> entrySet;
        //3. entrySet(EntrySet的本质是一个Set集合)中，定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node
        //   这是因为 static class Node<K,V> implements Map.Entry<K,V>，接口多态
        //4. 当把 HashMap$Node 对象 存放到 entrySet 就方便我们的遍历, 因为 Map.Entry 提供了重要方法
        //   K getKey(); V getValue();
        //总结:HashMap实现类的元素还是以Node类型存在在table上,只不过为了方便遍历或者取出里面的k-v,
        //把Node实现了Map.Entry静态内部类,然后还有一个EntrySet集合(本质是Set集合)存放Map.Entry类型的元素,
        //Map.Entry类中有两个方法 getKey() 和 getValue() 用来获取Key和Value
        //这样做最主要的作用还是为了方便程序员遍历或者取出里面的k-v的值

        Set set = map.entrySet();
        System.out.println(set.getClass());//HashMap$EntrySet
        Set keySet = map.keySet();
        System.out.println(keySet.getClass());//HashMap$KeySet
        Collection values = map.values();
        System.out.println(values.getClass());//HashMap$Values
        for (Object obj : set) {
            //System.out.println(obj.getClass()); //HashMap$Node
            //为了能取从 HashMap$Node 中取出k-v
            //要对Object类型的obj向下转型为 Map.Entry类型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println("Key=" + entry.getKey() +
                    " " + "Value=" + entry.getValue());
        }

    }
}
