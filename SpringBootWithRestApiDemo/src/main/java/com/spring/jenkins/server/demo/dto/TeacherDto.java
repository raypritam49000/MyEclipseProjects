package com.spring.jenkins.server.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
	private Long id;
	private String name;
	private String city;
	private String salary;
	private String email;
	
	
	public TeacherDto(String name, String city, String salary, String email) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
		this.email = email;
	}
	
}
