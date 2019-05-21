package com.uit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = { "/", "tin-tuc/trang-chu" }, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
}