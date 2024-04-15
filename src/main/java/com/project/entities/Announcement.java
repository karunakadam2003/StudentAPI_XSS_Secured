package com.project.entities;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "Announcement")
//public class Announcement {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "announcement_id")
//    private Long announcementId;
//
//    @Column(name = "description")
//    private String description;
//
//
//    public Announcement() {
//    }
//
//    public Long getAnnouncementId() {
//		return announcementId;
//	}
//
//	public void setAnnouncementId(Long announcementId) {
//		this.announcementId = announcementId;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Announcement(Long announcementId, String description, List<Event> events) {
//        this.announcementId = announcementId;
//        this.description = description;
//       
//    }
//
//    
//}




import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Entity
@Table(name = "Announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private Long announcementId;

    @NotBlank(message = "Description must not be blank")
    @Pattern(regexp = "^[^<>]+$", message = "Description must not contain HTML tags or special characters")
    @Column(name = "description")
    private String description;

    public Announcement() {
    }

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Announcement(Long announcementId, String description, List<Event> events) {
        this.announcementId = announcementId;
        this.description = description;
    }
}
