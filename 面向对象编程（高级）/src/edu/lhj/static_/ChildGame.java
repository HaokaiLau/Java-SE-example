package edu.lhj.static_;

public class ChildGame {

    public static void main(String[] args) {

//        int count = 0;

        Child jack = new Child("Jack");
        jack.join();
//        count++;
        jack.count++;
        Child tim = new Child("Tim");
        tim.join();
//        count++;
        tim.count++;
        Child howie = new Child("Howie");
        howie.join();
//        count++;
        howie.count++;
        System.out.println("共" + Child.count + "名小孩加入游戏");
        System.out.println("jack.count = " + jack.count);
        System.out.println("tim.count = " + tim.count);
        System.out.println("howie.count = " + howie.count);
    }
}

class Child {
    private String name;
    //定义一个类变量(静态变量)count
    //该变量最大的特点是可以被Child类的所有的对象实例共享
    //1.static类变量是同一个类的所有对象共享的
    //2.static类变量在类加载的时候就已经生成了
    //3.我们通常认为static类变量保存在类实例的尾部
    //类变量(静态属性)和实例变量(普通属性)的区别:
    //类变量是该类所有对象共享的,而实例变量是该类每一个实例对象独享的
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + " 加入了游戏");

    }
}
