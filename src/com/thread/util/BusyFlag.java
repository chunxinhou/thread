package com.thread.util;

/**
 * Created by hcx on 2017/9/27.
 * 利用线程标记来实现自定义锁
 * 自定义线程锁
 * 1、跨方法加锁
 * 2、嵌套加锁
 * 3、减少竞争
 */
public class BusyFlag {
    /**
     * 线程标记
     */
    protected Thread busyFlag = null;
    /**
     * 锁数量
     */
    protected  int busycount = 0;

    /**
     * 获取自定义锁
     * 如果当前线程与线程标记不同则调用wait()等待
     */
    public synchronized void getBusyFlag(){
        while(tryGetBusyFlag() == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean tryGetBusyFlag(){
        if (busyFlag == null){
            busyFlag = Thread.currentThread();
            busycount++;
            return true;
        }
        if(busyFlag == Thread.currentThread()){
            busycount++;
            return true;
        }
        return false;
    }

    /**
     * 释放锁
     */
    public synchronized void freeBusyFlag(){
        if(getBusyFlagOwner() == Thread.currentThread()){
            busycount--;
            if(busycount == 0){
                busyFlag = null;
                notify();
            }
        }
    }

    /**
     * @return 得到当前的线程标记
     */
    public Thread getBusyFlagOwner() {
        return busyFlag;
    }
}
