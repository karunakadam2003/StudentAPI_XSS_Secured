//package com.project.services;
////AnnouncementService.java
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.project.entities.Announcement;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Service
//public class AnnouncementService {
//
// @PersistenceContext
// private EntityManager entityManager;
//
// @Transactional
// public Announcement createAnnouncement(Announcement announcement) {
//     System.out.print("Announcement" + announcement.getDescription());
//
//     entityManager.persist(announcement);
//     
//     return announcement;
// }
//
// @Transactional(readOnly = true)
// public List<Announcement> getAllAnnouncements() {
//     return entityManager.createQuery("SELECT a FROM Announcement a", Announcement.class).getResultList();
// }
//}


package com.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.project.entities.Announcement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class AnnouncementService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LocalValidatorFactoryBean validatorFactoryBean;

    @Transactional
    public Announcement createAnnouncement(Announcement announcement) {
        // Validate the Announcement object
//        Set<ConstraintViolation<Announcement>> violations = validatorFactoryBean.validate(announcement);
//        if (!violations.isEmpty()) {
//            // Handle validation errors
//            // You can throw an exception or handle it in any other way
//            // For simplicity, let's just print the validation errors
//            for (ConstraintViolation<Announcement> violation : violations) {
//                System.out.println("Validation error: " + violation.getMessage());
//            }
//            System.out.println("Validation error ");
//            // You can choose to throw an exception here if you want to prevent saving invalid data
//            return null;
//        }
//        

        entityManager.persist(announcement);
        return announcement;
    }

    @Transactional(readOnly = true)
    public List<Announcement> getAllAnnouncements() {
        return entityManager.createQuery("SELECT a FROM Announcement a", Announcement.class).getResultList();
    }
}
