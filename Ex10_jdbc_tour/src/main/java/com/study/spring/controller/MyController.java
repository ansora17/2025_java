package com.study.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.dao.ISimpleBbsDao;
import com.study.spring.dao.SimpleBbsDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;

	@RequestMapping("/")
	public String root() {
		return "main";
	}

	@RequestMapping("/themeTour")
	public String themeTour() {
		return "bbs/themeTour";

	}

	@RequestMapping("/diner")
	public String diner() {
		return "bbs/diner";

	}

	@RequestMapping("/writeForm")
	public String writeForm() {
		return "bbs/writeForm";
	}

	@PostMapping(("/write"))
	public String write(HttpServletRequest request) {
		 String writer = request.getParameter("writer");
	     String title = request.getParameter("title");
	     String location = request.getParameter("addr");
	     String content = request.getParameter("body");
	     String imageUrl = request.getParameter("imageUrl");

	     dao.writeDao(writer, title, location,content,imageUrl);
	     
		
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("lists", dao.listDao());
        return "bbs/list"; // list.jsp 를 의미
    }
	
	@RequestMapping("/delete")
	public String Delete(
			HttpServletRequest request
			) {
		
		dao.deleteDao(request.getParameter("id"));
		
		return "redirect:list";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("id") String id, Model model) {
	    SimpleBbsDto dto = dao.viewDao(id);
	    model.addAttribute("dto", dto);
	    return "bbs/view"; // 👉 bbs/view.jsp로 이동

}
}
