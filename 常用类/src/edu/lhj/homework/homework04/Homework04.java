package edu.lhj.homework.homework04;

public class Homework04 {
    public static void main(String[] args) {
        String str = "@@@@@@@@@@@@@@";
        Homework04.countStr(str);
    }

    public static void countStr(String str) {
        if (str == null) {
            System.out.println("输入的字符串不能为空");
            return;
        }
        char[] chars = str.toCharArray();
        int countLower = 0;
        int countUpper = 0;
        int countNum = 0;
        int countOther = 0;
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                countNum++;
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                countLower++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                countUpper++;
            }else {
                countOther++;
            }
        }
        System.out.println("====字符串分析如下====");
        System.out.println("数字个数:" + countNum);
        System.out.println("大写字母个数:" + countUpper);
        System.out.println("小写字母个数:" + countLower);
        System.out.println("其他类型字符个数:" + countOther);
    }
}
