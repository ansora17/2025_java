package com.study.spring.test;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="testimage")
@Data //롬북에서 가져오는것
@NoArgsConstructor 
public class TestEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //오토인크리먼트
	private Long id;
	
	private String title;
	private String name;
	private String content;
	private LocalDateTime localdate;
	private String imageFileNames;

}
