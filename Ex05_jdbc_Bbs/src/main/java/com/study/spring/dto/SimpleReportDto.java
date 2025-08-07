package com.study.spring.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class SimpleReportDto {
		private int id;
		private String title;
		private String broad;
		private String asso;
		private LocalDateTime add_date;
		
		public String getFormattedDate() {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			return add_date != null ? add_date.format(formatter):"";
		}

}
