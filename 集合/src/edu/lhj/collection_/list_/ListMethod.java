package edu.lhj.collection_.list_;


import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();

        //void add(int index, Object ele):在index位置插入元素
        list.add("Tim");
        list.add("Nice");
        list.add("Jackal");//当不添加索引时,默认把元素添加到最后
        System.out.println("=====插入前的list=====");
        System.out.println(list);
        list.add(1,"lhj");//把lhj插入到索引为1的位置
        System.out.println("=====插入后的list=====");
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("孙悟空");
        list2.add("唐僧");
        list2.add("猪八戒");
        list2.add("沙悟净");
        list.addAll(1,list2);
        System.out.println("list2=" + list2);
        System.out.println("list=" + list);

        // Object get(int index):获取指定index位置的元素
        System.out.println(list2.get(0));//孙悟空

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("lhj"));//5

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        list.add(1,"Tim");
        System.out.println(list.lastIndexOf("Tim"));//1

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println("=====移除前=====");
        System.out.println(list);
        list.remove(1);//移除了第二个Tim
        System.out.println("=====移除后=====");
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换
        list.set(0,"Howie");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        //左闭右开
        System.out.println(list.subList(1,5));//[孙悟空, 唐僧, 猪八戒, 沙悟净]
    }
}
