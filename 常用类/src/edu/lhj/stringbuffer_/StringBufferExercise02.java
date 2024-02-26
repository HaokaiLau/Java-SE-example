package edu.lhj.stringbuffer_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        /*输入商品名称和商品价格，要求打印效果示例,
        使用前面学习的方法完成：
        商品名 商品价格
         手机 123,564.59
        //比如 价格 3,456,789.88
        要求：价格的小数点前面每三位用逗号隔开, 在输出。 思路分析
        1. 定义一个 Scanner 对象，接收用户输入的 价格(String)
        2. 希望使用到 StringBuffer 的 insert ，需要将 String 转成 StringBuffer
        3. 然后使用相关方法进行字符串的处理 代码实现
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入商品名:");
        String name = scanner.next();
        System.out.print("请输入商品价格:");
        String price = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(price);
        if (price.lastIndexOf(".") != -1) {
            int index = price.lastIndexOf(".");
                for (int i = index-3; i > 0; i -= 3) {
                    stringBuffer.insert(i,",");
                }
        }else {
            for (int i = price.length()-3; i > 0; i -= 3) {
                stringBuffer.insert(i,",");
            }
        }

        System.out.println("商品名:" + name);
        System.out.println("商品价格:" + stringBuffer.toString());
    }
}
