package edu.lhj.collection_.list_;

public class LinkedList01 {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node tim = new Node("Tim");
        Node jackal = new Node("Jackal");
        Node nice = new Node("Nice");

        //连接三个结点,形成双向链表
        //tim -> jackal -> nice
        tim.next = jackal;
        jackal.next = nice;
        //nice -> jackal -> tim
        nice.pre = jackal;
        jackal.pre = tim;
        //模拟插入一个新的数据
        Node howie = new Node("Howie");
        //tim -> jackal -> howie -> nice
        jackal.next = howie;
        howie.next = nice;
        //nice -> howie -> jackal -> time
        nice.pre = howie;
        howie.pre = jackal;

        Node first = tim;//让first引用指向tim,表示tim是双向链表的头结点
        Node last = nice;//让last引用指向nice,表示nice是双向链表的头结点

        //从头到尾遍历
        System.out.println("=====正序遍历=====");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //反向遍历
        System.out.println("=====倒序遍历=====");
        while (true) {
            if (last == null) {
                break;
            }
            System.out.println(last);
            last = last.pre;
        }
    }
}

//定义一个Node类,Node对象表示双向链表的一个结点
class Node {
    public Object item;//真正存放数据的地方
    public Node next;//指向上一个结点
    public Node pre;//指向下一个结点

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "NodeName= " + item ;
    }
}
