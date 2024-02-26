package edu.lhj.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Student jack = new Student("Jack");
        Student.payFee(100);
        jack.showFee();
        Student tim = new Student("Tim");
        Student.payFee(500);
        tim.showFee();
        //直接调用Utility求和方法,无需实例化对象
        Student.Utility(10,10);
    }
}

class Student {
    public String name;
    private static double Fee = 0;

    public Student(String name) {
        this.name = name;
    }
    //静态方法
    public  static void payFee(double fee) {
        Student.Fee += fee;
    }
    //普通方法
    public void showFee() {
        System.out.println("当前上交的总学费为" + Student.Fee);
    }

    //静态方法常用于不用实例化对象就能用的工具类
    //静态方法中只能访问静态属性和静态方法,但普通方法中可以访问静态方法和静态属性
    //区别:
    //普通方法只能通过实例化对象,以对象名.普通方法的形式进行调用
    //静态方法无需实例化对象,可以直接以类名.静态方法的形式调用
    public static void Utility(int n1, int n2) {
        //类方法中不允许是用和对象相关的关键字(this/super)
        System.out.println("n1 + n2 = " + (n1 + n2));
    }
}
