package edu.lhj.collection_;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1.集合主要分为两组,一组是单列集合,一组是双列集合
        //单列集合中往往放的是单个单个的元素,双列集合往往放的是键值对
        //2.Collection 接口有两个重要的子接口,List和Set，他们实现的子类都是单列集合
        //3.Map 接口的实现子类是双列集合,存放的是键值对(K-V)
        //重点:把Collection和Map的体系图记住

        //ArrayList
        ArrayList arrayList = new ArrayList();
        arrayList.add("Tim");
        arrayList.add(123);

        //HashMap
        HashMap hashMap = new HashMap();
        hashMap.put("No.1", "肇庆");
        hashMap.put("No.2", "四会");

    }
}
