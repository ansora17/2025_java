package com.study.spring.dao;

import java.io.Serializable;
import lombok.Data;

@Data
public class SimpleBbsDto implements Serializable {
	private int id;
	private String writer;
	private String title;
	private String location;
	private String content;
	private String imageUrl;
	

}
