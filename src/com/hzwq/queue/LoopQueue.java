package com.hzwq.queue;


/**
 * @Author: shaoRongGang
 * @Description:循环队列
 * @Date:Created in 22:10 2020/4/7
 * @Modifid By: shaoronggang
 * @Version：
 *
 * todo:
 * 1.使用无size形式，重写循环队列
 * 2.比较两个循环的不同，进行重写
 *
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front,tail;
    // 队列中有多少个元素
    private int size;

    public LoopQueue(int capacity) {
        // 有意识的浪费一个空间,可以用来判断队列是否元素已满
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    // 容积
    public int getCapacity(){
        return data.length -1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队方法
     * @param e
     */
    @Override
    public void enqueue(E e) {
    if ((tail +1)%data.length == front)
        resize(getCapacity()*2);

    data[tail]  = e;
    tail = (tail + 1)%data.length;
    size++;
    }

    /**
     * 扩容方法
     * @param newCapacity 新数组长度
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 循环队列 原来队列中的数据有一个front的偏移
            newData[i] = data[(front + i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw  new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1)%data.length;
        size--;
        // 为了防止空间浪费
        if (size == getCapacity()/4 && getCapacity()/2 != 0)
            resize(getCapacity()/2);

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuffer stringBuilder = new StringBuffer();
        stringBuilder.append(String.format("Array :size=%d , capacity = %d\n", size, getCapacity()));
        stringBuilder.append("front[");
        for (int i = front; i != tail; i = (i + 1)%data.length) {
            stringBuilder.append(data[i]);
            if ((i+1)%data.length != tail) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]tail");

        return stringBuilder.toString();
    }
}
