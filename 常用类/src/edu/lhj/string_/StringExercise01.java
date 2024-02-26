package edu.lhj.string_;

public class StringExercise01 {
    public static void main(String[] args) {
        String a = "abc";//在常量池中新建了一个"abc"的空间,a直接指向该空间
        String b = "abc";//b直接在常量池中找"abc"的空间,找到了a新建的那个,然后直接指向该空间
        //所以这两个对象指向的是同一个空间
        System.out.println(a.equals(b));//true 比较两个字符串是否相同
        System.out.println(a == b);//true 判断是否是同一个对象
    }
}
