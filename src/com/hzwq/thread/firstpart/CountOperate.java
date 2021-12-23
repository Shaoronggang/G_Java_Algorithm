package com.hzwq.thread.firstpart;

public class   CountOperate  extends Thread{
    public CountOperate() {
        System.out.println("CountOperate -- begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().isAlive()); // 查看线程是否活跃
        System.out.println("Thread.currentThread().getId()=" + Thread.currentThread().getId());

        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.getName()=" + this.isAlive());
        System.out.println("this.getId()=" + this.getId());

        System.out.println("CountOperate --- end");
    }

    @Override
    public void run() {
        System.out.println("run -- begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().isAlive());
        System.out.println("Thread.currentThread().getId()=" + Thread.currentThread().getId());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.getName()=" + this.isAlive());
        System.out.println("this.getId()=" + this.getId());
        System.out.println("run --- end");
    }
}
