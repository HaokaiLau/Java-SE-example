package edu.lhj.enum_;

public class Enumeration01 {//枚举类 枚:一个一个的 举:举例 解读:一个一个地举例
    public static void main(String[] args) {
        season01 spring = new season01("春天", "温暖");
        season01 summer = new season01("夏天", "炎热");
        season01 autumn = new season01("秋天", "凉爽");
        season01 winter = new season01("冬天", "寒冷");
        //理论上 季节就只有春夏秋冬四个季节
        //但是可以通过new来创建一些理论上不符合春夏秋冬四个季节的对象
        season01 day = new season01("白天", "明亮");
        //亦或是用set方法修改四个季节的属性
        summer.setDesc("寒冷的");
        //这时就引出枚举类来固定季节的四个对象
    }
}

class season01 {
    private String name;
    private String desc;

    public season01(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
