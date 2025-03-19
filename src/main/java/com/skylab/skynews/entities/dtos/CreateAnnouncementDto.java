package com.skylab.skynews.entities.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateAnnouncementDto {
    @NotEmpty(message = "Başlık alanı boş olamaz!")
    @Size(min = 3, max = 50, message = "En az 3, en fazla 50 karakter girmelisiniz!")
    private String title;

    @NotEmpty(message = "İçerik alanı boş olamaz!")
    @Size(min = 3, max = 500, message = "En az 3, en fazla 500 karakter girmelisiniz!")
    private String content;

    @FutureOrPresent(message = "Geçmişteki bir tarihi giremezsiniz!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
}
