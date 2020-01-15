package com.spring5.practic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = {"com.spring5.practic.controllers"})

public class ServlateConfig implements WebMvcConfigurer{

	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		registry.jsp("WEB-INF/views/", ".jsp");
	}
	
	

}
