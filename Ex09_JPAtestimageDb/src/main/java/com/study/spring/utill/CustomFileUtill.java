package com.study.spring.utill;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

@Component
@Log4j2 //로그찍을때
public class CustomFileUtill {
	
	@Value("${file.upload-dir}") // 폴더만들기
	private String uploadDir;
	
	@PostConstruct //업로드할때 File, 다운로드할때는 resource
	public void init() {
		File dir = new File(uploadDir);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		uploadDir = dir.getAbsolutePath();
		
		
		System.out.println("-----------start---------------");
		log.info("-------------------start1------------------");
		log.info(uploadDir);
		
	}
	
	public List<String> uploadFile(List<MultipartFile> files) throws RuntimeException{ 
		
		if(files == null || files.size() == 0) {
			return null;
		}
		
		List<String> uploadNames = new ArrayList<>();
		
		
		for(MultipartFile file:files) {
			String savedName = UUID.randomUUID().toString()+ "_" + file.getOriginalFilename();
			Path savePath = Paths.get(uploadDir,savedName); //경로명
			
			try {
				Files.copy(file.getInputStream(),savePath);
				
				String contentType = file.getContentType();
				if(contentType != null && contentType.startsWith("image")) {
					
					Path thumbnailPath = Paths.get(uploadDir, "thumb_" + savedName);
					Thumbnails.of(savePath.toFile()).size(150, 150).toFile(thumbnailPath.toFile());
				}
				
				uploadNames.add(savedName);
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
				} //InputStream:바이트형태의 파일을 이동할때
		}
		return uploadNames;
	}

	// 함수를 만들어주는곳(유틸)
	public ResponseEntity<Resource> getFile(String fileName){
		
		//리소스에 파일을 담는것
		Resource resource = new FileSystemResource(uploadDir + File.separator+ fileName);
		if(!resource.exists()) {
			resource = new FileSystemResource(uploadDir +File.separator+ "default.png");
		}
		
		HttpHeaders headers =  new HttpHeaders(); 
		try {
			headers.add("content-type", Files.probeContentType(resource.getFile().toPath()));
		} catch (IOException e) {
			return ResponseEntity.internalServerError().build();
		}
		
		return  ResponseEntity.ok().headers(headers).body(resource); 
		//컨트롤러 fileUtill.getFile(fileName)에 담겨서 뱉어냄
	}

	
	//폴더에 있는 파일 삭제
	public void deleteFiles(List<String> fileNames) {
		if(fileNames == null || fileNames.size() ==0) {
			return;
		}
		
		fileNames.forEach((fileName)->{
			String thumbnailFile ="thumb_" + fileName;
			
			Path thumbnailPath = Paths.get(uploadDir,thumbnailFile);
			Path filePath = Paths.get(uploadDir,fileName);
			
			try {
				Files.deleteIfExists(filePath);
				Files.deleteIfExists(thumbnailPath);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		});
		
		
	}
}
