package com.roll.comical.executor;

import java.io.PrintWriter;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Date: 14/01/2018
 *
 * @author zongqiang.hao
 */
public class LogWrite {
	private final BlockingQueue<String> queue;

	private final LoggerThread loggerThread;

	private boolean isShutdown;

	private int reservations;

	public LogWrite(PrintWriter writer) {
		this.queue = new LinkedBlockingQueue<String>(100);
		this.loggerThread = new LoggerThread(writer);
	}

	public void start() {
		loggerThread.start();
	}

	public void log(String msg) throws InterruptedException {
		synchronized (this) {
			if (isShutdown) {
				throw new IllegalStateException("123");
			}
			++reservations;
		}
		queue.put(msg);
	}

	private class LoggerThread extends Thread {
		private final PrintWriter writer;

		private LoggerThread(PrintWriter writer) {
			this.writer = writer;
		}


		public void run() {
			try {
				while (true) {
					synchronized (LogWrite.this) {
						if (isShutdown && reservations == 0) {
							break;
						}
					}
					String msg = queue.take();
					synchronized (LogWrite.this) {
						--reservations;
					}
					writer.println(msg);
				}
			} catch (Exception e) {

			} finally {
				writer.close();
			}
		}
	}

	boolean checkMail(Set<String> hosts, long timeOut, TimeUnit unit) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		final AtomicBoolean hasNewMail = new AtomicBoolean(false);
		try {
			for (final String host : hosts) {
				exec.execute(new Runnable() {
					@Override
					public void run() {
						if ("getMailIsNew".equals("")) {
							hasNewMail.set(true);
						}
					}
				});
			}
		} finally {
			exec.shutdown();
			exec.awaitTermination(timeOut, unit);
		}
		return hasNewMail.get();
	}
}
