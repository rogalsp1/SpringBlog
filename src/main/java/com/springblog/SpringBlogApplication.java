package com.springblog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBlogApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBlogApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Spring Blog");
		SpringApplication.run(SpringBlogApplication.class, args);

	}
}
