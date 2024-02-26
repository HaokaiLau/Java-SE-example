package edu.lhj.wrapper;

public class WrapperMethod {
    public static void main(String[] args) {
        //展示Integer和Character包装类中常用的方法
        System.out.println(Integer.MIN_VALUE);//返回最小值
        System.out.println(Integer.MAX_VALUE);//返回最大值

        System.out.println(Character.isDigit('a'));//是不是数字
        System.out.println(Character.isLetter('a'));//是不是字母
        System.out.println(Character.isUpperCase('a'));//是不是大写
        System.out.println(Character.isLowerCase('a'));//是不是小写
        System.out.println(Character.isWhitespace('A'));//是不是空格

        System.out.println(Character.toUpperCase('a'));//转成大写
        System.out.println(Character.toLowerCase('A'));//转成小写
    }
}
