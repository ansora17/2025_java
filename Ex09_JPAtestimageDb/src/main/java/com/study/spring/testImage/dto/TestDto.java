package com.study.spring.testImage.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
	
	private Long id;
	private String name;
	private String title;
	private String content;
	
	@Builder.Default //프론트에서 files라고 받아서 쓰면됌
	private List<MultipartFile> files = new ArrayList<>();
	
	@Builder.Default // null로 초기화
	private List<String> uploadedFileNames = new ArrayList<>();

}
