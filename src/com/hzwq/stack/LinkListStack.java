package com.hzwq.stack;

import com.hzwq.linkList.LinkedList;

/**
 * 链表实现的栈
 * @param <E> 泛型
 */
public class LinkListStack<E> implements Stack<E>{

    private LinkedList<E> list;

    public LinkListStack() {
        this.list = new LinkedList();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
