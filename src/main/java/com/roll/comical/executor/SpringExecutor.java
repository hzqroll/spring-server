package com.roll.comical.executor;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.roll.comical.test.SpringTestBase;

/**
 * Date: 27/01/2018
 *
 * @author zongqiang.hao
 */
public class SpringExecutor extends SpringTestBase {

	@Resource(name = "threadPoolTaskExecutor")
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Test
	public void test() {
		Thread thread = new SimpleTask(1);
		threadPoolTaskExecutor.submit(thread);
	}
}
