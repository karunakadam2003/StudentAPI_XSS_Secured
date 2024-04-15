package com.project.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.entities.Student;
import com.project.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public List<Student> getStudents(){
        return (List<Student>) repository.findAll();
    }
	public Student createStudent(Student student) {
		return repository.save(student);
		
	}
//	public org.springframework.http.ResponseEntity<?> loginStudent(Student studentdata){
//        Student student = repository.findByemail(studentdata.getEmail());
//		
//		if(student.getpassword().equals(student.getpassword())) {
//			return org.springframework.http.ResponseEntity.ok(student);
//		}
//		return (org.springframework.http.ResponseEntity<?>) org.springframework.http.ResponseEntity.internalServerError();
//	}
	public org.springframework.http.ResponseEntity<?> loginStudent(Student studentdata){
		System.out.println(studentdata.getEmail());
        List<Student> students = repository.findByEmail(studentdata.getEmail());
        for (Student student : students) {
//          System.out.println("Student ID: " + student.getId());
          System.out.println("Student Name: " + student.getName());
          System.out.println("Student Email: " + student.getEmail());
          // Print other properties as needed
      }
		if(students==null) {
			return org.springframework.http.ResponseEntity.ok(students);

		}
		if(students.get(0).getpassword().equals(studentdata.getpassword())) {
	        System.out.println("right here");

			return org.springframework.http.ResponseEntity.ok(students);
		}
		else {
			return org.springframework.http.ResponseEntity.ok(students);
		}
	}
}
