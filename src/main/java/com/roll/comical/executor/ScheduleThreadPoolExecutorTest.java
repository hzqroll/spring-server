package com.roll.comical.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Date: 19/01/2018
 *
 * @author zongqiang.hao
 */
public class ScheduleThreadPoolExecutorTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(5);
		Callable<Integer> thread = new Task(1);
		ScheduledFuture<Integer> future = executor.schedule(thread, 1000, TimeUnit.MILLISECONDS);
		System.out.println(future.get());
	}

	static class Task implements Callable<Integer> {
		private int i;

		Task(int i) {
			this.i = i;
		}

		@Override
		public Integer call() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i + " Time: " + System.currentTimeMillis());
			return i;
		}
	}
}
