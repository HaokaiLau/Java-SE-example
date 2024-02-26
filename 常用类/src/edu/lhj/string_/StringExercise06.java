package edu.lhj.string_;

public class StringExercise06 {
    public static void main(String[] args) {
        String s1 = "lhj";
        s1 = "haha";//这里其实在创建了两个对象
        //一个是"lhj"的对象,一个是"haha"的对象,然后s1从指向"lhj"改为指向了"haha"
    }
}
