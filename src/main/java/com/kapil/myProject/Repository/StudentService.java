package com.kapil.myProject.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kapil.myProject.Entity.Student;

@Service
public class StudentService {
	@Autowired
	StudentRepo repo;

	public List<Student> findStudents(){
		return repo.findAll();

	}
	
	public Student saveStudent(Student student) {
		repo.save(student);
		return student;
		
	}
	
	public String deleteStudent(int id ) {
		Student s = repo.getById(id);
		repo.delete(s);
		return "deleted";
	}
	
	public Student updateStudent(Student student) {
		repo.save(student);
		return student;
	}
}
