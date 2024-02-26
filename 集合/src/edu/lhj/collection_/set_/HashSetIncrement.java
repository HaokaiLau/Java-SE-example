package edu.lhj.collection_.set_;

import java.util.HashSet;

@SuppressWarnings({"all"})
public class HashSetIncrement {
    public static void main(String[] args) {
         /*
        1.HashSet底层是HashMap, 第一次添加时，table 数组扩容到 16，
        临界值(threshold)是 16*加载因子(loadFactor)是0.75 = 12
        如果table 数组使用到了临界值 12,就会扩容到 16 * 2 = 32,
        新的临界值就是 32*0.75 = 24, 依次类推
         */
        HashSet hashSet = new HashSet();
//        for(int i = 1; i <= 100; i++) {
//            hashSet.add(i);//1,2,3,4,5...100
//        }

        /*
        2.在Java8中, 如果一条链表的元素个数到达 TREEIFY_THRESHOLD(默认是 8 )，
        并且table的大小 >= MIN_TREEIFY_CAPACITY(默认64),就会进行树化(红黑树),
        否则就会继续采用数组扩容机制,然后再把数据添加到链表末端
         */
//        for (int i = 1; i <= 12; i++) {
//            hashSet.add(new A(i));
//        }

        /*
            3.当我们向hashset增加一个元素,-> (封装)Node -> 加入table,
            无论这个元素是落在table上还是落在链表中,
            都算是增加了一个size++(即只要整个table包括链表,只要存入了12个元素,就会执行扩容机制)
         */

    }
}

class B {
    private int n;

    public B(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 200;
    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}
