package edu.lhj.stringbuffer_;

public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String --> StringBuffer
        String str = "lhj";
        //方法一:使用构造器
        //注意:这里的 stringBuffer是一个StringBuffer对象
        //并没有改变str的类型,只是利用了str字符串的内容
        StringBuffer stringBuffer = new StringBuffer(str);
        //方法二:使用append
        StringBuffer stringBuffer1 = new StringBuffer();
        //注意:这里的 append是一个StringBuffer对象
        //同样没有改变str的类型,只是利用了str字符串的内容
        StringBuffer append = stringBuffer1.append(str);

        //StringBuffer --> String
        //方法一:使用StringBuffer提供的toString方法
        StringBuffer stringBuffer2 = new StringBuffer("lhj");
        String s = stringBuffer2.toString();
        System.out.println(s);
        //方法二:使用String的构造器把StringBuffer对象提供的内容转成String
        String s1 = new String(stringBuffer2);
        System.out.println(s1);
    }

}
