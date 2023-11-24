package com.manytomany.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.manytomany.model.Student;
import com.manytomany.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repository;
	
	private Logger log = LoggerFactory.getLogger(StudentService.class);
	
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
	
	public ByteArrayInputStream generatePdf() {
		
		String title = "Hello ";
		String name = "Darrshan vala is world best java developer";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, out);
		
		doc.open();
		
		Font titleFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
		titleFont.setSize(16);
		
		Font parafont = FontFactory.getFont(FontFactory.TIMES);
		parafont.setSize(14);
		
		Paragraph heading = new Paragraph(title , titleFont);
		heading.setAlignment(Paragraph.ALIGN_CENTER);
		
		
		
		doc.add(heading);
		
		Paragraph para = new Paragraph(name , parafont);
		para.setFirstLineIndent((float) 1.3);
		
		doc.add(para);
		doc.close();
		
		return new ByteArrayInputStream(out.toByteArray());
	}

}
