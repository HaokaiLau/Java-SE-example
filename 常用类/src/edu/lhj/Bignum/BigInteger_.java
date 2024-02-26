package edu.lhj.Bignum;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {
        //用BigInteger来存放很大很大的整数
        BigInteger bigInteger = new BigInteger("321565498799999999999999999999999");
        BigInteger bigInteger1 = new BigInteger("1");
        System.out.println(bigInteger);
        //1.在对BigInteger进行运算时,不能直接进行加减乘除,要使用BigInteger中提供的对应方法
        System.out.println(bigInteger.add(bigInteger1));//加法
        System.out.println(bigInteger.subtract(bigInteger1));//减法
    }
}
