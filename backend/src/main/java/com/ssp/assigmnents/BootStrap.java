package com.ssp.assigmnents;

import org.springframework.boot.SpringApplication;

import com.ssp.assigmnents.rest.SizeCalculatorRestService;

public class BootStrap {

	public static void main(String[] args) {
		 SpringApplication.run(SizeCalculatorRestService.class, args);
	}

}
