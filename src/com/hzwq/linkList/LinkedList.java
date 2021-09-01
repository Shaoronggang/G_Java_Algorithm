package com.hzwq.linkList;

/**
 * @Author: shaoRongGang
 * @Description: 链表
 * @Date:Created in 21:15 2020/4/16
 * @Modifid By:
 * @Version：
 */
public class LinkedList<E> {

    /**
     * 使用节点存储  私有内部类
     */
    private class Node {
        public E e;
        public Node next; // 属性下一个节点

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //    链表中有多少元素
    private int size;
    private Node dummyHead; // 虚拟头节点

    // 初始化节点
    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //   返回链表的元素个数
    public int getSize() {
        return size;
    }

    //   链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //   在头部新增一个节点
    public void addFirst(E e) {
//       Node node = new Node(e);
//       node.next = head;
//       head = node;

        add(0, e);
    }

    //   向链表中的指定位置添加元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index");

        else {
            Node prev = dummyHead;
            for (int i = 0; i < index; i++)
                prev = prev.next;

            prev.next = new Node(e, prev.next);
            size++;
        }

    }

    //   在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    //   查找链表中指定下标下的元素
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get failed,Illgal index");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    //    替换指定位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set failed,Illgal index");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = dummyHead.next;
        }
//      将指定位置的元素换成新的元素
        cur.e = e;
    }

    //    判断是否包含某个元素
    public boolean contains(E e) {

        Node cur = dummyHead.next;
//      如果不为空的话，那么说明存在这个节点
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }

            cur = cur.next;
        }
        return false;

    }

    /**
     * 从链表中删除一个元素
     *时间复杂度是O（n/2) 即O（n）
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("set failed,Illgal index");
        // 虚拟头节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    //    删除第一个元素  时间复杂度 O（1）
    public E removeFirst() {
        return remove(0);
    }

    //  删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        // 当前元素
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "==>");
        }

//         Node cur = dummyHead.next;
//         while (cur != null){
//
//             cur = cur.next;
//         }

        res.append("NULL");

        return res.toString();
    }
}
