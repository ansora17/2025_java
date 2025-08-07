package com.study.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao {
	
	@Autowired
	JdbcTemplate template;
	
	  @Override
	    public int writeDao(String writer, String title, String location, String content, String imageUrl) {
	        String query = "INSERT INTO tour_bbs (writer, title, location, content) VALUES (?, ?, ?, ?)";
	        return template.update(query, writer, title, location, content);
	    }

	    @Override
	    public List<SimpleBbsDto> listDao() {
	        String query = "SELECT * FROM tour_bbs ORDER BY id DESC";
	        return template.query(query, new BeanPropertyRowMapper<>(SimpleBbsDto.class));
	    }
	    
	    @Override
	    public int deleteDao(String id) {
			String query = "delete from tour_bbs where id = ? ";
			
			return template.update(query, Integer.parseInt(id));
		}
	    
	    @Override
	    public SimpleBbsDto viewDao(String id) {
	        String query = "SELECT * FROM tour_bbs WHERE id = " + id;
	        SimpleBbsDto view = template.queryForObject(
					query, new BeanPropertyRowMapper<>(SimpleBbsDto.class)
					);
	        return view;
	    }

	
	    
	}
