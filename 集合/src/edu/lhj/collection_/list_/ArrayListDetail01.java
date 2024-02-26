package edu.lhj.collection_.list_;

import java.util.ArrayList;

public class ArrayListDetail01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        //1.ArrayList集合中可以放任何值,并且还可以加入多个null,
        arrayList.add(null);
        arrayList.add("Tim");
        arrayList.add(null);
        System.out.println(arrayList);

        //2.ArrayList是由数组来实现数据的存储的

        //3.ArrayList基本等同于Vector,除了ArrayList的线程是不安全(但执行效率高),
        //所以在多线程情况下,不建议使用ArrayList
        //例如add方法,没有synchronized(即同步处理)
        /*
        * public void add(int index, E element) {
        rangeCheckForAdd(index);
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                         elementData, index + 1,
                         s - index);
        elementData[index] = element;
        size = s + 1;
    }
    * */
    }
}
