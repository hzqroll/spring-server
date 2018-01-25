package com.roll.comical.executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Date: 23/01/2018
 *
 * @author zongqiang.hao
 */
public class PoolSizeTest {
	public static void main(String[] args) {
		/*ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		Thread thread = new testThread();
		poolExecutor.submit(thread);
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		poolExecutor.shutdownNow();
		poolExecutor.setCorePoolSize(1);
		poolExecutor.submit(thread);*/
		ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(2);
		Thread thread1 = new testThread(1);
		Thread thread2 = new testThread(2);
		Thread thread3 = new testThread(3);

		poolExecutor.scheduleWithFixedDelay(thread1, 0, 500, TimeUnit.MILLISECONDS);
		poolExecutor.scheduleWithFixedDelay(thread2, 0, 500, TimeUnit.MILLISECONDS);
		poolExecutor.scheduleWithFixedDelay(thread3, 0, 500, TimeUnit.MILLISECONDS);

	}

	static class testThread extends Thread {
		private int i;

		public testThread(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i + " : " + System.currentTimeMillis());
		}
	}
}
