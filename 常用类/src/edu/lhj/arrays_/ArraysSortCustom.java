package edu.lhj.arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {
        Integer[] arr = {1, -1, 8, 0, 20};
//        bubble(arr);
        customBubble(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //要把Object类型的对象向下转型成Integer类型的对象才能进行比较
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i1 - i2;
            }
        });
        System.out.println("=====排序后的结果是=====");
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    public static void bubble(Integer[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大排序
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    //结合冒泡排序 + 定制排序
    //原理:实现了底层的Comparator接口,重写了Comparator接口中
    //的compare方法(接口类中compare方法的内容是接收两个对象,然后返回int类型),把
    //数组中的前一个数跟和后一个数传入重写后compare方法中进行比较,若
    //大于0则从小到大排序,小于0则从大到小排序
    public static void customBubble(Integer[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大排序
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}
