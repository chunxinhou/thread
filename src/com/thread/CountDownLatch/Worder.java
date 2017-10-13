package com.thread.CountDownLatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hcx on 2017/10/13.
 */
public class Worder extends Thread {
    String workerName ;
    CountDownLatch latch;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm;ss");
    private int workerTime;

    public Worder(String workerName, CountDownLatch latch,int workerTime) {
        this.workerName = workerName;
        this.latch = latch;
        this.workerTime = workerTime;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(workerName+"begin at"+format.format(new Date()));
        doWork();
        System.out.println(workerName+"end at"+format.format(new Date()));
        latch.countDown();//计数器减为0，则说明线程全部完成
        System.out.println(workerName+"after of"+latch.getCount());
    }

    private void doWork() {
        try {
            Thread.sleep(workerTime);
            System.out.println(workerName+"工作ing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
