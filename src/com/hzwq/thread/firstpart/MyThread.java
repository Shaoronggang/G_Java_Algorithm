package com.hzwq.thread.firstpart;

public class MyThread extends Thread {
    private int count = 5;

    // 设置线程名称
    public MyThread(String name) {
        super();
        this.setName(name);
    }

    public MyThread() {
        super();
    }

    // synchronized可以在任意对象及方法上加锁，而加锁的这段代码称为"互斥区" 或"临界区" 解决了"非线程安全问题"
    // 非线程安全问题，主要指多个线程对同一个对象中的同一个实例变量进行操作时会出现值被更改、值不同步的情况，进而影响到了程序的执行流程。
    @Override
    synchronized public void run() {
        super.run();

        /*-----------------------------线程安全问题----------------------------*/
//        while(count > 0){
        // 此处不要使用for语句，因为使用同步后其他线程就得不到运行的机会了
        // 此处一直由一个线程进行减法运算

//        count--;
//        System.out.println("由" + currentThread().getName() + "计算，count=" + count);
//        }

        /*-----------------------------线程安全问题----------------------------*/

        /*-----------------------------线程停止处理----------------------------*/
//        try {
//            for (int i = 0; i < 500000; i++) {
//                if (Thread.interrupted()){
//                    System.out.println("已经是停止状态，我要退出了");
//                    throw new InterruptedException(); // 通过抛出异常，停止线程
//                }
//
//                System.out.println("i="+ (i + 1));
//            }
//            System.out.println("我输出了，但是如果此代码是for继续运行，线程并未停止"); // 需要使用try...catch将所有代码包裹进去
//        } catch (Exception e) {
//            System.out.println("进入了Mythread.java的run方法的catch()");
//            e.printStackTrace();
//        }

        /*-----------------------------线程停止处理----------------------------*/

        /*-----------------------------sleep状态下线程停止处理----------------------------*/
//        try {
//            for (int i = 0; i < 100000; i++) {
//                System.out.println("i=" + (i + 1));
//            }
//
//            System.out.println("start");
//            Thread.sleep(200000);
//            System.out.println("end");
//        } catch (InterruptedException e) {
////            System.out.println("在沉睡中被停止，进入到了catch:" + this.isInterrupted());
//            System.out.println("先停止再遇到sleep！进入到了catch:" + this.isInterrupted());
//            e.printStackTrace();
//        }

        /*-----------------------------sleep状态下线程停止处理----------------------------*/

        /*-----------------------------守护线程----------------------------*/
        int i = 0;
        try {
            while (true){
                i++;
                System.out.println("i= "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*-----------------------------守护线程----------------------------*/
    }
}
