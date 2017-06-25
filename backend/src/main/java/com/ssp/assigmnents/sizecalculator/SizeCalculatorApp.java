package com.ssp.assigmnents.sizecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ssp.assigmnents.sizecalculator.rest.SizeCalculatorRestService;

@SpringBootApplication
public class SizeCalculatorApp {

	public static void main(String[] args) {
		 SpringApplication.run(SizeCalculatorRestService.class, args);
	}

}
