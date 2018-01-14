package com.roll.comical.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Date: 05/01/2018
 *
 * @author zongqiang.hao
 */
public class ExecutorTest {
	public static void main(String[] args) {
		Executor executor = new NewExecutor();
		executor.execute(new NewThread(1));

		Executor executor1 = Executors.newSingleThreadExecutor();
		NewThread thread = new NewThread(2);
	}
}

class NewThread implements Runnable {

	private int i;

	public NewThread(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(i);
	}
}