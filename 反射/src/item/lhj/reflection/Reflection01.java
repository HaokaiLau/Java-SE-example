package item.lhj.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Reflection01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));//载入配置文件
        //获取配置文件的信息
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("methodName=" + methodName);

        //1.加载类,返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //2.通过cls来获取你加载的类item.lhj.Cat的对象
        Object o = cls.newInstance();
        System.out.println("o对象的运行类型是:" + o.getClass());//class item.lhj.Cat
        //3.通过cls来获取你加载的类item.lhj.Cat的方法的对象
        // 即在反射中,可以把方法视为一个对象
        Method method = cls.getMethod(methodName);
        //4.通过方法的对象来调用方法
        //传统的调用形式 对象.方法
        //在反射机制中的调用形式 方法的对象.invoke(对象)
        method.invoke(o);

        //getField():获取类中的成员变量
        // 注意,getField()无法获取私有的属性
        Field fieldName = cls.getField("age");
        System.out.println(fieldName.get(o));

        //getConstructor():获取类中的构造方法
        //()中为空则返回无参构造器,否则则根据传入的类型返回对应的构造器
         Constructor constructor = cls.getConstructor();
        System.out.println(constructor);//Cat()
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);//Cat(java.lang.String)
    }
}
