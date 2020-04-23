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
     * 使用节点存储
     */
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

//    链表的头部
   private Node head;
//    链表中有多少元素
   private int size;
   private Node dummyHead; //

   public LinkedList(){
       dummyHead = new Node(null,null);
       size = 0;
   }

//   返回链表的元素个数
   public int getSize(){
       return size;
   }
//   链表是否为空
   public boolean isEmpty(){
       return size == 0;
   }
//   在头部新增一个节点
   public void addFirst(E e){
//       Node node = new Node(e);
//       node.next = head;
//       head = node;

       head = new Node(e,head); //等同于上面三个语句
       size++;
   }

//   向链表中的指定位置添加元素e
   public void add(int index,E e){
       if (index < 0 || index > size)
           throw new IllegalArgumentException("Add failed,Illgal index");
       if (index == 0)
           addFirst(e);
       else {
           Node prev = head;
           for (int i = 0; i < index - 1 ; i++)
               prev = prev.next;

           prev.next = new Node(e,prev.next);
           size++;
       }

   }

//   在链表末尾添加新的元素e
   public void addLast(E e){
       add(size,e);
   }




}
