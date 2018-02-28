package com.roll.comical.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Date: 24/01/2018
 *
 * @author zongqiang.hao
 */
public class RabbitMQConnectionFactory extends ConnectionFactory {

	public RabbitMQConnectionFactory(String host, int port, String userName, String password) throws Exception {
		if (host == null || host.equals("")) {
			throw new Exception("host 不能为空");
		}
		if (port == 0) {
			throw new Exception("port 不能为空");
		}
		if (userName == null || userName.equals("")) {
			throw new Exception("userName 不能为空");
		}
		if (password == null || password.equals("")) {
			throw new Exception("password 不能为空");
		}
		this.setHost(host);
		this.setPort(port);
		this.setUsername(userName);
		this.setPassword(password);
		this.setConnectionTimeout(1000);
	}
}
