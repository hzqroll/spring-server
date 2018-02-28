package com.roll.comical.executor;

import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;

import com.roll.comical.test.SpringTestBase;

/**
 * Date: 27/01/2018
 *
 * @author zongqiang.hao
 */
public class ScheduleTask extends SpringTestBase {
	@Test
	@Scheduled(cron = "*/5 * * * * *")
	public void test() {
		System.out.println(System.currentTimeMillis());
	}
}
