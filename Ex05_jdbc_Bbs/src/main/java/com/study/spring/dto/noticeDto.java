package com.study.spring.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
	public class noticeDto {
		private int id;
		private String title;
		private String asso;
		private LocalDateTime add_date2;
		
		public String getFormattedDate() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			return add_date2 != null ? add_date2.format(formatter):"";
		}

}

