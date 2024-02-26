package edu.lhj.collection_.set_;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);//元素重复,添加失败
        set.add(new Customer("刘", 1001));
        set.add(123);
        set.add("lhj");
        System.out.println("set=" + set);

        /*
        1.LinkedHashSet 是 HashSet 的子类；
        2.LinkedHashSet 底层是一个 LinkedHashMap，底层维护了一个数组+双向链表,
        每一个结点有before和after属性，before指向上一结点，after指向下一结点
        3.LinkedHashSet 根据元素 hashCode来决定元素的存储位置，同时使用链表维护元素的次序，
        这使得元素看起来是以插入顺序保存的；
        4.LinkedHashSet 每添加一个新元素，先求hash值，然后通过算法
        的到该元素的索引，确定该元素在table上的位置，然后将该元素添加到双向链表上，
        tail.after = newElement//添加元素演示 其中head指向头结点 tail指向尾结点
        newElement.before = tail
        tail = newElement
        LinkedHashSet 不允许添加重复元素
         */

        //解读
        //1. LinkedHashSet 加入顺序和取出元素/数据的顺序一致(因为底层是数组+双向链表的结构)
        //2. LinkedHashSet 底层维护的是一个LinkedHashMap(是HashMap的子类)
        //3. LinkedHashSet 底层结构 (数组table+双向链表)
        //4. 添加第一次时，直接将 数组table 扩容到 16 ,存放的结点类型是 LinkedHashMap$Entry
        //5. 数组是 HashMap$Node[] 存放的元素/数据是 LinkedHashMap$Entry类型
        /*
                //继承关系是在内部类完成.
                static class Entry<K,V> extends HashMap.Node<K,V> {
                    Entry<K,V> before, after;
                    Entry(int hash, K key, V value, Node<K,V> next) {
                        super(hash, key, value, next);
                    }
                }
         */
    }
}

@SuppressWarnings({"all"})
class Customer {
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }
}