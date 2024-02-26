package edu.lhj.collection_.set_;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {

        /* 解读
        1.当我们使用TreeSet提供的无参构造器来创建TreeSet时,存放的数据仍然是无序的
        2.当我们希望存放的数据能按照字符串大小进行排序时,我们就需要用到TreeSet提供的另一个构造器
        3.使用TreeSet提供的另一个构造器,可以传入一个比较器(这里用到了匿名内部类),
        可以自定义比较的条件

         //源码解读
        /*
        1. 构造器把传入的比较器对象，赋给了 TreeSet的底层的 TreeMap的属性this.comparator
         public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
         2. 在 调用 treeSet.add("tom"), 在底层会执行到
             if (cpr != null) {//cpr 就是我们的匿名内部类(对象)
                do {
                    parent = t;
                    //动态绑定到我们的匿名内部类(对象)compare
                    cmp = cpr.compare(key, t.key);
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else //如果相等，即返回0,这个Key就没有加入
                        return t.setValue(value);
                } while (t != null);
            }
         */

//        TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //调用String中的compareTo方法来对两个字符串的大小进行比较
                //return ((String) o2).compareTo((String) o1);
                //定制一个按照字符串长度来进行排序的规则
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        //添加数据
        treeSet.add("lhj");
        treeSet.add("Jackal");
        treeSet.add("Tim");
        treeSet.add("a");

        System.out.println("treeSet=" + treeSet);
    }
}
