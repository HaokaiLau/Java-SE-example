package edu.lhj.stringbuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        //1.StringBuffer 的直接父类是 AbstractStringBuffer
        //2.StringBuffer 实现了Serializable ,即StringBuffer对象可以串行化
        //3.在父类中 AbstractStringBuffer 有属性 char[] value,不是final
        //  该value数组存放 字符串类容，应是存放在堆中的。
        //4.StringBuffer是一个final类，不能被继承
        //5.因为StringBuffer 字符串内容是存在 char[] value中
        // 与String不同的是这个char[] value并不是final修饰的，而且
        // 这个value数组的内容是存放在堆中的而不是存放在常量池中，所以可以变化（增加删除）
        //  不用每次都更换地址（即不是每次都创建新对象），只有存放的字符串长度超出
        //  该value数组的长度时才会更换一次地址，所以效率高于String
        StringBuffer stringBuffer = new StringBuffer("lhj");
    }
}
