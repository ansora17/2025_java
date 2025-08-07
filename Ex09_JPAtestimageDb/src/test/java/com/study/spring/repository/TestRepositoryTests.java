package com.study.spring.repository;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.testImage.entity.TestEntity;
import com.study.spring.testImage.repository.TestRepository;

@SpringBootTest
public class TestRepositoryTests {
	
	@Autowired
	private TestRepository testRepository;
	
	@Test
	public void testInsert() {
		TestEntity test = TestEntity.builder()
				.name("안소라")
				.title("안녕")
				.content("testcontent")
				.build();
				
		test.addImageString(UUID.randomUUID()+ "_" + "test1.jpg");
		test.addImageString(UUID.randomUUID()+ "_" + "test2.jpg");
		testRepository.save(test);
		
	}

}
