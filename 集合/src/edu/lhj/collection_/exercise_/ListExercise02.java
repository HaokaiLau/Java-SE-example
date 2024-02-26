package edu.lhj.collection_.exercise_;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListExercise02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 20));
        list.add(new Book("三国演义", "罗贯中", 80));
        list.add(new Book("新西游记", "吴承恩", 70));

        ListExercise02.bubbleCustom(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double value = book1.getPrice() - book2.getPrice();
                if (value >= 0) {
                    return 1;
                }else if (value < 0) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

    }
    @SuppressWarnings({"all"})
    public static void bubbleCustom(List list, Comparator c) {
        Object temp = null;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (c.compare(list.get(j), list.get(j+1)) > 0) {
                    temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        for (Object o : list) {
            Book book = (Book) o;
            System.out.println(book);
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
        return "名称:" + name + "\t\t" +
                "价格:" + price + "\t\t" +
                "作者:" + author;
    }
}
