package edu.lhj.Bignum;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("99999999999999999999.9999999999999999999");
        BigDecimal bigDecimal1 = new BigDecimal("0.000000000000000000000001");
        System.out.println(bigDecimal);
        //使用BigDecimal中提供的相应方法进行计算
        System.out.println(bigDecimal.add(bigDecimal1));//加法
        System.out.println(bigDecimal.subtract(bigDecimal1));//减法
        //使用除法时可能会抛出一个异常,原因是这两个数相除可能出现除不尽的情况
//        System.out.println(bigDecimal.divide(bigDecimal1));
        //解决方法，在参数后加BigDecimal.ROUND_CEILING,会自动保留分子的精度
        System.out.println(bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING));
    }
}
