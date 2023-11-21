	package com.manytomany.model;
	
	import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	
	@Entity
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	public class Student {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String name;
		private int age;
		private String department;
		
		@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
		@JoinTable(
				name = "student_course",
				joinColumns = {
						@JoinColumn(name = "student_id" ,referencedColumnName = "id" )
				},
				inverseJoinColumns = {
						@JoinColumn(name = "course_id" , referencedColumnName = "id")
				}
				)
		private Set<Course> course;
		
	
	}
