package com.roll.comical.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Date: 07/02/2018
 *
 * @author zongqiang.hao
 */
public class InvokeTest {
	public static void main(String[] args) {
		try {
			BaseClass baseClass = new BaseClass();
			Constructor constructor = BaseClass.class.getConstructor(int.class);
			BaseClass baseClass1 = (BaseClass) constructor.newInstance(10);
			Method method = baseClass.getClass().getMethod("print", int.class);
			method.invoke(baseClass1, 1);
			/*Class clazz = baseClass.getClass();
			//System.out.println(clazz.getName());
			Constructor[] conArray = clazz.getDeclaredConstructors();
			for (Constructor c : conArray) {
				System.out.println(c);
			}*/

			Class<?> classType = Class.forName("com.roll.comical.invoke.BaseClass");
			/*ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("common.xml");
			BaseClass baseClass = (BaseClass) applicationContext.getBean("baseClass",BaseClass.class);
			baseClass.print(1);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
