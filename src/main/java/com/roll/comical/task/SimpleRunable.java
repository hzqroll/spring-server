package com.roll.comical.task;

/**
 * Date: 17/12/2017
 *
 * @author zongqiang.hao
 */
public class SimpleRunable implements Runnable {

	private int i = 0;

	public SimpleRunable(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(i);
	}
}
