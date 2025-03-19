package com.skylab.skynews.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError<T> {
    private String id;

    private Date errorTime;

    private T errors;
}
