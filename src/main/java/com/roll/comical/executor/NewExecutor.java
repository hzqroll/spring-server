package com.roll.comical.executor;

import java.util.concurrent.Executor;

/**
 * Date: 05/01/2018
 *
 * @author zongqiang.hao
 */
public class NewExecutor implements Executor {
	@Override
	public void execute(Runnable command) {
		ThreadGroup threadGroup = new ThreadGroup("NewExecutorGroupName");
		Thread[] threads = new Thread[]{new Thread(command)};
		threadGroup.enumerate(threads);
		new Thread(threadGroup, command, "NewExecutor").run();
	}
}
