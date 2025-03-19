package com.skylab.skynews.dataAccess.abstracts;

import com.skylab.skynews.entities.concretes.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer> {
    Announcement getAnnouncementByTitle(String title);

    boolean existsByTitle(String title);
}
