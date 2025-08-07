package com.study.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMapContoller {
	
	@Autowired
	public TestMapService testMapService;
	
	@GetMapping("/")
	private String root() {
		return "sora";
	}
	
	@PostMapping("/test")//TestMapDto 객체에 값이 자동으로 바인딩(@Model...)
	public void testCreate(@ModelAttribute TestMapDto testMapDto) {
		testMapService.testMapCreate(testMapDto);
		
	}

}
