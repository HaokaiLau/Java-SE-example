package edu.lhj.collection_;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
//        System.out.println("col=" + col);

        //方法二:使用增强for来遍历集合 快捷模板 I
        //使用增强for来遍历集合,实质上也是调用了Iterable的迭代器
        //可以理解为增强for就是一个简化版的迭代器
        for (Object obj : col) {
            System.out.println("book=" + obj);
        }
        //增强for也可用于遍历数组
        int[] arr = {1,3,5,7,9,11};
        for (int i : arr) {
            System.out.print(" i=" + i);
        }
    }
}
