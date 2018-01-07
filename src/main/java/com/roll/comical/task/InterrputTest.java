/*
package com.roll.comical.task;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InterrputTest {
    private static final ScheduledExecutorService cancelExec = new ScheduledThreadPoolExecutor(.scheduleAtFixedRate(1000));
    public static void timedRun(Runnable r, long timeout, TimeUnit unit){
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                new Thread().interrupt();
            }
        },timeout,unit);
        r.run();
    }

    public static void timeRun2(final Runnable r,long timeOut,TimeUnit unit) throws InterruptedException{
        class RathrowableTask implements Runnable{

            private volatile Throwable t;
            @Override
            public void run() {
                try {
                    r.run();
                }catch (Throwable t){
                    this.t = t;
                }
            }
            void rethrow(){
                if (t!=null){
                    throw  Exception;
                }
            }

        }
        RathrowableTask task = new RathrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExec.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        },timeOut,unit);
        taskThread.join(unit.toMillis(timeOut));
        task.rethrow();
    }
}
*/
