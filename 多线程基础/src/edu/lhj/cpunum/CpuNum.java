package edu.lhj.cpunum;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println("CPU的个数为:" + cpuNums);
    }
}
