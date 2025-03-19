package com.skylab.skynews.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "announcement_id")
    private int id;

    @Column(name = "announcement_title")
    private String title;

    @Column(name = "announcement_content")
    private String content;

    @Column(name = "announcement_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
}
