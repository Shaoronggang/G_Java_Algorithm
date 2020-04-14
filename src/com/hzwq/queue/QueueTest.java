package com.hzwq.queue;

/**
 * @Author: shaoRongGang
 * @Description: 队列的测试类
 * @Date:Created in 22:32 2020/4/6
 * @Modifid By:
 * @Version：
 */
public class QueueTest {
    public static void main(String[] args) {
//        数组队列测试
        arrayQueneTest();
//        循环数组测试
        loopQueueTest();


    }

    private static void loopQueueTest() {
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

    private static void arrayQueneTest() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }


//取余操作
        int a = 8 % 8;
        System.out.println("a:" + a);
    }
}
