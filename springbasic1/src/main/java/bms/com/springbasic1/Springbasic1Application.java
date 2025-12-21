package bms.com.springbasic1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import bms.com.springbasic1.classes.Laptop;

@SpringBootApplication
public class Springbasic1Application {

	public static void main(String[] args) {
		//SpringApplication.run(Springbasic1Application.class, args);

		//get the memory object of spring context in which all objects will lie
		ConfigurableApplicationContext context = SpringApplication.run(Springbasic1Application.class, args);

		//we will ask spring framework to create our object
		Laptop appleA8 = context.getBean(Laptop.class);

		appleA8.setBrandName("Apple");
		appleA8.setLength(100);
		appleA8.setWidth(150);

		System.out.println(appleA8.toString());
	}

}
