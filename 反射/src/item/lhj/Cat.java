package item.lhj;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Cat {

    private String name = "Tom";
    public int age = 10;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
        //System.out.println("hi,my name is " + name);
    }

    public void cry() {
        System.out.println(name + "在喵喵喵");
    }
}
