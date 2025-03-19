package com.skylab.skynews.webApi.controllers;

import com.skylab.skynews.business.abstracts.AnnouncementService;
import com.skylab.skynews.entities.dtos.CreateAnnouncementDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webApi/announcements")
public class AnnouncementsController {
    private final AnnouncementService announcementService;

    public AnnouncementsController(AnnouncementService announcementService) {
        super();
        this.announcementService = announcementService;
    }

    @GetMapping("/getAllAnnouncements")
    public ResponseEntity<?> getAllAnnouncements() {
        var result = announcementService.getAllAnnouncements();

        if (result.isSuccess()) {
            return ResponseEntity.ok().body(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAnnouncementById/{id}")
    public ResponseEntity<?> getAnnouncementById(@PathVariable int id) {
        var result = announcementService.getAnnouncementById(id);

        if (result.isSuccess()) {
            return ResponseEntity.ok().body(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/addAnnouncement")
    public ResponseEntity<?> addAnnouncement(@RequestBody @Valid CreateAnnouncementDto announcementDto) {
        var result = announcementService.addAnnouncement(announcementDto);

        if (result.isSuccess()) {
            return ResponseEntity.ok().body(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAnnouncementByTitle/{title}")
    public ResponseEntity<?> getAnnouncementByTitle(@PathVariable @Valid String title) {
        var result = announcementService.getAnnouncementByTitle(title);

        if (result.isSuccess()) {
            return ResponseEntity.ok().body(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/updateAnnouncement/{id}")
    public ResponseEntity<?> updateAnnouncement(@PathVariable int id, @RequestBody @Valid CreateAnnouncementDto announcementDto) {
        var result = announcementService.updateAnnouncement(id, announcementDto);

        if (result.isSuccess()) {
            return ResponseEntity.ok().body(result);
        }

        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/deleteAnnouncement/{id}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable @Valid int id) {
        var result = announcementService.deleteAnnouncement(id);

        if (result.isSuccess()) {
            return ResponseEntity.ok().body(result);
        }

        return ResponseEntity.badRequest().body(result);
    }
}
