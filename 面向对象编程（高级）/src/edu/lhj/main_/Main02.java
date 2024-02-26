package edu.lhj.main_;

public class Main02 {
    //args数组的参数可以通过在类运行时通过命令行直接在类后面添加
    //如:java Main02 Jack Tim Howie Nice
    //在idea中可以在Edit Configuration中的Program arguments中添加参数
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为: " + args[i]);

        }
    }
}
