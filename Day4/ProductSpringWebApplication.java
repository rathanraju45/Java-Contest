package com.telusko.ProductSpringWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ProductSpringWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductSpringWebApplication.class, args);
	}
	@Controller
	public class HomeController {

		@GetMapping("/")
		public String home() {
			return "index.html";
		}
	}

}
