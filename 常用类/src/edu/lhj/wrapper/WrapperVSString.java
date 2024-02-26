package edu.lhj.wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer) -> String
        int i = 100;
        Integer integer = i;//Integer.valueOf(i)
        //方法一
        String str1 = integer + "";
        //方法二
        String str2 = integer.toString();
        //方法三
        String str3 = String.valueOf(integer);

        //String -> 包装类(Integer)
        String str4 = "12345";
        Integer integer1 = Integer.parseInt(str4);//parseInt方法返回一个int,然后利用自动装箱
        Integer integer2 = new Integer(str4);//利用到Integer的构造器

    }
}
