package com.thread.CountDownLatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hcx on 2017/10/13.
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        //栅栏对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        CountDownLatch latch = new CountDownLatch(2);
        Worder w1 = new Worder("worker1",latch,5000);
        Worder w2 = new Worder("worker2",latch,5000*2);

        w1.start();
        w2.start();
        try {
            latch.await();
            System.out.println("主线程继续运行"+format.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
