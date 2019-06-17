package com.uit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController{

	@Override
	public String getErrorPath() {
		System.out.println("error");
		return "/error";
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		return "error";
	}
}
