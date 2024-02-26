package edu.lhj.enum_;

public class EnumMethod {
    public static void main(String[] args) {
        //使用 Season03 枚举类来演示各种方法
        Season03 spring = Season03.SPRING;
        Season03 winter = Season03.WINTER;
        //name() 输出枚举对象的对象名
        System.out.println(spring.name());
        //ordinal() 输出该枚举对象的定义时候的次序/编号/位号,从0开始
        System.out.println(spring.ordinal());//0
        System.out.println(winter.ordinal());//3
        //values() 把枚举对象作为一个对象类型数组返回
        //该数组含有所有定义的枚举对象
        Season03[] values = Season03.values();
        for (Season03 season : values) {//增强for循环
            //执行流程 依次从数组中取出数据,赋给season,如果取出完毕则退出for循环
            System.out.println(season);
        }
        //valueOf() 将字符串转化成枚举对象,要求字符串必须为已有的常量,否则报异常
        //执行流程
        //1.根据你输入的 "SPRING" 到Season03枚举对象中查找
        //2.如果找到了,就返回对应的对象,如果没找到,就报异常
        Season03 spring1 = Season03.valueOf("SPRING");
        System.out.println("spring1=" + spring1);//season03{name='春天', desc='温暖'}
        System.out.println(spring1 == spring);//true
        //compareTo() 比较两个枚举对象,比较的就是次序/编号/位号,返回两个编号相减的结果
        System.out.println(spring.compareTo(winter));//-3
        //toString() 跟name()的效果差不多,返回枚举对象的对象名
    }
}
