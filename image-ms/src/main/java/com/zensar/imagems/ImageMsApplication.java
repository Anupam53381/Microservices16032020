package com.zensar.imagems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableC
@EnableEurekaClient
public class ImageMsApplication {
	
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ImageMsApplication.class, args);
	}

}
