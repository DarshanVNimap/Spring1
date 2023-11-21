package com.manytomany.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	public List<Student> findByName(String name);
	
	public List<Student> findByDepartment(String department);
	
	public List<Student> findByCourseId(int id);
	
	public List<Student> findAllByOrderByCourseId();
	
	public List<Student> findAllByCourseIdIsNull();

}
