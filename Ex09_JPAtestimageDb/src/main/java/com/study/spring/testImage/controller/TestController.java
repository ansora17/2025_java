package com.study.spring.testImage.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.study.spring.testImage.dto.TestDto;
import com.study.spring.testImage.dto.TestResponseDto;
import com.study.spring.testImage.dto.TestUpdateDto;
import com.study.spring.testImage.service.TestService;
import com.study.spring.utill.CustomFileUtill;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/test")
@Log4j2
public class TestController {
	
	@Autowired
	private CustomFileUtill fileUtill;
	
	
	@Autowired
	private TestService testService;
	
	@PostMapping("/")
	public Map<String,String > testPost(@ModelAttribute TestDto testDto) {
		System.out.println("post" + testDto);
		
		List<MultipartFile> files = testDto.getFiles(); //파일이 여러개면 리스트로 변형
		List<String> uploadedFileNames = fileUtill.uploadFile(files) ; //문자형태로 변형/파일이름을 뱉어내고 폴더에 저장
		
		testDto.setUploadedFileNames(uploadedFileNames); //testDto에 넣음
		
		log.info("filenames :" + uploadedFileNames);
		testService.testInsert(testDto);
		return Map.of("result","success");
		
	}

	
	@GetMapping("/images/{fileName}")
	public ResponseEntity<Resource> viewFiles(@PathVariable("fileName") String fileName) {
		return fileUtill.getFile(fileName);
	}
	
	
//	@GetMapping("/")
//	public ResponseEntity<Map<String, Object>> testListView(){
//		List<TestResponseDto> testList = testService.getList();
//		return ResponseEntity.ok(Map.of("result","success","data",testList)); //(키,밸류)
//	}
	
	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> testList(
			@PageableDefault(size=8, sort="id" , direction = Sort.Direction.DESC)
			Pageable pageable){
		Page<TestResponseDto> testList = testService.getList(pageable);
		return ResponseEntity.ok(Map.of("result","success","data",testList));
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<Map<String,Object>> testListView(
			@PathVariable("id") Long id
			){
		
		TestResponseDto test = testService.getById(id);
		return ResponseEntity.ok(Map.of("result","success","view",test)); //(키,밸류)
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> testDelete(
			@PathVariable("id") Long id
			){
		boolean isDeleted = testService.testDelete(id);
		if(isDeleted) {
			return ResponseEntity.ok(Map.of("result","success","deletedId",id));
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Map.of("result","fail","message","해당자료는 없네요"));
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, Object>> updatePost(
			@PathVariable("id") Long id,
			@ModelAttribute TestUpdateDto dto
			){
		
		//01 업로드된 파일을 끌고옴
		List<String> uploadedFileNames = new ArrayList<>();
		//새로운 파일을 가져옴(getFiles)
		if(dto.getFiles() != null && dto.getFiles().isEmpty()) {
			uploadedFileNames = fileUtill.uploadFile(dto.getFiles());
			dto.setNewUploadedFileNames(uploadedFileNames);
			//멀티파트파일의 네임즈를 업로디드파일네임즈에 넣음(파일의 네임을 넣음)
			
			
		//02 전체에 이미지의 이름만 넣는거임, 파일을 넣는게 아님, String만 존재
		List<String> totalUpdatedFilenames = new ArrayList<>();
		if(dto.getUpdatedFileNames() != null) {
			totalUpdatedFilenames.addAll(dto.getUpdatedFileNames()); //원래 파일도 넣고
		}
		totalUpdatedFilenames.addAll(uploadedFileNames);
		
		//최종물을 담기만 한거임 dto에
		dto.setUpdatedFileNames(totalUpdatedFilenames);
		
		testService.updateTest(id,dto);
			
		}
		return ResponseEntity.ok(Map.of("result","success","id",id));
	}
	
	
	
	
}
