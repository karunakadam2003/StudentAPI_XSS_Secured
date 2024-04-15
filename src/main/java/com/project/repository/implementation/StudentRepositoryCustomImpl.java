package com.project.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.project.entities.Student;
import com.project.repository.StudentRepositoryCustom;

public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findByEmail(String email) {
        String queryString = "SELECT * FROM Student WHERE email = '" + email + "'";
        System.out.println(queryString);
//        System.out.println("here " + entityManager.createNativeQuery(queryString, Student.class).getResultList());
        List<Student> students = entityManager.createNativeQuery(queryString, Student.class).getResultList();
        for (Student student : students) {
//            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Email: " + student.getEmail());
            // Print other properties as needed
        }

//        return entityManager.createNativeQuery(queryString, Student.class).getResultList();
        return students;
    }
}
