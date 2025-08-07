package com.study.spring.test;

import java.io.File;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	@Autowired
	public ImageRepository ImageRepository;
	
	@Value("${file.upload-dir}")
	private String uploadDir;

	public void imageCreate(ImageDto imageDto) {
		ImageEntity createData = new ImageEntity();
		createData.setName(imageDto.getName());
		createData.setTitle(imageDto.getTitle());
		createData.setContent(imageDto.getContent());
		createData.setStartdate(LocalDateTime.now());
		
		MultipartFile fileImage = imageDto.getFiles();
		
		
		if(fileImage != null && !fileImage.isEmpty()) {
			System.out.println("파일이름 : " + fileImage.getOriginalFilename());
			System.out.println("파일크기 : " + fileImage.getSize());
			System.out.println("파일타입 : " + fileImage.getContentType());
			
			
			File folder = new File(uploadDir);
			if(!folder.exists()) {
				folder.mkdir();
			}
	}

	

	}
}
