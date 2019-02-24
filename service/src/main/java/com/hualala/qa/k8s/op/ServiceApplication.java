package com.hualala.qa.k8s.op;

import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.hualala.qa.k8s.op"})
public class ServiceApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(ServiceApplication.class);

	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	@Configuration
	@MapperScan(basePackages = {"com.hualala.qa.k8s.op.model.gen.dao"}, sqlSessionFactoryRef="sqlSessionFactoryBean")
	class DBConfig{}
}
