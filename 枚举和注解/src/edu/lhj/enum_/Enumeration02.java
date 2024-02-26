package edu.lhj.enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(season02.SPRING);
        System.out.println(season02.WINTER);
    }
}
//枚举类的演示
class season02 {
    private String name;
    private String desc;

    //1.构造器私有化,目的是防止通过直接new对象来更改属性
    //2.删除所有的setter方法,目的是防止通过setter方法来修改对象的属性
    //3.在season02类中直接创建固定的对象
    //4.优化 加final修饰 进一步确保属性无法被修改
    //注:枚举变量名的命名规范 通常是用大写
    public static final season02 SPRING = new season02("春天", "温暖");
    public static final season02 SUMMER = new season02("夏天", "炎热");
    public static final season02 AUTUMN = new season02("秋天", "凉爽");
    public static final season02 WINTER = new season02("冬天", "寒冷");

    private season02(String name, String desc) {
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
        return "season02{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
