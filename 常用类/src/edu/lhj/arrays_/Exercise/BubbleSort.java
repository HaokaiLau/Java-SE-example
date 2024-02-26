package edu.lhj.arrays_.Exercise;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort {
    public static void Bubble(Book[] book) {
        Book temp = null;
        for (int i = 0; i < book.length - 1; i++) {
            for (int j = 0; j < book.length - 1 - i; j++) {
                if (book[j].getPrice() < book[j + 1].getPrice()) {
                    temp = book[j + 1];
                    book[j + 1] = book[j];
                    book[j] = temp;
                }
            }
        }
        System.out.println("=====使用冒泡排序后的结果=====");
        System.out.println(Arrays.toString(book));
    }

    public static void CustomSort(Book[] book, Comparator c) {
        Book temp = null;
        for (int i = 0; i < book.length - 1; i++) {
            for (int j = 0; j < book.length - 1 - i; j++) {
                if (c.compare(book[j],book[j + 1]) < 0) {//从大到小排序
                    temp = book[j + 1];
                    book[j + 1] = book[j];
                    book[j] = temp;
                }
            }
        }
        System.out.println("=====使用定制排序后的结果=====");
        System.out.println(Arrays.toString(book));
    }
}
