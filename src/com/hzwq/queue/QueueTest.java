package com.hzwq.queue;

import com.hzwq.stack.Stack;

import java.util.Random;

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
//        arrayQueneTest();
//        循环数组测试
//        loopQueueTest();
//        linkedListQueueTest();
        int opCount = 1000000;
        ArrayQueue arrayQueue = new ArrayQueue();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time:" + time1);
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue time:" + time3);
        LoopQueue loopQueue = new LoopQueue();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time:" + time2);

    }


    private static void loopQueueTest() {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
        for (int i = 0; i < 100000; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }


    private static void linkedListQueueTest() {
        LinkedListQueue<Integer> arrayQueue = new LinkedListQueue<>();
        for (int i = 0; i < 100000; i++) {
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
        for (int i = 0; i < 100000; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }


    /**
     * 队列性能测试
     *
     * @param stack
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 10000000000.0;
    }
}
