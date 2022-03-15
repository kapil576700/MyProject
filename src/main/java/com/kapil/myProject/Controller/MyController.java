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
import com.kapil.myProject.Repository.StudentService;

@RestController
public class MyController {

	@Autowired
	StudentService service;
	
	@RequestMapping("/getStudents")
	@ResponseBody
	public List<Student> getStudents() {
		return service.findStudents();
	}
	
	@PostMapping("/addStudents")
	public Student addStudents(@RequestBody Student student) {
		return service.saveStudent(student);
		
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable("id") int id ) {
		return service.deleteStudent(id);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	
	}

}

