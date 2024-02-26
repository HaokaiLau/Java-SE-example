package edu.lhj.stringbuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//这里传入null值，需要看源码,底层调用的是AbstractStringBuilder，的 appendNull
        //appendNull方法返回的是一个char[] value = {'n','u','l','l'}
        System.out.println(sb.length());//4

        System.out.println(sb);//null
        //下面的构造器，会抛出 NullpointerException
        StringBuffer sb1 = new StringBuffer(str);//看底层源码 super(str.length() + 16);
        System.out.println(sb1);//NullpointerException
    }
}

