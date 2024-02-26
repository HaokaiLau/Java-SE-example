package item.lhj.class_;

import java.lang.reflect.Field;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 演示Class类的常用方法
 */
@SuppressWarnings({"all"})
public class Class02 {
    public static void main(String[] args) throws Exception {

        String classAllPath = "item.lhj.Car";
        //获取Car类对应的Class类对象
        Class<?> cls = Class.forName(classAllPath);
        System.out.println(cls);//输出哪个类的Class类对象 class item.lhj.Car
        System.out.println(cls.getClass());//输出真实的运行类型 class java.lang.Class
        //获取包名
        System.out.println(cls.getPackage().getName());//item.lhj
        //获取全类名
        System.out.println(cls.getName());//item.lhj.Car
        //通过Class类对象创建对象实例
        Object o = cls.newInstance();
        System.out.println(o);
        //通过反射获取属性 注意:无法访问私有属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(o));
        Field price = cls.getField("price");
        System.out.println(price.get(o));
        Field color = cls.getField("color");
        System.out.println(color.get(o));
        //通过反射给属性赋值
        brand.set(o,"奔驰");
        System.out.println(brand.get(o));
        //一个一个获取很麻烦,希望能一次获取所有属性
        Field[] fields = cls.getFields();//属性数组
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].get(o));
        }
    }
}
