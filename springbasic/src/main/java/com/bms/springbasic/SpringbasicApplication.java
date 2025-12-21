package com.bms.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bms.springbasic.classes.Laptop;

@SpringBootApplication
public class SpringbasicApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringbasicApplication.class, args);

		//get the memory object of spring context in which all objects will lie
		ConfigurableApplicationContext context = SpringApplication.run(SpringbasicApplication.class, args);

		//we will ask spring framework to create our object
		Laptop appleA8 = context.getBean(Laptop.class);

		appleA8.setBrandName("Apple");
		appleA8.setLength(100);
		appleA8.setWidth(150);

		System.out.println(appleA8.toString());
	}

}
