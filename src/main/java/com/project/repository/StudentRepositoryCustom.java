package com.project.repository;

import java.util.List;

import com.project.entities.Student;

public interface StudentRepositoryCustom {
	List<Student> findByEmail(String email);
}
