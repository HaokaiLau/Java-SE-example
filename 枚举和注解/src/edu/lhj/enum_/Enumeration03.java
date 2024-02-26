package edu.lhj.enum_;

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season03.SPRING);
        System.out.println(Season03.AUTUMN);
    }
}

//使用enum关键字来实现枚举类
//1.当使用enum关键字来创建一个类时,该类会默认继承一个Enum类,而且创建的这个类默认就已经是final类了
//2.传统的 public static final season03 SPRING = new season03("春天", "温暖"); 简化成
//SPRING("春天", "温暖"); 具体使用哪个构造器看实参列表,如果使用的是无参构造器,则实参列表和小括号
//都可以省略
//
enum Season03 {

//    public static final season03 SPRING = new season03("春天", "温暖");
//    public static final season03 SUMMER = new season03("夏天", "炎热");
//    public static final season03 AUTUMN = new season03("秋天", "凉爽");
//    public static final season03 WINTER = new season03("冬天", "寒冷");

    //1.使用 enum 关键字来替代 class
    //2.SPRING("春天", "温暖"); 解读 对象名(实参列表)并且要放在成员定义之前
    //3.如果有多个对象,对象之间用逗号间隔
    //4.如果用enum关键字来实现枚举类,要求把定义的常量对象写在最前面
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");

    private String name;
    private String desc;

    private Season03(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "season03{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}