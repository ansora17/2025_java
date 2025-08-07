package com.study.spring.contoroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import com.study.spring.dto.ISimpleReportDao;
import com.study.spring.dto.InoticeDao;
import com.study.spring.dto.SimpleReportDto;
import com.study.spring.dto.noticeDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Mycontroller {
	
	@Autowired
	ISimpleReportDao dao;
	
	@Autowired
	InoticeDao dao2;

//	@RequestMapping("/")
//	public @ResponseBody String root() {
//		return "jdbc template";
//	}
	
	@RequestMapping("/")
	public String root(Model model) {
		
		model.addAttribute("report", dao.reportDao() );
		model.addAttribute("notice",dao2.noticeDao());
		
	
		return "index";
	}
	
	@RequestMapping("/reportwrite")
	public String write(HttpServletRequest request, Model model) {
		String title = request.getParameter("title");
		String broad = request.getParameter("broad");
		String asso = request.getParameter("asso");
	
		dao.writeDao(title,broad, asso);
		
		System.out.println(title + broad + asso);
		return "redirect:list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "bbs/writeForm";
	}
	
	@RequestMapping("/reportview")
	public String view(
			HttpServletRequest request,
			Model model
			) {
		String sId = request.getParameter("id");
		
		model.addAttribute("dto",dao.viewDao(sId));
		
		return "bbs/view";
	}
	
	
	
	//localhost:8080/list?page=2&size=10 페이지와 사이즈는 문자값이다
	@RequestMapping("/list")
	public String report(
			HttpServletRequest request,
			Model model) {
		
		
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		
		
		int page = (pageParam != null && !pageParam.isEmpty() ) ? Integer.parseInt(pageParam):1; 
		int size = (sizeParam != null && !sizeParam.isEmpty() ) ? Integer.parseInt(sizeParam):10;
		

		
		int totalCount = dao.countDao();
		
		int totalPages = (int)Math.ceil((double) totalCount / size);
		
		List<SimpleReportDto> list = dao.listDao(page,size);
				
				
				
		model.addAttribute("lists",list);
		
		model.addAttribute("totalCount",totalCount);
		
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
				
				
				
		return "bbs/list";
	}
	
	@RequestMapping("/notice")
	public String notice(
			HttpServletRequest request,
			Model model) {
		
		
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		
		
		int page = (pageParam != null && !pageParam.isEmpty() ) ? Integer.parseInt(pageParam):1; 
		int size = (sizeParam != null && !sizeParam.isEmpty() ) ? Integer.parseInt(sizeParam):10;
		

		
		int totalCount = dao.countDao();
		
		int totalPages = (int)Math.ceil((double) totalCount / size);
		
		List<noticeDto> notice = dao2.noticeDao(page,size);
				
				
				
		model.addAttribute("notices",notice);
		
		model.addAttribute("totalCount",totalCount);
		
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
				
				
				
		return "bbs/notice";
	}

	
	// http://localhost:8080/delete?id=1
		@RequestMapping("/delete")
		public String Delete(
				HttpServletRequest request
				) {
			
			dao.deleteDao(request.getParameter("id"));
			
			return "redirect:list";
		}
		
		@RequestMapping("/lg")
		public String lgPage(Model model){
			model.addAttribute("title","재단소개");
			model.addAttribute("report",dao.reportDao());
				
			return "bbs/LG";
		}
		}
