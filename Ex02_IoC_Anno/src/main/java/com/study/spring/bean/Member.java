package com.study.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Member {
	@Value("최준")
	private String name;
	
	@Value("게임중독자")
	private String nickname;
	
	@Autowired
	@Qualifier("printerA")
	private Printer printer; //private때문에 게터세터 필요함 클래스안에서만 적용되기때문에 필요함
	
	
	public Member() {}
	

		public Member(String name, String nickname, Printer printer) {
			this.name = name;
			this.nickname = nickname;
			this.printer = printer;
		}
		
		
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void print() {
		printer.print("hello " + name + " : " + nickname);
	
	}
}
