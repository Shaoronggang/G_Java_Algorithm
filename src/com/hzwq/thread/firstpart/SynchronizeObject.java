package com.hzwq.thread.firstpart;

/**
 * 验证suspend线程独占问题类
 */
public class SynchronizeObject {
   synchronized public void printString(){
       System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("a 线程永远suspend了");
            Thread.currentThread().suspend();
        }

        System.out.println("end");
    }
}
