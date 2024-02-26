package edu.lhj.string_;

public class StrIngExercise10 {
    public static void main(String[] args) {
        Test test = new Test();
        //这里调用change方法,修改的是change方法栈中的str所指向的地址
        //原本是指向value的,str = "java";后直接指向了常量池中的"java"
        //但test对象中str属性的value仍然指向"lhj"
        //而ch就一直指向堆中的ch[],ch[0] = 'h';修改的是ch[0]的值,并没有修改ch[0]的地址
        test.change(test.str, test.ch);
        System.out.print(test.str + " and ");//lhj and
        System.out.println(test.ch);//lhj and have
    }
}

class Test {
    String str = "lhj";
    final char[] ch = {'j','a','v','a'};
    public void change(String str, char[] ch) {
        str = "java";
        ch[0] = 'h';
    }
}