package com.study.spring.testImage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.spring.testImage.dto.TestDto;
import com.study.spring.testImage.dto.TestResponseDto;
import com.study.spring.testImage.dto.TestUpdateDto;
import com.study.spring.testImage.entity.TestEntity;
import com.study.spring.testImage.entity.TestImage;
import com.study.spring.testImage.repository.TestRepository;
import com.study.spring.utill.CustomFileUtill;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private CustomFileUtill fileUtil;

	public void testInsert(TestDto dto) {
		
//		TestEntity test = new TestEntity();
//		test.setName(dto.getName());
//		test.setTitle(dto.getTitle());
//		test.setContent(dto.getContent());
		//인스턴스 생성에서 세터로 원래는 하는데
		
		//빌더로 작성함
		TestEntity test = TestEntity.builder()
				.title(dto.getTitle())
				.name(dto.getName())
				.content(dto.getContent())
				.build();
		
		
		List<String> uploadedFileNames = dto.getUploadedFileNames();
		if(uploadedFileNames != null) {
			for(String fileName:uploadedFileNames) {
				test.addImageString(fileName);
				log.info("-------------file name------------------");
				
			}
		}
		
		testRepository.save(test);
		
	}
	
//	public List<TestResponseDto> getList() {
//	//TestEntity -> TestResponseDto (entity->dto)
//		List<TestEntity> tests = testRepository.findAll();
//		
//		List<TestResponseDto> resultList = new ArrayList<>();
//		
//		for(TestEntity test:tests) {
//			
//			List<String> imageNames = new ArrayList<>();
//			
//			for(TestImage image:test.getImageList()) {
//				imageNames.add(image.getStoredName());
//			}
//			
//			TestResponseDto dto = new TestResponseDto(
//					test.getId(),
//					test.getName(),
//					test.getContent(),
//					test.getTitle(),
//					imageNames
//					);	
//			resultList.add(dto);
//		}
//	
//		return resultList;
//	}
	
public List<TestResponseDto> getList(){
		
		List<TestEntity> tests = testRepository.findAll();
		
//		List<TestResponseDto> resultList = tests.stream().map().toList();
		List<TestResponseDto> resultList = tests.stream()
				.map(test->{
					List<String> imageNames = test.getImageList().stream()
							.map(TestImage::getStoredName)
							.toList();
					
					return new TestResponseDto(
							test.getId(),
							test.getTitle(),
							test.getName(),
							test.getContent(),
							imageNames
							);
				})
				.toList();
		
		return resultList;
	
	

}

	public Page<TestResponseDto> getList(Pageable pageable) { //페이지가 맵을 지원해서 스트림을,투리스트 안써두됌
		Page<TestEntity> tests = testRepository.findAll(pageable);
		
//		List<TestResponseDto> resultList = tests.stream().map().toList();
		Page<TestResponseDto> resultList = tests
				.map(test->{
					List<String> imageNames = test.getImageList().stream()
							.map(TestImage::getStoredName)
							.toList();
					
					return new TestResponseDto(
							test.getId(),
							test.getTitle(),
							test.getName(),
							test.getContent(),
							imageNames
							);
				});
		
		return resultList;
}

	public TestResponseDto getById(Long id) {
		TestEntity test = testRepository.findById(id)
				.orElseThrow(()->new RuntimeException("not found"));
		
		List<String> imageNames = test.getImageList().stream()
				.map(TestImage::getStoredName).toList();
		
		
		return new TestResponseDto(
				test.getId(),
				test.getName(),
				test.getTitle(),
				test.getContent(),
				imageNames);
				
	}

	
	public boolean testDelete(Long id) {
	Optional<TestEntity> testId = testRepository.findById(id);
	
	if(testId.isPresent()) {
	   TestEntity test = testId.get(); //폴더의 파일 이름을 가져와서 삭제해야함
		log.info("-------------id-------------" + id);
		
		 List<String> storedNames = test.getImageList().stream()
				 .map(TestImage::getStoredName)
				 .toList();
		 
		 fileUtil.deleteFiles(storedNames);
		
		testRepository.delete(test); //엔티티에 있는 파일 삭제
			return true;
	}else {
		return false;
	}
	
	}

	//타이틀,콘텐트,네임만 수정 저장
	public void updateTest(Long id, TestUpdateDto dto) {
		 TestEntity test = testRepository.findByIdWidthImages(id).orElseThrow();
		 
		 test.setTitle(dto.getTitle());
		 test.setContent(dto.getContent());
		 test.setName(dto.getName());
		 
		 log.info("원본이미지 목록", test.getImageList().size());
		 test.getImageList().forEach(img -> log.info(" - {}",img.getStoredName() ));
		 
		//기존 db 저장된 파일명
			List<String> currentDBFiles = test.getImageList().stream()
					.map(TestImage::getStoredName)
					.toList();
			
			List<String> updatedFileNames = dto.getUpdatedFileNames();
			
			List<String> toDelete = currentDBFiles.stream()
					.filter(oldName -> !updatedFileNames.contains(oldName))
					.toList();
			
			test.getImageList().removeIf(img -> toDelete.contains(img.getStoredName()));
			
			fileUtil.deleteFiles(toDelete);
			
			if(dto.getNewUploadedFileNames() != null) {
				for(String fileName:dto.getNewUploadedFileNames()) {
					test.addImageString(fileName);
				}
			}
		 
		 testRepository.save(test);
		
	}
}
