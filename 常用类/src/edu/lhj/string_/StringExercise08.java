package edu.lhj.string_;

public class StringExercise08 {
    public static void main(String[] args) {
        String c = "hello";//1.在常量池中创建了一个"hello"对象 1个
        String d = "abc";//2.在常量池中创建了一个"abc"对象 2个
        //3.在堆中通过 StringBuilder sb = new StringBuilder()新建了一个sb对象 3个
        //注意:StringBuilder方法是创建了一个16个字符长度的char[]
        String e = c + d;
        //4.执行sb.append("hello")
        //注意:append("hello")是把"hello"存入到char[]中
        //5.执行sb.append("abc")
        //注意:append("abc")是把"abc"从char[]中"hello"拼接到char[]中
        //6.最后String e = sb.toString() toString方法return了一个新的匿名对象 4个
        //最后e指向了堆中的sb,然后sb中的value指向了常量池中的"helloabc"
        System.out.println(e == "helloabc");//false
        System.out.println(e.intern() == "helloabc");//true
        String f = "helloabc";
        String g = "hello" + "abc";//直接常量相加看常量池
        System.out.println(f == g);//true
        System.out.println(e == f);//false e = c + d 是堆中e对象中的value指向"helloabc",所以false
    }
}
