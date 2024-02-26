package edu.lhj.abstract_.template;

public abstract class Template {
//抽象模板模式
    //把共有但功能不同的方法提取到父类中
    public abstract void job();
    //把特有功能但共用的方法在父类中实现
    public void calculateTime() {
        //得到开始的时间
        long start = System.currentTimeMillis();
        job();//动态绑定,看编译类型
        //得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("执行所需时间 " + (end - start) + "ms");
    }
}
