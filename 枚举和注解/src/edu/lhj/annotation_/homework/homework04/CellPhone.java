package edu.lhj.annotation_.homework.homework04;

public class CellPhone {
    public void testWork(Computer computer,double n1,double n2) {
        double result = computer.work(n1,n2);
        System.out.println("计算的结果为: " + result);
        System.out.println(computer.getClass());
//        Computer sum = new Computer() {
//            @Override
//            public double work(double n1, double n2) {
//                System.out.println("====加法测试====");
//                return n1 + n2;
//            }
//        };
//        Computer sub = new Computer() {
//            @Override
//            public double work(double n1, double n2) {
//                System.out.println("====减法测试====");
//                return n1 - n2;
//            }
//        };
//        Computer mul = new Computer() {
//            @Override
//            public double work(double n1, double n2) {
//                System.out.println("====乘法测试====");
//                return n1 * n2;
//            }
//        };
//        Computer division = new Computer() {
//            @Override
//            public double work(double n1, double n2) {
//                System.out.println("====除法测试====");
//                return n1 / n2;
//            }
//        };
    }
}
