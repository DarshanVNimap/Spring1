package com.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.manytomany.model.Student;
import com.manytomany.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repository;
	
	public List<Student> getAllStudent(Integer pageNo , Integer pageSize , String sortBy){
		return repository.findAll(PageRequest.of(pageNo, pageSize , Sort.by(sortBy))).getContent();
	}
	
	public List<Student> getAllStudentByName(String name){
		return repository.findByName(name);
	}
	public Student getStudentById(Integer id){
		return repository.findById(id).orElseThrow();
	}
	public List<Student> getAllStudentByDepartment(String department){
		return repository.findByDepartment(department);
		
	}
	public List<Student> getAllStudentOrderByCourseId(){
		return repository.findAllByOrderByCourseId();
	}
	public List<Student> getAllStudentNotEnroll(){
		return repository.findAllByCourseIdIsNull();
		
	}
	
	public Student addStudent(Student student) {
		return repository.save(student);
	}
	
	public Student updateStudent(Student student , Integer id) {
		student.setId(id);
		return repository.save(student);
	}
	
	public Student removeStudent(Integer id) {
		repository.deleteById(id);
		return repository.findById(id).orElseThrow();
	}

}
