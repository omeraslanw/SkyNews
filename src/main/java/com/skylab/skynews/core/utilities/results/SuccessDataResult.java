package com.skylab.skynews.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
    public SuccessDataResult(String message, T data) {
        super(message, true, data);
    }

    public SuccessDataResult(T data) {
        super(null, true, data);
    }

    public SuccessDataResult(String message) {
        super(message, true, null);
    }

    public SuccessDataResult() {
        super(null, true, null);
    }
}
