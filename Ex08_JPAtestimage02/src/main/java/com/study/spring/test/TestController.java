package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //api만들어야해서 
public class TestController {
	
	@Autowired
	private TestService testService;
	
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@GetMapping("/")
	public String root() {
		return "hi";
	}
	
	//01
	//@PostMapping("/test")
	//public String testCreate(
			//@ModelAttribute TestDto request
			//) {
		//System.out.println(request.toString());
	//	return null;
	//}
	 
//	02
//	@PostMapping("/test")
//	public String testCreate(
//			@ModelAttribute TestDto request
//			) throws IllegalStateException, IOException { //에러나면 던지라는걸 추가해줌(안전하게 해달라)
//		System.out.println(request.toString());
//		testService.testCreate(request);
//		return null;
//	}
	
//03
	@PostMapping("/test")
	public ResponseEntity<Map<String,String>> testCreate(
			@ModelAttribute TestDto request
			) throws IllegalStateException, IOException {

		Map<String,String> response = new HashMap<>();
		
		try {
			testService.testCreate(request);
			response.put("message","ok");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (Exception e) {
			response.put("message","error");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}
	
	 //#1
//	@GetMapping("/test")
//	public List<TestEntity> testList(){
//		List<TestEntity> data = testService.findAll();
//		return data;
//	} 
	
	//#2
	//리스트에 있는 이미지를 배열형태로 만들어주는것01
//	@GetMapping("/test")
//	public List<TestResponseDto> testList(){
//		List<TestResponseDto> data = testService.findAll();
//		return data;
//	}
	
	//#3 페이지어블
	@GetMapping("/test")
	public ResponseEntity<Page<TestResponseDto>> testList(
			@PageableDefault(size=10,sort="id",direction =Sort.Direction.DESC)
			Pageable pageable){ //페이지어블 데이타 도메인으로 임폴트
		Page<TestResponseDto> data = testService.findAll(pageable);
		return ResponseEntity.ok(data);
	} 
	
	
	//http://localhost:8080/image/asdf;asdfsadf;a.jpg
	// react / <img src={`http://localhost:8080/images/thum_${item.filename}`}>
	
	@GetMapping("/images/{filename}")
	public ResponseEntity<Resource> getImage( 
			@PathVariable("filename") String filename
			) throws IOException{
		File file = new File(uploadDir + filename);  //파일이 있으면
		
		if(!file.exists()) { //파일이 있는지 없는지 검증 부분
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new FileSystemResource(file); //core.io
		
		String contentType = Files.probeContentType(file.toPath()); //파일의 타입을 자동으로 추축하는 코드
		System.out.println(contentType.toString());
		
		if(contentType == null) { //파일 타입을 찾이 못할경우 기본값 설정
			contentType = "application/octet-stream"; //바이너리 데이터용 기본타입을 주입
		}
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
			    .body(resource); 
	}
	
	// test/search?query=홍길동&page=0&size=10
	// 검색
	@GetMapping("/test/search")
	public ResponseEntity<Page<TestResponseDto>> testSearch(
			@RequestParam("query") String query,
			@PageableDefault(size=10,sort="id",direction =Sort.Direction.DESC)
			Pageable pageable){ //페이지어블 데이타 도메인으로 임폴트
		Page<TestResponseDto> data = testService.findAll(query,pageable); //컨트롤러에서 서비스로 작성
		return ResponseEntity.ok(data);
	} 
	
	@GetMapping("/test/{id}")
	public ResponseEntity<TestResponseDto> testViewId(@PathVariable("id") Long id) {
		Optional<TestEntity> optional = testService.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(new TestResponseDto(optional.get())); //optional.get은 위에 옵셔너을 가져오는거임
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/test/{id}")
	public ResponseEntity<String> testDelete(
			@PathVariable("id") Long id
			){
		
		boolean isDeleted = testService.testDelete(id);
		System.out.println("자료확인" + isDeleted);
		
		return ResponseEntity.status(HttpStatus.OK).body("데이터삭제완료");
	}
	
	
	
	
	
}

