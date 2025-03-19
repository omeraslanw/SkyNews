package com.skylab.skynews.core.utilities.results;

public class DataResult<T> extends Result {
    private T data;

    public DataResult(String message, boolean success, T data) {
        super(message, success);
        this.data = data;
    }

    public DataResult(boolean success, T data) {
        super(success);
        this.data = data;
    }

    public DataResult(String message, boolean success) {
        super(message, success);
    }

    public T getData() {
        return data;
    }
}
