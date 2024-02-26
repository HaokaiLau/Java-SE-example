package edu.lhj.abstract_.template;

public class B extends Template{

    @Override
    public void job() {
        long sub = 10;
        for (long i = 1; i <= 10; i++) {
            sub *= i;
        }
        System.out.println(sub);
    }
}
