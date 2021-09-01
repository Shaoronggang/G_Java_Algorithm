package com.hzwq.queue;

public class LinkedListQueue<E> implements Queue<E> {

    // 头部指针，尾指针
    private Node head,tail;
    // 长度
    private int size;

    // 初始化队列
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向队列中添加元素，从链表队尾添加元素
     * @param e
     */
    @Override
    public void enqueue(E e) {
    if (tail == null){
        tail = new Node(e);
        head = tail;
    }else{
        tail.next = new Node(e);
        tail = tail.next;
    }
    size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        Node retNode = head;
        head = head.next;
        retNode.next = null;// 脱离链表结构

        if (head == null)
            tail = null;
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front");

        Node cur = head;
        while(cur !=null){
            res.append(cur + "->");
            cur = cur.next;
        }

        res.append("NULL tail");
        return res.toString();
    }

    // 链表节点
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }




}
