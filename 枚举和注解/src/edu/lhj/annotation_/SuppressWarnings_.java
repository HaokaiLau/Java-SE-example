package edu.lhj.annotation_;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarnings_ {

    //1.当我们不希望看到黄色的警告时,就可以使用@SuppressWarmings注解来抑制警告信息
    //2.在{""}中,你可以写入你希望抑制(不显示)的警告信息,如:
    //all：忽略所有类型的警告。
    //unchecked：忽略未经检查的警告，通常在使用泛型时出现。
    //deprecation：忽略使用已过时的 API 的警告。
    //rawtypes：忽略使用不带泛型类型的原始类型的警告。
    //unused：忽略未使用的代码或变量的警告。
    //restriction：忽略使用了受限制的 API 的警告，通常用于访问非公开或不稳定的 API。等等
    //3. @SuppressWarmings注解作用的范围和你放的位置相关
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i = 1;
        System.out.println(list.get(1));
    }
}

