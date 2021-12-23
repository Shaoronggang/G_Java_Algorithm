package com.hzwq.thread.firstpart;

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



        /*------------------------------非线程安全问题验证----------------------------------------*/


//        MyThread a = new MyThread("A");
//        MyThread b = new MyThread("B");
//        MyThread c = new MyThread("C");
//        a.start();
//        b.start();
//        c.start();


        // 如下操作将产生线程安全问题，需要使用synchronized关键字来处理线程安全问题
//        MyThread myThread = new MyThread();
//        Thread a = new Thread(myThread,"A");
//        Thread b = new Thread(myThread,"B");
//        Thread c = new Thread(myThread,"C");
//        Thread d = new Thread(myThread,"D");
//        Thread e = new Thread(myThread,"E");
//        a.start();
//        b.start();
//        c.start();
//        d.start();
//        e.start();
        /*------------------------------非线程安全问题验证----------------------------------------*/

        /*------------------------------currentThread（）方法以及isAlive判断----------------------------------------*/
//        CountOperate c = new CountOperate();
//        Thread t1 = new Thread(c);
//        System.out.println("main begin thread t isAlive = "+ t1.isAlive());
//        System.out.println("main begin thread t getId() = "+ Thread.currentThread().getId());
//        t1.setName("A");
//        t1.start();
//        System.out.println("main end thread t isAlive = "+ t1.isAlive());
        /*------------------------------currentThread（）方法----------------------------------------*/

        /*------------------------------线程停止操作----------------------------------------*/

//        try {
//            MyThread thread = new MyThread();
//            System.out.println("start");
//            thread.start();
//            Thread.sleep(100); // 主线程沉睡2s 会影响打印结果
//            thread.interrupt(); // 在当前线程做一个标记，并不是真正的停止线程
////            Thread.currentThread().interrupt(); //当前线程停止标记 main线程
//            System.out.println("是否停止1？="+thread.interrupted());// interrupted 具有清除状态的效果，所以，第二次调用的时候，会显示false
//            System.out.println("是否停止2？="+thread.interrupted());
//
//            System.out.println("是否停止3？= " + thread.isInterrupted());
//            System.out.println("是否停止4？= " + thread.isInterrupted());// isInterrupted 线程中断被忽略，因为线程不是活动的在中断的时候将被这个方法反映出来返回false。
//
//
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }
//        System.out.println("end");

        /*------------------------------线程停止操作----------------------------------------*/


        /*------------------------------sleep状态下线程停止操作----------------------------------------*/

//        try {
            MyThread thread = new MyThread();
            thread.start();
//            Thread.sleep(200);
            thread.interrupt();
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }

        System.out.println("end");
        /*------------------------------sleep状态下线程停止操作----------------------------------------*/




    }
}
