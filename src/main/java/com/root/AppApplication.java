package com.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages= {"com.root.tasks","com.root.service.impl","com.root.configs"})
//@MapperScan("com.root.dao")
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
