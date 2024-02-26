package edu.lhj.string_;

public class String01 {
    public static void main(String[] args) {
        //1.String 对象用于保存字符串，也就是一组字符序列
        //2. "Tim" 是字符串常量，双引号括起来的字符序列
        //3.字符串的字符使用Unicode字符编码，一个字符（不区分字母汉字）占两个字节
        //4. String 的有很多构造器，构造器重载
        //   常用的有String s1 = new String();
        // String s2 = new String(String original);
        // String s3 = new String(char[] a);
        // String s4 = new String(char[] a,int startIndex,int count)
        // String s5 = new String(byte[] b)
        //5.String 类实现了接口  Serializable【 String 可以串行化：可以在网络传输】
        //               接口  Comparable【String 可以比较大小】
        //6.String 是一个final类 不能被继承
        //7.String 有属性 public final char value[];用于存放字符串内容
        //所以其本质仍然是一个char数组
        //8.一定要注意：value是final类型 ，就不能更改（）：即value不能指向新的地址，
        // 但是单个字符内容是可以变化
        String str = "Tim";
        final char[] value = {'T', 'i', 'm'};
        value[0] = 'A';
        char[] chars = {'B', 'C', 'D'};//可以修改地址对应的值
//        value = chars; 会报错，不可以修改value的地址

        //创建方法一
        //直接从常量池中寻找有没有"lhj"的字符串常量,有就直接指向该常量池空间,没有就新建
        String name = "lhj";
        //创建方法二
        //调用构造器,在堆中新建一个空间,空间里维护了一个value字符数组,指向了常量池
        //中的"lhj"的空间,如果有该空间,则直接通过value指向,没有则新建
        String lhj = new String("lhj");
    }
}
