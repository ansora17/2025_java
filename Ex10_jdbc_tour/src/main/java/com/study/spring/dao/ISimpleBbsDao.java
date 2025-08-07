package com.study.spring.dao;

import java.util.List;

public interface ISimpleBbsDao {
	
	//write - int
		public int writeDao(String writer,String title,String location,String content, String imageUrl  );
		public List<SimpleBbsDto> listDao();
		public int deleteDao(String id);
		public SimpleBbsDto viewDao(String id);
	

}
