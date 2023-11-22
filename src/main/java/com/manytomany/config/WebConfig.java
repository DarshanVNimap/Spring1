package com.manytomany.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CourseLogHandlerInterceptor())
				.order(2)
				.addPathPatterns("/api/course/**");
		registry.addInterceptor(new StudentLogHandlerInterceptor())
				.order(1)
				.addPathPatterns("/api/student/**");
	}
	
	
}
