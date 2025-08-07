package com.study.spring.testImage.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestUpdateDto {
	private Long id;
	private String name;
	private String title;
	private String content;
	
	private List<String> updatedFileNames = new ArrayList<>();//업데이트된 파일
	private List<MultipartFile> files = new ArrayList<>(); //새로운 파일
	private List<String> newUploadedFileNames = new ArrayList<>(); //새로운 파일의 문자

}
