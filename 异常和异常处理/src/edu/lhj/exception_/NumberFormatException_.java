package edu.lhj.exception_;

public class NumberFormatException_ {
    public static void main(String[] args) {
        //数字格式化异常
        String name = "广东工商职业技术大学";
        //把String类型的name转成一个int类型的num
        int num = Integer.parseInt(name);//抛出数字格式化异常
    }
}
