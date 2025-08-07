package com.study.spring.bean;

public class Member {
	private String name;
	private String nickname;
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
