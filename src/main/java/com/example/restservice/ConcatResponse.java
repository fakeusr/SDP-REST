package com.example.restservice;

import java.time.LocalTime;

class ConcatResponse {

    private final String finalString;
    private final LocalTime time;

    public ConcatResponse(String finalString) {
        this.finalString = finalString;
        this.time = LocalTime.now();
    }

    public String getFinalString() {
        return finalString;
    }

    public LocalTime getTime() {
        return time;
    }
}
