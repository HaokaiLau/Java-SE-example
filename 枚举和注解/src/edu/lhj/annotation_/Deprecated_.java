package edu.lhj.annotation_;

public class Deprecated_ {
    public static void main(String[] args) {
        AA aa = new AA();
    }
}

//1. @Deprecated注解修饰某个元素,说明该元素已经过时
//2.过时仅仅表示不再推荐使用,并不代表不能使用,即仍然可以使用
//3. @Deprecated注解的作用可以做到新旧版本的兼容过度
@Deprecated
class AA {
    public int n1 = 100;
    public void hi() {

    }
}
