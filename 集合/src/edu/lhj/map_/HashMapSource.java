package edu.lhj.map_;

import java.util.HashMap;

@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("java", 10);//添加成功
        hashMap.put("php", 30);//添加成功
        hashMap.put("java", 20);//替换key为"java"的value值为20

        System.out.println("hashMap=" + hashMap);

        /*解读HashMap底层源码
        1.执行构造器 new HashMap()
        初始化加载因子 this.loadFactor = DEFAULT_LOAD_FACTOR(默认值为0.75)
        HashMap$Node[] table = null;//新建一个空的名为table的HashMap$Node类型的数组
        2.执行put,先执行hash(key)获取key的hash值,然后再执行putVal
        计算hash的算法 (h = key.hashCode()) ^ (h >>> 16)
            public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
        3.执行putVal
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                           boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;//辅助变量
                //1.先判断table是否为null,如果是,就先进行一次扩容(执行resize方法)
                经过第一次扩容后的table的size为16,临界值是12
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                //2.判断该key的hash值对应table索引的位置是否为null
                为null,就创建一个Node结点,把key-value存进去
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k;//辅助变量
                    //3.不为null(表示该索引位置已经有一个Node结点),判断新加入的元素的key
                    和该位置上的key的hash值是否相同且是否为同一个对象或者equals之后是否返回true
                    是的话就认为该位置不能加入新的k-v
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    else if (p instanceof TreeNode)//判断是否为一颗红黑树
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                    4.如果前面两个分支都false,则认为这个结点上有一条链表,
                    循环遍历这个链表
                        for (int binCount = 0; ; ++binCount) {//死循环
                            if ((e = p.next) == null) {//如果整个链表，没有和他相同,就加到该链表的最后
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);//如果该链表上的元素达到了8个,就树化
                                break;
                            }
                            //(1)如果有一个元素和他完全相同,就break
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    //(2)key相同就替换value的值
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold)//如果size大于临界值(初始扩容之后为12),则再次扩容
                    resize();
                afterNodeInsertion(evict);
                return null;
            }

            //树化
            final void treeifyBin(Node<K,V>[] tab, int hash) {
                int n, index; Node<K,V> e;
                //当链表上的元素到达8个就进到这里
                //如果table为空 或 table的size小于 MIN_TREEIFY_CAPACITY(默认值是64),就会执行扩容
                if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                    resize();
                //否则就会继续把新的元素加到该结点上的链表的末尾
                else if ((e = tab[index = (n - 1) & hash]) != null) {
                    TreeNode<K,V> hd = null, tl = null;
                    do {
                        TreeNode<K,V> p = replacementTreeNode(e, null);
                        if (tl == null)
                            hd = p;
                        else {
                            p.prev = tl;
                            tl.next = p;
                        }
                        tl = p;
                    } while ((e = e.next) != null);
                    if ((tab[index] = hd) != null)
                        hd.treeify(tab);
                }
    }
         */
    }
}
