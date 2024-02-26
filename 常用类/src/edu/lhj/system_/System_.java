package edu.lhj.system_;

import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {
        //System.exit()
//        System.out.println("ok1");
//        System.exit(0);//0表示程序退出
//        System.out.println("ok2");

        //数组拷贝
        //System.arraycopy(源数组,从源数组的什么位置开始,新数组,从新数组的什么位置开始,复制的长度)
        int[] src = {1,2,3};
        int[] newArr = new int[3];
        System.arraycopy(src, 0, newArr, 0, src.length);
        System.out.println(Arrays.toString(newArr));

        //currentTimeMillis() 返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());

        //gc() 垃圾回收机制
        System.gc();
    }
}
