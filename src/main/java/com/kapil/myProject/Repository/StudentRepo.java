package com.kapil.myProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kapil.myProject.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
