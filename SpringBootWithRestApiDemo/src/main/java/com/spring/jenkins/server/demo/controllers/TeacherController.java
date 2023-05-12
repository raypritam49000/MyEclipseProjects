package com.spring.jenkins.server.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jenkins.server.demo.dto.TeacherDto;
import com.spring.jenkins.server.demo.response.ApiResponse;
import com.spring.jenkins.server.demo.services.TeacherService;
import com.spring.jenkins.server.validator.ParameterValidator;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping
	public ResponseEntity<ApiResponse> createTeacher(@RequestBody TeacherDto teacherDto) {
		try {

			Boolean isValid = ParameterValidator.isValidForTeacher(teacherDto);

			if (!isValid) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("All Parameter are required", 400, false),
						HttpStatus.BAD_REQUEST);
			}

			TeacherDto createTeacher = teacherService.createTeacher(teacherDto);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher Created", 201, true, createTeacher),
					HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Server Error", 501, false),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> createTeacher(@PathVariable("id") Long id, @RequestBody TeacherDto teacherDto) {
		try {

			if (id < 0) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid Id", 400, false),
						HttpStatus.BAD_REQUEST);
			}

			Boolean isValid = ParameterValidator.isValidForTeacher(teacherDto);

			if (!isValid) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("All Parameter are required", 400, false),
						HttpStatus.BAD_REQUEST);
			}

			TeacherDto updateTeacher = teacherService.updateTeacher(id, teacherDto);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher Updated", 202, true, updateTeacher),
					HttpStatus.CREATED);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Data Not Found", 404, false), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Server Error", 501, false),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse> getAllTeachers() {
		try {

			List<TeacherDto> teachers = teacherService.findAllTeachers();

			if (teachers != null && !teachers.isEmpty() && teachers.size() > 0) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher List", 200, true, teachers),
						HttpStatus.OK);
			} else {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher Not Found", 404, Boolean.FALSE),
						HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Server Error", 501, false),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse> getTeacher(@PathVariable("id") Long id) {
		try {

			if (id < 0) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid Id", 400, false),
						HttpStatus.BAD_REQUEST);
			}

			TeacherDto teacherDto = this.teacherService.findTeacher(id);

			Boolean isValid = ParameterValidator.isValidForTeacher(teacherDto);

			if (!isValid) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("InValid Data", 400, false),
						HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher List", 200, true, teacherDto),
					HttpStatus.OK);

		} 
		catch (IllegalArgumentException e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Data Not Found", 404, false), HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Server Error", 501, false),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable("id") Long id) {
		try {

			if (id < 0) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid Id", 400, false),HttpStatus.BAD_REQUEST);
			}

			Boolean isDelete  = this.teacherService.deleteTeacher(id);

			if (isDelete) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher Deleted", 200, true),
						HttpStatus.OK);
			}
			else {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Data Not Found", 404, false),
						HttpStatus.NOT_FOUND);
			}

		} 
		catch (IllegalArgumentException e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Data Not Found", 404, false),
					HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Server Error", 501, false),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
