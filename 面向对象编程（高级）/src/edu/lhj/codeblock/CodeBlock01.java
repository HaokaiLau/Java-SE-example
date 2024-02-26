package edu.lhj.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        movie movie1 = new movie("钢铁侠");
        System.out.println("================================");
        movie movie2 = new movie("钢铁侠2", 20, "漫威");
    }
}

class movie{
    private String name;
    private double price;
    private String director;

    //1.下面三个构造器都有相同的语句,这样代码看起来会比较冗余
    //2.我们可以把想同的语句放入到代码块中
    //3.我们不管调用哪个构造器创建对象,都会优先调用代码块中的内容
    //4.代码块的调用优先于构造器
    //总结:类似构造器的一种补充机制,如果多个构造器中有重复的语句,可以提取该语句到代码块中,提高代码的重用性
    {
        System.out.println("电影频幕打开...");
        System.out.println("播放广告...");
        System.out.println("电影正式开始...");
    }

    public movie(String name) {
//        System.out.println("电影频幕打开...");
//        System.out.println("播放广告...");
//        System.out.println("电影正式开始...");
        this.name = name;
    }

    public movie(String name, double price) {
//        System.out.println("电影频幕打开...");
//        System.out.println("播放广告...");
//        System.out.println("电影正式开始...");
        this.name = name;
        this.price = price;
    }

    public movie(String name, double price, String director) {
//        System.out.println("电影频幕打开...");
//        System.out.println("播放广告...");
//        System.out.println("电影正式开始...");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
