package com.hualala.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.hualala.api"})
public class ServiceApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(ServiceApplication.class);

	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}


	@Configuration
	@MapperScan(basePackages = {"com.hualala.api.dao"}, sqlSessionFactoryRef="platformSessionFactoryBean")
	class platformDBConfig{}


}
