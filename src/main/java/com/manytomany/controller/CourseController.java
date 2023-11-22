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

import com.manytomany.model.Course;
import com.manytomany.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping("")
	public ResponseEntity<?> getAllCourse(
			@RequestParam(defaultValue = "1" , name = "pageNo") Integer pageNo,
			@RequestParam(defaultValue = "5" , name = "pageSize") Integer pageSize,
			@RequestParam(defaultValue = "id" , name = "sortBy") String sortBy
			){
		return new ResponseEntity<>(service.getAllCourse(pageNo , pageSize , sortBy) , HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Integer id){
		return new ResponseEntity<>(service.getCourseById(id) , HttpStatus.OK);
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> addCourse(@RequestBody Course course){
		return new ResponseEntity<>(service.addCourse(course) , HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCourse(@RequestBody Course course ,@PathVariable Integer id){
		return new ResponseEntity<>(service.updateCourse(course, id) , HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeCourse(@PathVariable Integer id){
		return new ResponseEntity<>(service.removeCourse(id), HttpStatus.OK);
	}
	

}
