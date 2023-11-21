package com.manytomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
