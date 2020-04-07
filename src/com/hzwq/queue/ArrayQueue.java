package com.hzwq.queue;

import com.hzwq.array.GoodArray;

/**
 * @Author: shaoRongGang
 * @Description: 队列的实现类 ，底层实现使用了动态数组
 * @Date:Created in 21:59 2020/4/6
 * @Modifid By:
 * @Version：
 */
public class ArrayQueue<E> implements Queue<E> {
//    自定义的动态数组
    private GoodArray<E> array;

    public ArrayQueue(int capacity) {
        this.array = new GoodArray<>(capacity);
    }

    public ArrayQueue() {
        this.array = new GoodArray<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
