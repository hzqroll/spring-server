package com.roll.comical.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Date: 2017/12/7
 *
 * @author zongqiang.hao
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping("/print")
	@ResponseBody
	public String print() {
		System.out.println(System.currentTimeMillis());
		return "index";
	}
}
