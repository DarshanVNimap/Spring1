package com.manytomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manytomany.model.Course;
import com.manytomany.model.Student;
import com.manytomany.repo.CourseRepo;
import com.manytomany.repo.StudentRepo;

@RestController
@RequestMapping("/api")
public class AppController {
	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private CourseRepo crepo;

	@GetMapping("/student")
	public ResponseEntity<?> getAllStudent(){
		return new ResponseEntity<>(repo.findAll() , HttpStatus.OK);
	}
	
	@GetMapping("/student/name/{name}")
	public ResponseEntity<?> getAllStudentByName(@PathVariable String name){
		return new ResponseEntity<>(repo.findByName(name) , HttpStatus.OK);
	}
	
	@GetMapping("/student/id/{id}")
	public ResponseEntity<?> getAllStudentById(@PathVariable Integer id){
		return new ResponseEntity<>(repo.findById(id) , HttpStatus.OK);
	}
	
	@GetMapping("/student/department/{department}")
	public ResponseEntity<?> getAllStudentByDepartment(@PathVariable String department){
		return new ResponseEntity<>(repo.findByDepartment(department) , HttpStatus.OK);
	}
	@GetMapping("/student/sort")
	public ResponseEntity<?> getAllStudentOrderByName(){
		return new ResponseEntity<>(repo.findAllByOrderByCourseId() , HttpStatus.OK);
	}
	
	@GetMapping("/student/notEnroll")
	public ResponseEntity<?> getAllStudentNotEnroll(){
		return new ResponseEntity<>(repo.findAllByCourseIdIsNull() , HttpStatus.OK);
	}
	
	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		return new ResponseEntity<>(repo.save(student) , HttpStatus.CREATED);
	}
	
	
	
	
	
//---------------------------  Course Controll -----------------------------
	
	@GetMapping("/course")
	public ResponseEntity<?> getAllCourse(){
		return new ResponseEntity<>(crepo.findAll() , HttpStatus.OK);
	}
	
	
	@PostMapping("/course")
	public ResponseEntity<?> addCourse(@RequestBody Course course){
		return new ResponseEntity<>(crepo.save(course) , HttpStatus.CREATED);
	}
	public ResponseEntity<?> updateStudent(){
		return null;
	}
	
	
}
