package edu.lhj.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        System.out.println(circle.area());
        ;
    }
}

class Circle {
    private final double PI = 3.14;
    private double r;
    //代码块中赋值
//    {
//        PI = 3.14;
//    }
    public Circle(double r) {
        this.r = r;
        //构造器中赋值
        // PI = 3.14;
    }

    public double area() {
        return PI * r * r;
    }
}
