package com.spring.jenkins.server.demo.services;

import java.util.List;

import com.spring.jenkins.server.demo.dto.TeacherDto;

public interface TeacherService {
  public TeacherDto createTeacher(TeacherDto teacherDto);
  public TeacherDto updateTeacher(Long id,TeacherDto teacherDto);
  public List<TeacherDto> findAllTeachers();
  public TeacherDto findTeacher(Long id);
  public Boolean deleteTeacher(Long id);
}
