package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestImageController {
	
	@Autowired
	public TestImageService testImageService;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	

	@GetMapping("/")
	public String root() {
		return "hi spring";
	}
	
	@PostMapping("/test") //이미지넣을때 필요함 (폼데이타)
	public void testCreate(@ModelAttribute TestImageDto testImageDto) {
		testImageService.testImageCreate(testImageDto);
	}
	
	// http://localhost:8080/images/thunb_28cee....jpg 
	// react <img src={`http://localhost:8080/images/thunb_28cee....jpg`}>
	@GetMapping("images/{filename}") //Resource(core.io) // 이미지파일 출력
	public ResponseEntity<Resource> getImage(@PathVariable("filename") String filename)
			throws IOException {
		
		File file = new File(uploadDir + filename);
		//System.out.println(file.toString());
		
		if(!file.exists()) { 
			System.out.println("파일이없어");
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new FileSystemResource(file); //객체(이미지파일을)를 Resource 타입으로 바꾸는 작업
		String contentType = Files.probeContentType(file.toPath()); //파일의 타입을 자동으로 추축하는 코드
		System.out.println(contentType.toString());
		
		if(contentType == null) { //파일 타입을 찾이 못할경우 기본값 설정
			contentType = "application/octet-stream"; //바이너리 데이터용 기본타입을 주입
		}
				
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
			    .body(resource);
	}  
	
//	@GetMapping("/test")
//	public List<TestImageEntity> testLists(){
//		List<TestImageEntity> data =testImageService.findAll();
//		return data;
//	}
	
	@GetMapping("/test") //이미지리스트 조회
	public ResponseEntity<Page<TestImageEntity>>  testLists(
			@PageableDefault(size=3,sort="id", direction = Sort.Direction.DESC)Pageable pageable){
		Page<TestImageEntity> data =testImageService.findAll(pageable);
		return ResponseEntity.ok(data);
		
	}
}
