package com.hzwq.queue;


/**
 * @Author: shaoRongGang
 * @Description:循环队列
 * @Date:Created in 22:10 2020/4/7
 * @Modifid By:
 * @Version：
 */
public class LoopQueue<E> implements Queue<E> {
    //  数组
    private E[] data;
    //   头部/尾部指针
    private int front,tail;
    // todo:可以尝试没有size的实现方案
    private int size;

    public LoopQueue(int capacity) {
//        初始化一下数组,由于需要空出来一个位置，需要加一
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //  改变容量
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[(front + i) % data.length];
        }

        data = newArray;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty");
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //        缩容,但是不为零
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuffer stringBuilder = new StringBuffer();
        stringBuilder.append(String.format("LoopQueue :size=%d , capacity = %d\n", size, data.length));
        stringBuilder.append("front [");
        for (int i = front; i != tail;i = (i + 1)%data.length ) {
            stringBuilder.append(data[i]);
            if ((i + 1)%data.length != tail) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>(20);
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }

    }
}
