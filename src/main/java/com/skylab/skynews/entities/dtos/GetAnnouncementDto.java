package com.skylab.skynews.entities.dtos;

import com.skylab.skynews.entities.concretes.Announcement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAnnouncementDto {
    private int id;

    private String title;

    private String content;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    public GetAnnouncementDto(Announcement announcement) {
        this.id = announcement.getId();
        this.content = announcement.getContent();
        this.title = announcement.getTitle();
        this.date = announcement.getDate();
    }

    public List<GetAnnouncementDto> buildListGetAnnouncement(List<Announcement> announcements) {
        return announcements.stream()
                .map(GetAnnouncementDto::new)
                .collect(Collectors.toList());
    }
}
