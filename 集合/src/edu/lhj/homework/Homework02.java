package edu.lhj.homework;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        Car car = new Car("宝马", 40);
        Car car1 = new Car("宾利", 500);
        ArrayList arrayList = new ArrayList();

        //add 添加
        arrayList.add(car);
        arrayList.add(car1);
        System.out.println("arrayList=" + arrayList);

        //remove 删除指定元素
        //arrayList.remove(1);根据索引删除
        //arrayList.remove(car1);//根据对象名删除
        //System.out.println("arrayList=" + arrayList);

        //contains 查找元素是否存在
        System.out.println(arrayList.contains(car1));//true

        //size 获取元素个数
        System.out.println(arrayList.size());//2

        //isEmpty 判断集合是否为空
        System.out.println(arrayList.isEmpty());//false

        //clear 清空集合
        //arrayList.clear();
        //System.out.println("arrayList=" + arrayList);

        //addAll 添加多个元素
        arrayList.addAll(arrayList);
        System.out.println("arrayList=" + arrayList);

        //containsAll 判断多个元素是否存在
        System.out.println(arrayList.containsAll(arrayList));//true

        //removeAll 删除多个元素
        //arrayList.removeAll(arrayList);
        //System.out.println("arrayList=" + arrayList);

        //使用增强for来遍历arrayList
        for (Object obj : arrayList) {
            System.out.println(obj);
        }

        System.out.println("==================================");

        //使用迭代器来遍历arrayList
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
