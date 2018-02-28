package com.roll.comical.invoke;

/**
 * Date: 07/02/2018
 *
 * @author zongqiang.hao
 */
public class BaseClass {

	int i;


	BaseClass() {
	}

	BaseClass(int i) {
		this.i = i;
	}

	public void print(int a) {
		System.out.println(a + "i: " + i);
	}
}
