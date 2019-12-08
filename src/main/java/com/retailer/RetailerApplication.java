package com.retailer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetailerApplication {

    private final static Logger logger = LoggerFactory.getLogger(RetailerApplication.class);

    public static void main(String[] args) {
	SpringApplication.run(RetailerApplication.class, args);
	logger.debug("<--RetailerApplication Application Started-->");
    }

}
