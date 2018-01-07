package com.roll.comical.task.executor;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDestoryTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadTest1 threadTest1 = new ThreadTest1();
        Thread t1 = new Thread(threadTest1,"thread1");
        Thread t2 = new Thread(threadTest1,"thread2");
        t1.start();
        System.out.println(t1.toString());
        System.out.println(t1.getContextClassLoader());
        t2.join(385);
        t2.start();
    }


}


class ThreadTest1 extends Thread {
   private Lock lock = new ReentrantLock();

   private Object object = new Object();

    int a = 10;

    @Override
    public void run(){
       synchronized(object){
           for (int i = 0;i<10;i++){
               System.out.println(Thread.currentThread().getName()+":"+i);
           }
       }

    }
}
