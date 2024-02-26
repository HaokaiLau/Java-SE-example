package edu.lhj.homework.homework03;

import java.util.Locale;

public class Homework03 {
    public static void main(String[] args) {
        String name = "Lau ho Kai";
        Homework03.printName(name);
    }

    /**
     * 编写方法：完成输出格式的字符串
     * 1.对输入的名字按空格进行分割 split(" ")
     * 2.分割后对得到的新数组进行格式化 String.format(String)
     * 3.对输入的字符串进行校验
     */
    public static void printName(String str) {
        if (str == null) {
            System.out.println("输入的内容不能为空");
            return;
        }
        String[] newStr = str.split(" ");
        if (newStr.length != 3) {
            System.out.println("输入名字的格式不正确");
            return;
        }
        String format = String.format("%s,%s .%c",
                newStr[2],newStr[0],newStr[1].toUpperCase(Locale.ROOT).charAt(0));
        System.out.println(format);
    }
}
