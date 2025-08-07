package com.study.spring.test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;



@Service
public class TestMapService {
	
	@Autowired
	public TestMapRepository testMapRepository;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	//dto에서 entity로 만들어서 db에 넣어줌
	public void testMapCreate(TestMapDto testMapDto) {
		TestMapEntity createData = new TestMapEntity();
		createData.setTitle(testMapDto.getTitle());
		createData.setName(testMapDto.getName());
		createData.setContent(testMapDto.getContent());
		createData.setStartdate(LocalDateTime.now());
		
		MultipartFile fileImage = testMapDto.getFiles();
		
		if(fileImage !=null && !fileImage.isEmpty()) {
			System.out.println("파일이름 :" + fileImage.getOriginalFilename());
			System.out.println("파일크기 :" + fileImage.getSize() );
			System.out.println("파일타입 :" + fileImage.getContentType());
			
			try {
				
			//폴더생성
			File folder = new File(uploadDir);
			if(!folder.exists()) {
				folder.mkdir();
			}
			
			//파일이름처리
			String originalName = fileImage.getOriginalFilename();
			String uuid = UUID.randomUUID().toString();
			String extension = originalName.substring(originalName.lastIndexOf("."));
			String storeFileName = uuid  + extension;
			String thumbnailFileName = "thumb_" + uuid +extension;
			
			System.out.println("파일명생성 :" + storeFileName );
			
			//원본파일저장
			File originFile = new File(uploadDir+File.separator +storeFileName );
			fileImage.transferTo(originFile);
			
			File thumbnailFile = new File(uploadDir+File.separator +thumbnailFileName);
			Thumbnails.of(originFile).size(150, 150).toFile(thumbnailFile);
			
			
			// createData 넣기 
			createData.setImageFileNames(storeFileName);
			}catch(Exception e){
			}
		}else {
			System.out.println("파일이없네요!");
		}
		System.out.println("entity:" + createData.toString());
		//db저장 완료
		testMapRepository.save(createData);
	}

}
