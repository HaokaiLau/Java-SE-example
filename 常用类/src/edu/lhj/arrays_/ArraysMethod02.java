package edu.lhj.arrays_;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        //binarySearch 通过二分搜索法进行查找,要求传入的数组必须已经是排序好的
        //1.如果使用binarySearch二叉查找
        //2.要求该数组是有序的,如果该数组是无序的,则不能是用binarySearch二叉查找
        //3.如果存在就返回该key的下标,如果不存在就返回 -(low + 1);  // key not found.
        //                                          low表示该key应该出现的位置的下标
        int index = Arrays.binarySearch(arr, 1);
        System.out.println(index);

        //copyOf 数组元素的复制
        //1. 从 arr 数组中，拷贝 arr.length个元素到 newArr数组中
        //2. 如果拷贝的长度大于 arr.length 就在新数组的后面 增加 null
        //3. 如果拷贝长度小于 0 就抛出异常NegativeArraySizeException
        //4. 该方法的底层使用的是 System.arraycopy()
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("====arr数组复制到newArr数组后====");
        System.out.println(Arrays.toString(newArr));

        //fill 数组填充
        Integer[] num = {9, 3, 2,};
        //1.用99填充num数组的,即用99替换掉num数组中的所有数
        Arrays.fill(num, 99);
        System.out.println("====num数组填充后====");
        System.out.println(Arrays.toString(num));

        //equals 比较两个数组中的内容是否相同
        System.out.println(Arrays.equals(newArr, arr));//相同返回true
        System.out.println(Arrays.equals(num, arr));//不同返回false

        //asList 将一组值转换成list
        //调用asList方法,会把()中的数据转换成一个List集合
        List<Integer> asList = Arrays.asList(2, 3, 4, 5, 4, 6, 1);
        System.out.println(asList);
        System.out.println(asList.getClass());
    }
}
