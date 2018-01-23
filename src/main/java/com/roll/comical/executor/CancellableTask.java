package com.roll.comical.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * Date: 14/01/2018
 *
 * @author zongqiang.hao
 */
public interface CancellableTask<T>  extends Callable<T>{
	void cancel();

	RunnableFuture<T> newTask();
}
