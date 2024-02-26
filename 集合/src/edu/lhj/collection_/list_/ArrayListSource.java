package edu.lhj.collection_.list_;

import java.util.ArrayList;

public class ArrayListSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1.通过无参构造器新建一个集合arraylist,初始大小arrayList.size()是为0的
        ArrayList arrayList = new ArrayList();
        //通过有参构造器新建一个集合arraylist1,初始大小arrayList1.size()是为8
        //此后每一次扩容都是在8的1.5倍
        ArrayList arrayList1 = new ArrayList(8);
        System.out.println(arrayList.size());//0
        //使用for循环给arrayList集合添加1-10的数字
        for (int i = 1; i <= 10; i++) {
            //2.当第一次使用arrayList并且调用add方法时:
            /**
             * public boolean add(E e) {
             *         modCount++;//记录调用的次数
             *         add(e, elementData, size);
             *         return true;
             *         }
             *         ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
             *         private void add(E e, Object[] elementData, int s) {//s是记录当前存入数据的长度,初始为0
             *         if (s == elementData.length)//判断s的长度是否等于arrayList.size()(即arrayList底层中elementData数组的长度)
             *             elementData = grow();//当数据的长度已经等于elementData.length,不足以支持下一次存入时候才会调用grow方法
             *             grow方法在调用Arrays.copyOf,Arrays.copyOf,Arrays.copyOf(elementData,newCapacity(minCapacity));
             *             再调用newCapacity(minCapacity),返回一个扩容后的长度
             *         elementData[s] = e;
             *         size = s + 1;
             *     }
             *         ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
             *         private Object[] grow() {
             *         return grow(size + 1);//这里提前把size + 1
             *     }
             *     private Object[] grow(int minCapacity) {
             *         return elementData = Arrays.copyOf(elementData,
             *                                            newCapacity(minCapacity));
             *     }
             *         ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
             *       此处才是扩容的重点！！！
             *         private int newCapacity(int minCapacity) {
             *         // overflow-conscious code
             *         int oldCapacity = elementData.length;//elementData.length = 0 //第二次进来elementData.length就是10
             *         int newCapacity = oldCapacity + (oldCapacity >> 1);//(oldCapacity >> 1)相当于oldCapacity / 2 //第二次newCapacity计算之后就是15
             *         if (newCapacity - minCapacity <= 0) {
             *             if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)//判断elementData是否是系统默认给的空数组
             *                 return Math.max(DEFAULT_CAPACITY, minCapacity);//如果是,就给数组开10个空间的大小 //DEFAULT_CAPACITY = 10
             *             if (minCapacity < 0) // overflow
             *                 throw new OutOfMemoryError();
             *             return minCapacity;
             *         }
             *         return (newCapacity - MAX_ARRAY_SIZE <= 0)//判断新的长度是否在系统能给出的最大范围之内
             *             ? newCapacity//长度在范围内,返回新的长度
             *             : hugeCapacity(minCapacity);
             *     }
             */
            arrayList.add(i);
        }//for循环执行完毕从1-10,共有9个空间,所以底层中elementData的长度应该为10
        //使用for循环给arrayList集合添加11-15的数字
        for (int i = 11; i <= 15; i++) {
            arrayList.add(i);//第二次执行add就会进行第二次扩容,所以底层中elementData的长度应该为15
        }//for循环执行完毕从1-15,共有15个空间
        //再手动添加三个数据
        arrayList.add(100);//这里执行add就会进行第三次扩容,所以底层中elementData的长度应该为22
        arrayList.add(200);
        arrayList.add(null);
        /*
        * 总结:
        * 1.ArrayList中维护了一个object类型的数组elementData；
           transient Object[] elementData；//transient 表示瞬间，短暂的，表示该属性不能被序列号；
          2.当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0，
          * 第一次添加，则扩容elementData为10，如果需要再次扩容，则扩容elementData为1.5倍；
        * 3.如果使用的是指定大小的构造器，则初始elementData容量为指定大小，如果需要扩容，则直接扩容elementData为1.5倍。
*/
    }
}
