package com.skylab.skynews.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(String message, T data) {
        super(message, false, data);
    }

    public ErrorDataResult(T data) {
        super(null, false, data);
    }

    public ErrorDataResult(String message) {
        super(message, false, null);
    }

    public ErrorDataResult() {
        super(null, false, null);
    }
}
