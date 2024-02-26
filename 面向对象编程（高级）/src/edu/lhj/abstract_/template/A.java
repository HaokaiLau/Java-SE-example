package edu.lhj.abstract_.template;

public class A extends Template{

    @Override
    public void job() {
        long sum = 0;
        for (long i = 0; i < 800000; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
