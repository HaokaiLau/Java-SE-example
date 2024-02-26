package edu.lhj.stringbuilder_;

public class StringBuilderVsStringBufferVsString {
    public static void main(String[] args) {
        long startTime = 0L;
        long endTime = 0L;

        //StringBuilder
        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//StringBuilder 拼接 20000 次 第 566页
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 的执行时间：" + (endTime - startTime));

        //StringBuffer
        StringBuffer buffer = new StringBuffer("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//StringBuffer 拼接 20000 次
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 的执行时间：" + (endTime - startTime));

        //String
        String text = "";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//String 拼接 20000
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 的执行时间：" + (endTime - startTime));
    }
}
