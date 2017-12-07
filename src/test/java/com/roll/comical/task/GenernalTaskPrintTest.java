package com.roll.comical.task;

import java.util.Date;

import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Date: 2017/12/7
 *
 * @author zongqiang.hao
 */
public class GenernalTaskPrintTest {
	@Test
	@Scheduled(fixedDelay = 1000)
	public void print() {
		System.out.println(new Date());
	}

}