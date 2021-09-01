package baseknowledge.java.Polymorphic;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程学习
 */
public class ThreadLearn {
    public static void main(String[] args) throws InterruptedException {
        ThreadLearn learn = new ThreadLearn();
        learn.createThreadByRun();
        learn.createThreadByRunnable();

        ThreadLearn.IconThread iconThread = learn.new IconThread();  // 创建内部类对象
        iconThread.start();
        iconThread.sleep(1);
        iconThread.running = false; // 标志位设置为false

        /*线程同步*/
        ThreadLearn.AddThred addThred = learn.new AddThred();
        ThreadLearn.DesThread desThread = learn.new DesThread();
        addThred.start();
        desThread.start();
        addThred.join();
        desThread.join();
//      如果不加锁，每次执行后的结果都可能会不同。
        System.out.println(Counter.count);
    }

    /**
     * 通过集成Thread类来创建线程，建立一个新的任务
     *
     * @return
     * @throws InterruptedException
     */
    private int createThreadByRun() throws InterruptedException {
        int i = -1;
        Thread thread = new MyThread();
        thread.start();
        Thread.sleep(1000); // 线程暂停1毫秒
        thread.interrupt();// 中断thread线程使用interrupt方法来进行中断
        thread.join(); // 等待thread线程结束
        System.out.println("end");
        return i;
    }

    /**
     * 通过实现Runnable接口来创建线程，建立新任务
     *
     * @return
     */
    private int createThreadByRunnable() {
        int j = -1;
        Thread thread = new Thread(new MyRunnale());
        thread.start();
        return j;
    }

    /**
     * 自定义的runnable接口实现类
     */
    class MyRunnale implements Runnable {

        @Override
        public void run() {
            System.out.println("通过runnable创建线程");
        }
    }

    /*--------------------------------中断线程的方式一：使用interrupte（）方法来中断线程，使用isInterrupted 来判断，如果isInterrupted为true，中断run方法的执行------*/
    class HelloThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + "hello!");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }

        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            Thread helloThread = new HelloThread(); // 启动hello线程
            helloThread.start();

            try {
                helloThread.join(); // 等待hello线程结束
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            }

            helloThread.interrupt();
        }
    }

    /*--------------------------------中断线程的方式一：使用interrupte（）方法来中断线程，使用isInterrupted 来判断，如果isInterrupted为true，中断run方法的执行------*/

    /*--------------------------------使用标识位来中断线程--------------------------------------*/
    class IconThread extends Thread{

        public volatile boolean running = true;
        @Override
        public void run() {
            int n = 0;
        if (running){
            n++;
            System.out.println(n + "hello");
        }
            System.out.println("end");
        }
    }

    /*--------------------------------使用标识位来中断线程-------------------------------------*/



    /*--------------------------------线程同步----------------------------------*/
    static class Counter{
        public static int count = 0;
        public static final Object obj = new Object();
    }

    class AddThred extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (ThreadLearn.class){
                    Counter.count += 1;
                }
            }
        }
    }

    class DesThread extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (ThreadLearn.class){
                    Counter.count -=1;
                }
            }
        }
    }

    /*--------------------------------线程同步----------------------------------*/

    /*--------------------------------使用ReentrantLock和Condition实现更灵活的线程同步----------------------*/
    class TaskQuene{
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();
        private Queue<String> queue = new LinkedList<>();

        public void addTask(String s){
            lock.lock();
            try{
                queue.add(s);
                // 唤醒所有等待线程
                condition.signalAll();
            }finally{
                lock.unlock();
            }
        }

        public String getTask() throws InterruptedException {
            lock.lock();
            try{
                while (queue.isEmpty()){
                    // 释放当前锁，进入等待状态
                    condition.await();
                }
                return queue.remove();
            }finally {
                lock.unlock();
            }

        }

    }
    /*--------------------------------使用ReentrantLock和Condition实现更灵活的线程同步----------------------*/


    /*----------------------------------创建线程池----------------------------------------------------*/
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    // 提交任务


    /*----------------------------------创建线程池----------------------------------------------------*/


}
