package edu.lhj.enum_;

public class EnumExercise01 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        System.out.println("==所有星期的信息如下==");
        for (Week week : weeks) {
            System.out.println(week);
        }
    }
}

enum Week {

    //新建枚举对象
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),
    FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");

    private String day;

    private Week(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day;
    }
}
