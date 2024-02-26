package edu.lhj.stringbuffer_;

public class StringBufferMethod01 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");
        //1.增 append方法   append:追加,在末尾添加
        s.append(',');// "hello,"
        s.append("张三丰");//"hello,张三丰
        s.append("赵敏").append(100).append(true).append(10.5);//"hello,张三丰赵敏 100true10.5"
        s.append("你好").append("world").append(100.2);
        System.out.println(s); //"hello,张三丰赵敏 100true10.5

        //2.删
        /*
         * 删除索引为>=start && <end 处的字符
         * 解读: 删除 11~14 的字符 [11, 14)  左闭右开
         */
        s.delete(11,14);
        System.out.println(s); //hello,张三丰赵敏100t10.5你好world100.2
        s.delete(0,10);
        System.out.println(s);//敏100t10.5你好world100.2
        //3.改(replace:替换)
        // 老韩解读，使用 周芷若 替换 索引 9-11 的字符 [9,11)
        s.replace(9,11,"周芷若");
        System.out.println(s);//敏true10.5周芷若world100.2

        //4.查找指定的子串在字符串第一次出现的索引，如果找不到返回-1
        int indexOf = s.indexOf("周芷若");
        System.out.println(indexOf); //9
        //5.插入
        //老韩解读，在索引为 9 的位置插入 "赵敏",原来索引为 9 的内容自动后移
        s.insert(9,"周敏");
        System.out.println(s);//敏true10.5周敏周芷若world100.2
    }
}

