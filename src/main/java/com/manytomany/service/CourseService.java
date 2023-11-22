package com.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.manytomany.model.Course;
import com.manytomany.repo.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepo repository;
	
	public List<Course> getAllCourse(Integer pageNo ,Integer pageSize,String sortBy){
		return repository.findAll(PageRequest.of(pageNo-1, pageSize, Sort.by(sortBy))).getContent(); 
	}
	
	public Course getCourseById(Integer id) {
		return repository.findById(id).orElseThrow();
	}
	
	public Course addCourse(Course course) {
		return repository.save(course);
	}
	
	public Course updateCourse(Course course , Integer id){
		course.setId(id);
		return repository.save(course);
	}
	
	public Course removeCourse(Integer id) {
		repository.deleteById(id);
		return repository.findById(id).orElseThrow();
	}

}
