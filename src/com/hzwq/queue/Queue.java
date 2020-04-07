package com.hzwq.queue;

/**
 * @Author: shaoRongGang
 * @Description: 队列接口，先进先出，FIFO
 * @Date:Created in 21:53 2020/4/6
 * @Modifid By:
 * @Version：
 */
public interface Queue<E> {
// 队列的长度
    int getSize();
// 队列是否为空
    boolean isEmpty();
//   向队列中添加元素,队尾添加
    void enqueue(E e);
//  从队列中取出元素,队首取出
    E dequeue();
//查看队首的元素
    E getFront();

}


