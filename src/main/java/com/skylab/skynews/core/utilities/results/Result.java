package com.skylab.skynews.core.utilities.results;

public class Result {
    private final boolean success;

    private String message;

    public Result(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }
}
