package edu.lhj.annotation_.homework.homework04;

public class TestCellPhone {
    //1.计算机接口具有work方法,功能是运算,有一个手机类CellPhone,
    //定义方法testWork测试计算功能,调用计算机接口的work方法
    //2.要求调用计算机的testWork方法,要使用匿名内部类
    public static void main(String[] args) {
        //匿名内部类最经典的使用场景就是作为实参传递
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                System.out.println("====加法测试====");
                return n1 + n2;
            }
        }, 1, 1);
        cellPhone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                System.out.println("====减法测试====");
              return n1 - n2;
            }
        },10,2);
        cellPhone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                System.out.println("====乘法测试====");
                return n1 * n2;
            }
        },10,2);
        cellPhone.testWork(new Computer() {
            @Override
            public double work(double n1, double n2) {
                System.out.println("====除法测试====");
                return n1 / n2;
            }
        },10,2);
    }
}
