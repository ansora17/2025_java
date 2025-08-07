package com.study.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.study.spring.security.handler.APILoginFailHandler;
import com.study.spring.security.handler.APILoginSuccessHandler;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableMethodSecurity
@Log4j2 //콘솔에 띄우는용
public class CustomSecurityConfig {
	
	// 비밀번호를 암호화 해주는 코드(ex.사용자가 1234 비번을 넣으면 인코딩된 비번으로 변환해줌)
	@Bean
	public PasswordEncoder passworEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		log.info("---------------------security config----------------------"); //log4j2로 콘솔에 보임
		http.csrf(config -> config.disable()); 
		http.cors(config -> config.disable());
		
		http.sessionManagement(config->
			config.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		); //세션에 저장을 막음
		http.formLogin(config->{
			config.loginPage("/api/member/login");
			config.successHandler(new APILoginSuccessHandler()); //로그인 성공하면 new API~로 가라(토큰발행해주는곳)
			config.failureHandler(new APILoginFailHandler());
		}
		
		);
		
		
		
		return http.build();
	}

}
