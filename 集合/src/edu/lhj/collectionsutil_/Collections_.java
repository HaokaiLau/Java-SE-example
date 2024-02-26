package edu.lhj.collectionsutil_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {

        //创建ArrayList集合用于测试
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        System.out.println("list=" + list);

        //reverse(list) 反转list中元素的顺序
        Collections.reverse(list);
        System.out.println("list=" + list);

        //shuffle(list) 对list中的元素进行随机排序
        Collections.shuffle(list);
        System.out.println("list=" + list);

        //sort(list) 根据元素的自然顺序对list集合中的元素按升序排序
        Collections.sort(list);
        System.out.println("list=" + list);

        //sort(list,Comparator) 根据Comparator中自定义的规则对list中的元素进行指定规则的排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照字符串长度升序排序
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("list=" + list);

        //swap(list,int i, int j) 把list集合中索引为i的元素与索引为j的元素进行交换
        Collections.swap(list,0, 1);
        System.out.println("list=" + list);

        //Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println(Collections.max(list));//tom

        //Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
        //比如，我们要返回长度最大的元素
        System.out.println(Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));

        //Object min(Collection)
        //Object min(Collection，Comparator)
        //上面的两个方法，参考max即可

        //int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        System.out.println(Collections.frequency(list, "king"));//1

        //void copy(List dest,List src)：将src中的内容复制到dest中
        List dest = new ArrayList();
        //为了完成一个完整拷贝，我们需要先给dest 赋值，大小和list.size()一样
        for(int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        //拷贝
        Collections.copy(dest, list);
        System.out.println("dest=" + dest);

        //boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
        //如果list中，有tom 就替换成 汤姆
        Collections.replaceAll(list, "tom", "汤姆");
        System.out.println("list替换后=" + list);

    }
}
