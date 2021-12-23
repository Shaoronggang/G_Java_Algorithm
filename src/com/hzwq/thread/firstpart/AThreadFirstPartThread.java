package com.hzwq.thread.firstpart;

public class AThreadFirstPartThread extends Thread {
    @Override
    public void run() {
        super.run();
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getId());
        System.out.println("AThreadFirstPart");

        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
