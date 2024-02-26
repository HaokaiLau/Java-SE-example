package item.lhj.class_;

import item.lhj.Car;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 演示获取Class类对象的6种方式
 */
public class GetClass_ {
    public static void main(String[] args) throws Exception {

        //1.Class.forName()
        // 前提是知道全类名,且该类在类路径下,可以通过静态方法forName()获取
        // 使用场景:多用于配置文件,读取类全路径,加载类
        String classAllPath = "item.lhj.Car";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2.类名.class
        // 使用场景:多用于参数传递
        Class<Car> cls2 = Car.class;
        System.out.println(cls2);

        //3.对象.getClass
        // 使用场景:前提是有对象实例
        Car car = new Car();
        Class<? extends Car> cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器[4种]来获取到类的Class类对象
        //(1)先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);
        //cls1,cls2,cls3,cls4是同一个类的Class类对象

        //5.8大基本数据类型获取Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Float> floatClass = float.class;
        System.out.println(integerClass);
        System.out.println(characterClass);
        System.out.println(floatClass);

        //6.包装类获取Class类对象
        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        System.out.println(type);
        System.out.println(type1);
    }
}
