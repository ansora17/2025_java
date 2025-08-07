package com.study.spring.test;


import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TestMapDto {
	private String title;
	private String name;
	private String content;
	private MultipartFile files;

}
