package com.thread.test;

import com.thread.util.BusyFlag;

/**
 * Created by hcx on 2017/9/27.
 */
public class TestBusyFlag {


    class MyThread extends  Thread{

        public MyThread(String name) {
            super(name);
            busyFlag = new BusyFlag();
        }

        @Override
        public void run() {
            add();
        }
    }

    BusyFlag busyFlag ;
    int i ;

    public void add(){
        //加锁
        busyFlag.getBusyFlag();

        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        //释放锁
        busyFlag.freeBusyFlag();
    }

    public static void main(String[] args){
        TestBusyFlag testBusyFlag = new TestBusyFlag();
        MyThread thread1 = testBusyFlag.new MyThread("线程一");
        MyThread thread2 = testBusyFlag.new MyThread("线程二");
        MyThread thread3 = testBusyFlag.new MyThread("线程三");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
