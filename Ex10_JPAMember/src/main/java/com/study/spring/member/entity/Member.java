package com.study.spring.member.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "memberRoleList")
//@ToString
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String password;
	private String nickname;
	private boolean social; //카카오등 소셜에 로그인 되어있냐(참,거짓)
	
	@ElementCollection(fetch = FetchType.LAZY )
	@Builder.Default 
	private List<MemberRole> memberRoleList = new ArrayList<>(); //원투매니를 생성(memberRole)
	
	public void addRole(MemberRole memberRole) {
		memberRoleList.add(memberRole);
	}
	

}
