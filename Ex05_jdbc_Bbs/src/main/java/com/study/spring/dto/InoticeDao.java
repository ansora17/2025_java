package com.study.spring.dto;


import java.util.List;

public interface InoticeDao {
	
	//write - int
	public int writeDao(String title,String asso);

	public List<noticeDto> noticeDao(int page, int size);
	
	//view - SimpleReportDto 
	public noticeDto viewDao(String id);
	
	public int deleteDao(String id);

	public List<noticeDto> noticeDao();
	
	public Integer countDao();


}
