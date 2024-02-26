package edu.lhj.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
//        System.out.println("col=" + col);

        //方法一:利用迭代器遍历集合 快捷模板itit 可以使用Ctrl + J查看所有快捷模板

        //1.先得到对应的迭代器,Collection是Iterable接口的子接口,所以可以直接调用iterator()
        Iterator iterator = col.iterator();
        //2.使用while循环循环遍历
        while (iterator.hasNext()) {//hasNext方法判断是否存在下一个元素
            //next方法每被调用一次,就返回一个元素,同时指针向下移
            Object obj =  iterator.next();//iterator的next()方法返回一个Object对象
            System.out.println("obj=" + obj);
        }
        //3.当迭代器退出while循环后,这时候的iterator迭代器指向该集合最后一个元素
//        iterator.next();//此时再调用next方法,就会抛出无匹配元素异常
        //4.如果想要再次遍历,需要我们手动重置迭代器
        iterator = col.iterator();//重置迭代器
        System.out.println("=====第二次遍历=====");
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println("obj=" + obj);
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
