package edu.lhj.collection_.list_;

import java.util.LinkedList;

@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();//创建一个空的双向链表
        linkedList.add(1);
        /*
        void linkLast(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
        }

        1.把1添加到新Node对象中的item中,此时的first和last都为空
        2.把这个Node对象的prev指向last(此时的last为null),这就形成了这个新Node对象的prev和next都为null
        3.然后把last指向这个新Node对象
        4.进行判断,如果这个新Node对象的prev为null,则把first也指向这个Node对象
        否则就把这个Node对象的prev指向的对象(即上一个对象)的next引用指向这个新对象
         */
        linkedList.add(2);
        /*
        1.把2添加到新Node对象中的item中,此时的first和last都指向上一个Node对象
        2.把这个Node对象的prev指向last(此时的last指向上一个Node对象),此时的新Node对象的prev引用
        指向上一个对象,next引用未null
        3.然后把last指向这个新Node对象
        4.4.进行判断,如果这个新Node对象的prev为null,则把first也指向这个Node对象
        否则就把这个Node对象的prev指向的对象(即上一个对象)的next引用指向这个新对象
         */
        linkedList.add(3);
        linkedList.remove();//remove方法默认删除该双向链表中first指向的元素
        /*
        public E remove() {
            return removeFirst();
        }

        public E removeFirst() {
        final Node<E> f = first;
            if (f == null)
                throw new NoSuchElementException();
            return unlinkFirst(f);
        }

        private E unlinkFirst(Node<E> f) {
            // assert f == first && f != null;
            final E element = f.item;
            final Node<E> next = f.next;
            f.item = null;
            f.next = null; // help GC
            first = next;
            if (next == null)
                last = null;
            else
                next.prev = null;
            size--;
            modCount++;
            return element;
    }
         */

        linkedList.set(1,999);//修改index为1的Node对象中item的值为999

        Object o = linkedList.get(1);//得到index为1的Node对象中item的值
        System.out.println("linkedList.get(1)=" + o);
        System.out.println("linkedList=" + linkedList);

        //因为LinkedList实现了List接口,所以遍历方式可以是:
        //1.使用迭代器遍历
        //2.for循环
        //3.增强for
    }
}
