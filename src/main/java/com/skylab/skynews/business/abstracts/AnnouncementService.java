package com.skylab.skynews.business.abstracts;

import com.skylab.skynews.core.utilities.results.DataResult;
import com.skylab.skynews.core.utilities.results.Result;
import com.skylab.skynews.entities.dtos.CreateAnnouncementDto;
import com.skylab.skynews.entities.dtos.GetAnnouncementDto;

import java.util.List;

public interface AnnouncementService {
    public DataResult<List<GetAnnouncementDto>> getAllAnnouncements();

    public DataResult<GetAnnouncementDto> getAnnouncementById(int id);

    public DataResult<GetAnnouncementDto> getAnnouncementByTitle(String title);

    public Result addAnnouncement(CreateAnnouncementDto announcementDto);

    public Result updateAnnouncement(int id, CreateAnnouncementDto announcementDto);

    public Result deleteAnnouncement(int id);
}
