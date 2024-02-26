package edu.lhj.string_;

public class StringExercise03 {
    public static void main(String[] args) {
        String a = "lhj";//这个a指向常量池中的空间
        //这个b先指向堆中的空间,再由堆中的value属性指向常量池中的"lhj"的空间
        String b = new String("lhj");
        System.out.println(a.equals(b));//true
        System.out.println(a == b);//false
        //intern方法,返回该对象指向的常量池中字符串的空间的地址
        //因为a和b.intern()都指向同一个常量池中的空间,所以地址相同
        System.out.println(a == b.intern());//true
        //因为b指向的是堆中的空间,b.intern()指向的是常量池中的空间,所以两个地址不相同
        System.out.println(b == b.intern());//false
    }
}
