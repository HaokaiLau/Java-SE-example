package edu.lhj.collection_.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1.List集合类中的元素有序,(即添加顺序和取出顺序一致)、且可重复
        List list = new ArrayList();
        list.add("Tim");
        list.add("Jackal");
        list.add("Jackal");//添加的元素可以重复
        list.add("Nice");
        //先入先出
        System.out.println("list=" + list);

        //2.List集合类中的每个元素都有其对应的索引,即支持通过指定索引取出
        System.out.println(list.get(0));
        System.out.println(list.get(3));
    }
}
