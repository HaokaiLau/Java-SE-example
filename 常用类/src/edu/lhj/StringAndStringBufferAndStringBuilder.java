package edu.lhj;

public class StringAndStringBufferAndStringBuilder {
    /*
        String、StringBuffer 和 StringBuilder 的比较:

        1.StringBuffer 和StringBuilder 非常的类似，均代表可变的字符序列，而且方法也一样
        2.String不可变字符序列，效率低但是复用率高。
        3.StringBuffer 可变字符序列、效率较高（增删），线程安全。
        4.StringBuilder 可变字符序列、效率最高、线程不安全

        String使用说明：
        String s = “a”; //创建了一个字符
        s +=“b”; //实际上原来的"a"字符串已经丢弃了，现在有产生
        一个字符串 s+“b”(也就是"ab"),如果多次执行这些改变串内容的操作，会导致
        大量副本字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大影响程序的性能。
        结论=>如果我们对String做大量的修改，不要使用String。
    */

    /*
    三种类型的使用场景选择:

    1.如果字符串存在大量的修改操作，一般使用StringBuffer 和 StringBuilder
    2.如果字符串存在大量的修改操作，并在单线程的情况下，使用StringBuilder
    3.如果字符串存在大量的修改操作，并在多线程的情况下，使用StringBuffer
    4.如果我们字符串很少修改，被多个对象引用，使用String，比如配置信息等
        StringBuffer 和 StringBuilder的方法使用一样。
    */
}
