package com.skylab.skynews.business.concretes;

import com.skylab.skynews.business.abstracts.AnnouncementService;
import com.skylab.skynews.business.messages.AnnouncementMessages;
import com.skylab.skynews.core.utilities.results.*;
import com.skylab.skynews.dataAccess.abstracts.AnnouncementDao;
import com.skylab.skynews.entities.concretes.Announcement;
import com.skylab.skynews.entities.dtos.CreateAnnouncementDto;
import com.skylab.skynews.entities.dtos.GetAnnouncementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementManager implements AnnouncementService {
    private final AnnouncementDao announcementDao;

    @Autowired
    public AnnouncementManager(AnnouncementDao announcementDao) {
        super();
        this.announcementDao = announcementDao;
    }

    @Override
    public DataResult<List<GetAnnouncementDto>> getAllAnnouncements() {
        List<Announcement> result = announcementDao.findAll();

        if (result.isEmpty()) {
            return new ErrorDataResult<>(AnnouncementMessages.announcementsNotFound);
        }

        var announcementDtoList = new GetAnnouncementDto().buildListGetAnnouncement(result);
        return new SuccessDataResult<>(AnnouncementMessages.announcementsBroughtSuccessfully, announcementDtoList);
    }

    @Override
    public DataResult<GetAnnouncementDto> getAnnouncementById(int id) {
        var result = announcementDao.findById(id);

        if (result.isEmpty()) {
            return new ErrorDataResult<>(AnnouncementMessages.announcementNotFound);
        }

        GetAnnouncementDto announcementDto = new GetAnnouncementDto();
        BeanUtils.copyProperties(result.get(), announcementDto);

        return new SuccessDataResult<>(AnnouncementMessages.announcementBroughtSuccessfully, announcementDto);
    }

    @Override
    public DataResult<GetAnnouncementDto> getAnnouncementByTitle(String title) {
        var result = announcementDao.getAnnouncementByTitle(title);

        if (result == null) {
            return new ErrorDataResult<>(AnnouncementMessages.announcementNotFound);
        }

        GetAnnouncementDto announcementDto = new GetAnnouncementDto();
        BeanUtils.copyProperties(result, announcementDto);

        return new SuccessDataResult<>(AnnouncementMessages.announcementBroughtSuccessfully, announcementDto);
    }

    @Override
    public Result addAnnouncement(CreateAnnouncementDto announcementDto) {
        if (announcementDao.existsByTitle(announcementDto.getTitle())) {
            return new ErrorResult(AnnouncementMessages.announcementAlreadyExists);
        }

        Announcement announcement = Announcement.builder().content(announcementDto.getContent()).date(announcementDto.getDate()).title(announcementDto.getTitle()).build();

        announcementDao.save(announcement);

        return new SuccessResult(AnnouncementMessages.announcementAddedSuccessfully);
    }

    @Override
    public Result updateAnnouncement(int id, CreateAnnouncementDto announcementDto) {
        var result = checkIfAnnouncementExists(id);

        if (!result.isSuccess()) {
            return new ErrorResult(AnnouncementMessages.announcementNotFound);
        }

        if (announcementDao.existsByTitle(announcementDto.getTitle())) {
            return new ErrorResult(AnnouncementMessages.announcementAlreadyExists);
        }

        var announcementToUpdate = announcementDao.findById(id).get();
        announcementToUpdate.setContent(announcementDto.getContent());
        announcementToUpdate.setTitle(announcementDto.getTitle());
        announcementToUpdate.setDate(announcementDto.getDate());

        announcementDao.save(announcementToUpdate);
        return new SuccessResult(AnnouncementMessages.announcementUpdatedSuccessfully);
    }

    @Override
    public Result deleteAnnouncement(int id) {
        var result = announcementDao.findById(id);

        if (result.isEmpty()) {
            return new ErrorResult(AnnouncementMessages.announcementNotFound);
        }

        announcementDao.deleteById(id);
        return new SuccessResult(AnnouncementMessages.announcementDeletedSuccessfully);
    }

    private Result checkIfAnnouncementExists(int id) {
        var result = announcementDao.findById(id);

        if (result.isEmpty()) {
            return new ErrorResult(AnnouncementMessages.announcementNotFound);
        }

        return new SuccessResult(AnnouncementMessages.announcementAlreadyExists);
    }
}
