package com.roll.comical.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Date: 2017/12/7
 *
 * @author zongqiang.hao
 */
@Service
public class GenernalTaskPrint {
	@Scheduled(fixedDelay = 1000)
	public void print() {
		System.out.println(new Date());
	}
}
