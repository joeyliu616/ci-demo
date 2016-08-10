package com.aoe.api.rest.test;

import com.aoe.api.rest.RestAPILauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Import(RestAPILauncher.class)
public class TestApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class,args);
	}
}