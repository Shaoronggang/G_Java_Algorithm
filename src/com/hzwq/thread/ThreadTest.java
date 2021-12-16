package com.hzwq.thread;

public class ThreadTest {
    public static void main(String[] args) {
//        AThreadFirstPartThread aThreadFirstPartThread = new AThreadFirstPartThread();
//        // start方法通知"线程规划器"此线程已经准备就绪，等待线程对象的run()方法
//        aThreadFirstPartThread.start();
//        try {
//            for (int i = 0; i < 10; i++) {
//                int time = (int) (Math.random()*1000);
//                Thread.sleep(time);
//                System.out.println("run=" + Thread.currentThread().getName());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("运行结束!");



        /*----------------------------------------------------------------------*/


//        MyThread a = new MyThread("A");
//        MyThread b = new MyThread("B");
//        MyThread c = new MyThread("C");
//        a.start();
//        b.start();
//        c.start();


        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
