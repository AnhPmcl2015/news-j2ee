package com.uit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uit.define.impl.InitialData;

@Component
public class Initializer implements CommandLineRunner{

	@Autowired InitialData service;
	
	@Override
	public void run(String... args) throws Exception {
		 this.service.initRole();
		 this.service.initUser();
		 this.service.initTag();
		 this.service.initPriority();
		 this.service.initNews("D:\\J2EE\\news-j2ee\\news-j2ee\\190520 thanhnien\\");
	}
	
}
