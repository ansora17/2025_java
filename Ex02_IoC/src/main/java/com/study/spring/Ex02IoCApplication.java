package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring.bean.Config;
import com.study.spring.bean.Member;

@SpringBootApplication //어노테이션 :빈에 등록을 한다 ctrl + space
public class Ex02IoCApplication {

	public static void main(String[] args) {
//		SpringApplication.run(Ex02IoCApplication.class, args);
		
		//IoC 컨테이너 생성

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class); //객체를 생성해서 창고에 넣는다 context라는 창고
		
		Member member1 = (Member)context.getBean("member1");
		member1.print();
		
		Member member2 = context.getBean("hello",Member.class);
		member2.print();
	}
	

}
