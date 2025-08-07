package com.study.spring.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class SimpleRoportDao implements ISimpleReportDao {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<SimpleReportDto> listDao(int page, int size) {
		System.out.println("-----------totallistDao 실행----------");
		int offset = (page - 1) * size;
		String query = "select * from simple_report order by id desc limit ? offset ? ";
		
		List<SimpleReportDto> list = template.query(
                query, new BeanPropertyRowMapper<>(SimpleReportDto.class),size ,offset );
		
		return list;
	}

	@Override
	public int deleteDao(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeDao(String title, String broad, String asso) {
		System.out.println("------------ writeDao 실행 ---------");
		String query = "insert into simple_report (title,broad,asso)" + 
						"values (?,?,?)";
		
		return template.update(query,title,broad,asso);
	}
	

	@Override
	public SimpleReportDto viewDao(String id) {
		System.out.println("--------------- viewDao 실행 ---------------");
		String query = "select * from simple_report where id = " + id ;
		SimpleReportDto view = template.queryForObject(
				query, new BeanPropertyRowMapper<>(SimpleReportDto.class)
				);
		
		return view;
	}

	@Override
	public List<SimpleReportDto> reportDao() {
		
		System.out.println("-----------reportDao 실행----------");
		String query = "select * from simple_report order by id desc limit 3";
		List<SimpleReportDto> report = template.query(
                query, new BeanPropertyRowMapper<>(SimpleReportDto.class) );
		
		return report;
	}

	@Override
	public Integer countDao() {
		System.out.println("--------------- countDao() 실행 ---------------");
		
		String query = "select count(*) from simple_report";
		Integer count = template.queryForObject(query, Integer.class);
		return count;
	}
}
