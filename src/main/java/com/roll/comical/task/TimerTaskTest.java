package com.roll.comical.task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Date: 17/12/2017
 *
 * @author zongqiang.hao
 */
public class TimerTaskTest {
	public static void main(String ars[]) {
		Timer task = new Timer();
		task.schedule(new timeTask(), 10000L);
	}

	static class timeTask extends TimerTask {
		@Override
		public void run() {
			System.out.println(System.currentTimeMillis());
		}
	}
}
