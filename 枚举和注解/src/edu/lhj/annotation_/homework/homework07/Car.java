package edu.lhj.annotation_.homework.homework07;

public class Car {
    private double temperature;
    public class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("空调吹冷风");
            }else if (temperature < 0) {
                System.out.println("空调吹暖风");
            }else {
                System.out.println("关闭空调");
            }
        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

}
