package com.thread.test;

/**
 * Created by hcx on 2017/9/27.
 */
public class TestCurrentThread {

    /**
     * 内部方法
     */
    class MyThread extends Thread{
        @Override
        public void run() {
            String str = Thread.currentThread().getName();
            System.out.println(str);
        }

        public MyThread(String name,int i) {
            super(name+i);
        }
    }

    MyThread myThread[];
    public TestCurrentThread(int n ) {
        myThread = new MyThread[n];
        for (int i = 0; i <n; i++) {
            myThread[i] =  new MyThread("T",i);
            myThread[i].start();
        }
    }

    public String getThread(){
        return Thread.currentThread().getName();
    }

}
