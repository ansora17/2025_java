package com.study.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
	
    @Autowired
	public ImageService ImageService;
    
    @GetMapping("/")
    public String root() {
    	return "hello spring";
    }
    
    @PostMapping("/test")
    public void testCreate(@ModelAttribute ImageDto imageDto) {
    	ImageService.imageCreate(imageDto);
    	
    }
}
