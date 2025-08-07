package com.study.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		
		return "model";
	}
	
	@RequestMapping("/index")
	public String index(
			HttpServletRequest httpServletRequest,
			Model model) {
		String id = httpServletRequest.getParameter("id");
		String name = httpServletRequest.getParameter("name");
		
	}

}
