package edu.lhj.wrapper;

public class Integer01 {
    public static void main(String[] args) {
        //int <---> Integer 的装箱和拆箱
        //装箱:把普通数据类型装成包装类型
        //拆箱:把包装类型转换成普通数据类型
        //jdk5之前是手动装箱和手动拆箱
        int n1 = 10;
        //两种手动装箱方式
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        //手动拆箱
        int i = integer.intValue();

        //jdk5以后,就可以自动装箱和自动拆箱
        //自动装箱
        Integer integer2 = n1;//底层仍然是 Integer.valueOf(n1)
        //自动拆箱
        int n2 = integer2;//底层仍然是 integer2.intValue()
    }
}
