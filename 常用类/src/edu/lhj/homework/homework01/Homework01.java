package edu.lhj.homework.homework01;

public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("====交换前====");
        System.out.println(str);
        try {
            str = Homework01.reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("====交换后====");
        System.out.println(str);
    }

    /**
     * (1) 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
     * (2) 编写方法 public static String reverse(String  str, int start , int end) 搞定
     * 思路分析
     * (1) 先把方法定义确定
     * (2) 把 String 转成 char[] ，因为char[] 的元素是可以交换的
     * (3) 画出分析示意图
     * (4) 代码实现
     */
    public static String reverse(String str, int start, int end) {
        //对输入的参数再做一个校验
        //技巧:
        //列出所有正确的情况然后取反即可,只要是不符合正确的情况都抛出异常
        if (!(str != null && start >= 0 && end < str.length())) {
            throw new RuntimeException("参数异常");
        }

        char[] chars = str.toCharArray();
        char temp = ' ';
        //start对应的下标必须比end对应的下标小,数组中的元素才会交换
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}



