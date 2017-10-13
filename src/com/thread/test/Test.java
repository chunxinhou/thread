package com.thread.test;

/**
 * Created by hcx on 2017/9/27.
 */
public class Test {

    public  static void main(String[] args){
        TestCurrentThread testCurrentThread = new TestCurrentThread(5);

        String s =testCurrentThread.getThread();
        System.out.println(s);
    }

}
