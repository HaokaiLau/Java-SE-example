package edu.lhj.stringbuffer_;

public class StringBuffer02 {
    public static void main(String[] args) {
        //构造器的使用
        //1.创建一个大小为16的 char[],用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        //2.通过构造器指定char[]的大小
        StringBuffer stringBuffer1 = new StringBuffer(100);

        //3.通过给一个String创建StringBuffer
        StringBuffer stringBuffer2 = new StringBuffer("lhj");
    }
}
