package com.study.spring.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public  class noticeDao implements InoticeDao {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<noticeDto> noticeDao(int page, int size) {
		System.out.println("-----------noticelistDao 실행----------");
		int offset = (page - 1) * size;
		String query = "select * from simple_notice order by id desc limit ? offset ? ";
		
		List<noticeDto> notice = template.query(
                query, new BeanPropertyRowMapper<>(noticeDto.class),size ,offset );
		
		return notice;
	}

	@Override
	public int deleteDao(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int writeDao(String title,String asso) {
		System.out.println("------------ writeDao 실행 ---------");
		String query = "insert into simple_notice (title,asso)" + 
						"values (?,?)";
		
		return template.update(query,title,asso);
	}
	 

	@Override
	public noticeDto viewDao(String id) {
		System.out.println("--------------- viewDao 실행 ---------------");
		String query = "select * from simple_notice where id = " + id ;
		noticeDto view = template.queryForObject(
				query, new BeanPropertyRowMapper<>(noticeDto.class)
				);
		
		return view;
	}

	@Override
	public List<noticeDto> noticeDao() {
		
		System.out.println("-----------noticeDao 실행----------");
		String query = "select * from simple_notice order by id desc limit 3";
		List<noticeDto> notice = template.query(
                query, new BeanPropertyRowMapper<>(noticeDto.class) );
		
		return notice;
	}

	@Override
	public Integer countDao() {
		System.out.println("--------------- countDao() 실행 ---------------");
		
		String query = "select count(*) from simple_notice";
		Integer count = template.queryForObject(query, Integer.class);
		return count;
	}


}