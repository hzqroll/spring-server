package com.roll.comical.executor;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Date: 09/01/2018
 *
 * @author zongqiang.hao
 */
public class HQueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.add(1);
		queue.offer(1);
		System.out.println(queue);
	}
}
