package com.spring.jenkins.server.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jenkins.server.demo.dto.TeacherDto;
import com.spring.jenkins.server.demo.entity.Teacher;
import com.spring.jenkins.server.demo.repository.TeacherRepository;
import com.spring.jenkins.server.demo.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TeacherDto createTeacher(TeacherDto teacherDto) {
		Teacher teacher = this.modelMapper.map(teacherDto, Teacher.class);
		Teacher createTeacher = teacherRepository.save(teacher);
		return this.modelMapper.map(createTeacher, TeacherDto.class);
	}

	@Override
	public TeacherDto updateTeacher(Long id, TeacherDto teacherDto) {
		Optional<Teacher> existingTeacher = this.teacherRepository.findById(id);
		if (existingTeacher.isPresent()) {
			existingTeacher.get().setCity(teacherDto.getCity());
			existingTeacher.get().setEmail(teacherDto.getEmail());
			existingTeacher.get().setName(teacherDto.getName());
			existingTeacher.get().setSalary(teacherDto.getSalary());
			Teacher updateTeacher = teacherRepository.save(existingTeacher.get());
			return this.modelMapper.map(updateTeacher, TeacherDto.class);
		} else {
			throw new IllegalArgumentException("Teacher does not found with " + id);
		}
	}

	@Override
	public List<TeacherDto> findAllTeachers() {
		List<Teacher> teacherList = this.teacherRepository.findAll();
		List<TeacherDto> teacherDtos = teacherList.stream().map(teacher -> modelMapper.map(teacher, TeacherDto.class))
				.collect(Collectors.toList());
		return teacherDtos;
	}

	@Override
	public TeacherDto findTeacher(Long id) {
		Optional<Teacher> existingTeacher = this.teacherRepository.findById(id);
		if (existingTeacher.isPresent()) {
			return this.modelMapper.map(existingTeacher.get(), TeacherDto.class);
		} else {
			throw new IllegalArgumentException("Teacher does not found with " + id);
		}

	}

	@Override
	public Boolean deleteTeacher(Long id) {
		Optional<Teacher> existingTeacher = this.teacherRepository.findById(id);
		if (existingTeacher.isPresent()) {
			this.teacherRepository.delete(existingTeacher.get());
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
