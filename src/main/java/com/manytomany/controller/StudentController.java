package com.manytomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manytomany.model.Student;
import com.manytomany.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("")
	public ResponseEntity<?> getAllStudent(
			@RequestParam(name = "pageNo" , defaultValue = "0") Integer pageNo ,
			@RequestParam(name = "pageSize" , defaultValue = "2") Integer pageSize,
			@RequestParam(name = "sortBy" , defaultValue = "id") String sortBy
			){
		return new ResponseEntity<>(service.getAllStudent(pageNo , pageSize, sortBy) , HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getAllStudentByName(@PathVariable String name){
		return new ResponseEntity<>(service.getAllStudentByName(name) , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id){
		return new ResponseEntity<>(service.getStudentById(id) , HttpStatus.OK);
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<?> getAllStudentByDepartment(@PathVariable String department){
		return new ResponseEntity<>(service.getAllStudentByDepartment(department) , HttpStatus.OK);
	}
	@GetMapping("/sort")
	public ResponseEntity<?> getAllStudentOrderByCourse(){
		return new ResponseEntity<>(service.getAllStudentOrderByCourseId() , HttpStatus.OK);
	}
	
	@GetMapping("/notEnroll")
	public ResponseEntity<?> getAllStudentNotEnroll(){
		return new ResponseEntity<>(service.getAllStudentNotEnroll(), HttpStatus.OK);
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		return new ResponseEntity<>(service.addStudent(student) , HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Integer id){
		return new ResponseEntity<>(service.updateStudent(student, id) , HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeStudent(@PathVariable Integer id){
		return new ResponseEntity<>(service.removeStudent(id) , HttpStatus.OK);
	}
	

	
}
