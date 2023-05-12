package com.spring.jenkins.server.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.spring.jenkins.server.demo.entity.Teacher;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;

	@Test
	@DisplayName("It should return the teacher list with size of 3")
	public void getAllTeachers() {
		Teacher maths = new Teacher("Pritam Ray", "Ropar", "45000", "raypritam49000@gmail.com");
		Teacher hindi = new Teacher("Omi Verma", "Rail", "50000", "raypritam49000@gmail.com");
		Teacher punjabi = new Teacher("Pritam Ray", "Ropar", "60000", "raypritam49000@gmail.com");

		this.teacherRepository.save(punjabi);
		this.teacherRepository.save(hindi);
		this.teacherRepository.save(maths);

		List<Teacher> list = teacherRepository.findAll();
		System.out.println(list.size());
		System.out.println(list);

		assertNotNull(list);
		assertThat(list).isNotNull();
		assertEquals(3, list.size());
	}

	@Test
	@DisplayName("It should save the teacher to the database")
	public void saveTeacher() {
		Teacher maths = new Teacher("Pritam Ray", "Ropar", "45000", "raypritam49000@gmail.com");
		Teacher createMaths = this.teacherRepository.save(maths);
		assertNotNull(createMaths);
		assertThat(createMaths.getId()).isNotEqualTo(null);
	}

	@Test
	@DisplayName("It should return the teacher Object")
	public void getTeacherById() {
		Teacher maths = new Teacher("Pritam Ray", "Ropar", "45000", "raypritam49000@gmail.com");
		Teacher createMaths = this.teacherRepository.save(maths);

		Teacher mathsNew = this.teacherRepository.findById(createMaths.getId()).get();

		assertNotNull(mathsNew);
		assertEquals("Pritam Ray", mathsNew.getName());
		assertEquals("Ropar", mathsNew.getCity());
		assertEquals("45000", mathsNew.getSalary());
		assertEquals("raypritam49000@gmail.com", mathsNew.getEmail());
	}
	
	@Test
	@DisplayName("It should delete the existing teacher")
	public void deleteTeacher() {
		
		Teacher maths = new Teacher("Pritam Ray", "Ropar", "45000", "raypritam49000@gmail.com");
		Teacher hindi = new Teacher("Omi Verma", "Rail", "50000", "raypritam49000@gmail.com");
		Teacher punjabi = new Teacher("Pritam Ray", "Ropar", "60000", "raypritam49000@gmail.com");

		this.teacherRepository.save(punjabi);
		this.teacherRepository.save(hindi);
		this.teacherRepository.save(maths);
		
		
		this.teacherRepository.delete(maths);
		
		List<Teacher> list = teacherRepository.findAll();
		
		Optional<Teacher> exitingTeacher = this.teacherRepository.findById(maths.getId());
		
		assertEquals(2, list.size());
		assertThat(exitingTeacher).isEmpty();
		
	}
	
	@Test
	@DisplayName("It should update the teacher")
	public void updateTeacher() {
		
		Teacher maths = new Teacher("Pritam Ray", "Ropar", "45000", "raypritam49000@gmail.com");
		Teacher hindi = new Teacher("Omi Verma", "Rail", "50000", "raypritam49000@gmail.com");
		Teacher punjabi = new Teacher("Pritam Ray", "Ropar", "60000", "raypritam49000@gmail.com");

		Teacher punjbaiCreated = this.teacherRepository.save(punjabi);
		Teacher hindiCreated = this.teacherRepository.save(hindi);
		Teacher mathsCreated = this.teacherRepository.save(maths);
		
		Teacher existingTeacher =this.teacherRepository.findById(mathsCreated.getId()).get();
		 existingTeacher.setCity("Mohali");
		 existingTeacher.setName("Raj Kumar");
		 
		 Teacher updateMaths = this.teacherRepository.save(existingTeacher);
		
		assertEquals("Mohali", updateMaths.getCity());
		assertEquals("Raj Kumar", updateMaths.getName());
	}

}
