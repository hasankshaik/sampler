package com.service;

public final class ResponceObj {
 private final Boolean canWatch;
 private final String message;

    public Boolean getCanWatch() {
        return canWatch;
    }

    public String getMessage() {
        return message;
    }

    public ResponceObj(Boolean canWatch, String message) {

        this.canWatch = canWatch;
        this.message = message;
    }
}
