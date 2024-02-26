package edu.lhj.annotation_.homework.homework05;

public class A {
    private String NAME = "Jackal";
    public void f1() {
        class B {
            private final String NAME = "Tim";
            public void show() {
                System.out.println("InnerName= " + NAME);
                System.out.println("OuterName= " + A.this.NAME);
            }
        }
        B b = new B();
        b.show();
    }
}
