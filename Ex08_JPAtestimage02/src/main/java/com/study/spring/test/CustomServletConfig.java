package com.study.spring.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomServletConfig implements WebMvcConfigurer { //크로스오리진 해주는 클래스임

	@Override
	public void addCorsMappings(CorsRegistry registry) { //소스에서 오버라이드해서 해당 구문을 가져옴
		 registry.addMapping("/**") //노션에서 가져오는 부분
         .allowedOrigins("*")
         .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
         .maxAge(300)
         .allowedHeaders("Authorization", "Cache-Control", "Content-Type");
	}

}
