package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class TestService {

	
	@Autowired
	private TestRepository testRepository;
	
    @Value("${file.upload-dir}")
	private String uploadDir;
	
	public void testCreate(TestDto dto) throws IllegalStateException, IOException {
		File dir = new File(uploadDir); 
		if(!dir.exists()) {
			dir.mkdir();
		} //폴더 생성단계

		
		List<String> savedFileNames = new ArrayList<>();
		
		if(dto.getFiles()!= null && !dto.getFiles().isEmpty()) { //for(변수명:배열)
			for(MultipartFile file:dto.getFiles()) {
				if(file != null && !file.isEmpty()) {
					try {
						//1.파일이름처리
						String originalName = file.getOriginalFilename();
						String uuid = UUID.randomUUID().toString();
						String extension = originalName.substring(originalName.lastIndexOf("."));
						String storeFileName = uuid + extension;
						String thumbnailFileName = "thumb_" + uuid + extension;
						
						//2.파일업로드/썸네일업로드
						File saveFile = new File(uploadDir+storeFileName);
						file.transferTo(saveFile);
						
						File thumbnailFile = new File(uploadDir+thumbnailFileName);
						Thumbnails.of(saveFile).size(150, 150).toFile(thumbnailFile);
						
						//3.변경이름 저장
						savedFileNames.add(storeFileName);
						
						
					}catch(Exception e){
						e.printStackTrace();
						throw new RuntimeException("파일저장 도는 썸네일 생성 오류 발생");
					}
				}
			}
		}//if end
		
		System.out.println(savedFileNames.toString());
		
		//엔티티로 dto를 가져와서 저장
		TestEntity entity = new TestEntity();
		entity.setTitle(dto.getTitle());
		entity.setName(dto.getName());
		entity.setContent(dto.getContent()); 
		entity.setLocaldate(LocalDateTime.now());
		entity.setImageFileNames(String.join(",", savedFileNames));
		
		//저장
		testRepository.save(entity); 
		
	}

	//리스트에 있는 이미지를 배열형태로 만들어주는것02
//	public List<TestResponseDto> findAll() {
//		
//		return testRepository.findAll().stream()
//				.map(entity -> new TestResponseDto(entity))
//				.collect(Collectors.toList());
//	}
	
	public Page<TestResponseDto> findAll(Pageable pageable) { 
		
		return testRepository.findAll(pageable)
				.map(TestResponseDto::new);
	}

	public Page<TestResponseDto> findAll(String query, Pageable pageable) { //서비스에서 레파짓토리로 작성
		 
		return testRepository.findByTitleContainingIgnoreCase(query,pageable);
	}

	public Optional<TestEntity> findById(Long id) {
		
		return testRepository.findById(id);
	}

	public boolean testDelete(Long id) {
		
		Optional<TestEntity> optional = testRepository.findById(id);
		if(optional.isPresent()) {
			TestEntity entity = optional.get();
			System.out.println(entity.toString());
			testRepository.deleteById(id);
			return true;
		}else {
			System.out.println("데이터가 없어요");
			return false;
			
		}
		
		
	}

	
	

}
