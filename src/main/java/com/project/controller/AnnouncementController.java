package com.project.controller;
//AnnouncementController.java
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.project.entities.Announcement;
//import com.project.services.AnnouncementService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/")
//public class AnnouncementController {
//
// private final AnnouncementService announcementService;
//
// @Autowired
// public AnnouncementController(AnnouncementService announcementService) {
//     this.announcementService = announcementService;
// }
//
// @PostMapping("/createAnnouncement")
// public ResponseEntity<Announcement> createAnnouncement( @RequestBody Announcement announcement) {
//     Announcement createdAnnouncement = announcementService.createAnnouncement(announcement);
//     return new ResponseEntity<>(createdAnnouncement, HttpStatus.CREATED);
// }
//
// @GetMapping("/getAllAnnouncements")
// public ResponseEntity<List<Announcement>> getAllAnnouncements() {
//     List<Announcement> announcements = announcementService.getAllAnnouncements();
//     return new ResponseEntity<>(announcements, HttpStatus.OK);
// }
//}


//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
////import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import com.project.entities.Announcement;
//import com.project.services.AnnouncementService;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/")
//public class AnnouncementController {
//
//    private final AnnouncementService announcementService;
//
//    @Autowired
//    public AnnouncementController(AnnouncementService announcementService) {
//        this.announcementService = announcementService;
//    }
//
//    @PostMapping("/createAnnouncement")
//    public ResponseEntity<?> createAnnouncement(@Valid @RequestBody Announcement announcement) {
//        Announcement createdAnnouncement = announcementService.createAnnouncement(announcement);
//        return new ResponseEntity<>(createdAnnouncement, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/getAllAnnouncements")
//    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
//        List<Announcement> announcements = announcementService.getAllAnnouncements();
//        return new ResponseEntity<>(announcements, HttpStatus.OK);
//    }
//}





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.project.entities.Announcement;
import com.project.services.AnnouncementService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @PostMapping("/createAnnouncement")
    public ResponseEntity<?> createAnnouncement(@Valid @RequestBody Announcement announcement, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            System.out.println("Looks like an XSS Attack!!!");

            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Announcement createdAnnouncement = announcementService.createAnnouncement(announcement);
        return new ResponseEntity<>(createdAnnouncement, HttpStatus.CREATED);
    }

    @GetMapping("/getAllAnnouncements")
    public ResponseEntity<List<Announcement>> getAllAnnouncements() {
        List<Announcement> announcements = announcementService.getAllAnnouncements();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    // Exception handler for MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }
}

