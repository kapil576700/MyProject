package com.kapil.myProject;

import com.kapil.myProject.Entity.Student;
import com.kapil.myProject.Repository.StudentRepo;
import com.kapil.myProject.Repository.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
	@Mock
	StudentRepo repo = mock(StudentRepo.class);
	
	@InjectMocks
	StudentService service;

	@Test
	public void testFindStudents() {
		Student student1 = new Student(104,"Karan","B");
		Student student2 = new Student(104,"Jessica","A");
		List<Student> expectedList = new ArrayList<>();
		expectedList.add(student1);
		expectedList.add(student2);
		when(repo.findAll()).thenReturn(expectedList);
		List<Student> actualList = service.findStudents();
        Mockito.verify(repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testSaveStudent(){
		Student student = new Student(104,"Jessica","A");
		service.saveStudent(student);
		Mockito.verify(repo, Mockito.times(1)).save(student);
	}

	@Test
	public void testDeleteStudent(){
		Student student = new Student(104,"Jessica","A");
		when(repo.getById(student.getId())).thenReturn(student);
		Student s = repo.getById(student.getId());
		Mockito.verify(repo,Mockito.times(1)).getById(student.getId());
		service.deleteStudent(student.getId());
		Mockito.verify(repo,Mockito.times(1)).delete(s);
	}

	@Test
	public void testUpdateStudent(){
		Student student = new Student(104,"Jessica","A");
		service.saveStudent(student);
		Mockito.verify(repo, Mockito.times(1)).save(student);
	}
}
