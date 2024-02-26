package edu.lhj.exception_;

public class ArrayIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        //数组下标越界异常
        int[] arr = {1,2,3};
        try {
            for (int i = 0; i <= arr.length; i++) {
                //下标最大为2,当下标等于数组长度时抛出数组下标越界异常
                System.out.println(arr[i]);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
