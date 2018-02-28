package com.roll.comical.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Date: 27/01/2018
 *
 * @author zongqiang.hao
 */
@ContextConfiguration(locations = {"classpath:common.xml", "classpath:executor/spring_executor.xml", "classpath:rabbitmq/rabbitmq.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestBase {
}
