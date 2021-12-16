package com.hzwq.queue;

import com.hzwq.heap.MaxHeap;

/**
 * 使用最大堆实现优先队列
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
private MaxHeap<E> heap;

    @Override
    public int getSize() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.extractMax();
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }
}
