package edu.lhj.collection_.set_;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {
        //1.实际上HashSet的底层是HashMap
        Set hashSet = new HashSet();
        /*
        public HashSet() {
            map = new HashMap<>();
        }
         */

        //2.HashSet可以添加null,但也只能添加一个null
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("hashSet=" + hashSet);

        //3.HashSet不保证元素是有序的,取决于hash后,再确定索引的结果
        //即不保证存放元素的顺序和取出元素的顺序一致
    }
}
