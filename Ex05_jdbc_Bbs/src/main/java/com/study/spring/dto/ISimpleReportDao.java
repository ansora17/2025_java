package com.study.spring.dto;

import java.util.List;



public interface ISimpleReportDao {
	
	//write - int
	public int writeDao(String title,String broad,String asso);

	public List<SimpleReportDto> listDao(int page, int size);
	
	//view - SimpleReportDto 
	public SimpleReportDto viewDao(String id);
	
	public int deleteDao(String id);

	public List<SimpleReportDto> reportDao();
	
	public Integer countDao();

}
