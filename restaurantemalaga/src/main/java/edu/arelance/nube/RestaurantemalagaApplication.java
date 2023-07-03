package edu.arelance.nube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantemalagaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantemalagaApplication.class, args);
	}

}
