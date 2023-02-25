package com.currency.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeApplication {

	public static void main(String[] args) {

		try{
			SpringApplication.run(ExchangeApplication.class, args);
		}
		catch (Exception e){
			System.out.println(e);
		}



	}

}
