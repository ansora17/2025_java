package com.study.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity

@Getter
@NoArgsConstructor //디폴트컨스트럭져 생성(아무것도없는)
@AllArgsConstructor //다들어가있는 컨스트럭쳐
public class UserEntity {
	
	@Id //프라이머리키
	@GeneratedValue(strategy = GenerationType.IDENTITY) //오토인크리먼트 설정
	private Long id;
	
	private String name;
	private String email;
	private Integer age;
	private String password;
	
	
	public void changeNamePassAge(String name, String password, Integer age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	
	

}
