package com.project.repository;
//AnnouncementRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
