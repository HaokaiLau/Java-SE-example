package item.lhj;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Car {
    public String brand = "宝马";
    public int price = 500000;
    public String color = "白色";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
