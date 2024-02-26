package edu.lhj.collection_.set_;

@SuppressWarnings({"all"})
public class HashSetStructure {
    public static void main(String[] args) {
        //以数组的形式演示HashSet中数组+链表的存储形式
        Node[] table = new Node[16];
        Node jhon = new Node("jhon", null);
        table[2] = jhon;//把jhon放到表中索引为2的位置
        Node jack = new Node("jack", null);
        jhon.next = jack;//把jack这个结点挂载到jhon结点后面
        Node lucy = new Node("lucy", null);
        jack.next = lucy;//把lucy这个结点挂载到jack结点后面
        Node rose = new Node("rose", null);
        table[3] = rose;//把rose放到表中索引为3的位置
    }
}
class Node {
    public Object item;
    public Object next;

    public Node(Object item, Object next) {
        this.item = item;
        this.next = next;
    }
}
