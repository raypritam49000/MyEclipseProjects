package com.spring.jenkins.server.validator;

import com.spring.jenkins.server.demo.dto.TeacherDto;

public class ParameterValidator {

	public static Boolean isValidForTeacher(TeacherDto teacherDto) {
		return teacherDto != null && !teacherDto.getName().equals("") && teacherDto.getName() != null
				&& teacherDto.getCity() != null && !teacherDto.getCity().equals("") && teacherDto.getSalary() != null
				&& !teacherDto.getSalary().equals("") && teacherDto.getEmail() != null
				&& !teacherDto.getEmail().equals("");
	}
}
