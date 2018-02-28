package com.roll.comical.executor;

/**
 * Date: 27/01/2018
 *
 * @author zongqiang.hao
 */
public class SimpleTask extends Thread {
	private int i;

	public SimpleTask(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("task: " + i + ", " + System.currentTimeMillis());
	}

}
