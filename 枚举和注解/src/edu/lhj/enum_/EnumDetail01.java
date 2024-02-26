package edu.lhj.enum_;

public class EnumDetail01 {
    public static void main(String[] args) {
        A.MUSIC.Play();
    }
}

interface IA {
    void Play();
}

//1.使用 enum 关键字创建一个枚举类时,就不能再继承其他类,因为该枚举类会
// 隐式继承 Enum 类,而Java是单继承机制
//2.enum实现的枚举类,它的本质仍然是一个类,所以可以实现接口
enum A implements IA{
    MUSIC;

    @Override
    public void Play() {
        System.out.println("开始播放...");
    }
}
