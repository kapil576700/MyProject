package com.kapil.myProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.myProject.Entity.Student;
import com.kapil.myProject.Repository.StudentRepo;

@RestController
public class MyController {

	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/getStudents")
	@ResponseBody
	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	@PostMapping("/addStudents")
	public Student addStudents(@RequestBody Student student) {
		repo.save(student);
		return student;
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable("id") int id ) {
		Student s = repo.getById(id);
		repo.delete(s);
		return "deleted";
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		repo.save(student);
		return student;
	}

}

