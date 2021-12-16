package com.hzwq.thread;

public class   MyThread  extends Thread{
    private int count = 5;

    // 设置线程名称
    public MyThread(String name){
        super();
        this.setName(name);
    }

    public MyThread(){
        super();
    }

    // synchronized可以在任意对象及方法上加锁，而加锁的这段代码称为"互斥区" 或"临界区" 解决了"非线程安全问题"
    @Override
   synchronized public void run() {
        super.run();
//        while(count > 0){
        // 此处不要使用for语句，因为使用同步后其他线程就得不到运行的机会了
        // 此处一直由一个线程进行减法运算

            count--;
            System.out.println("由" + this.currentThread().getName() + "计算，count=" + count);


//        }
    }
}
