package com.example.ppy_retrofit_test;

import com.google.gson.annotations.SerializedName;

public class WelcomeResponse {
    // ToDo: ArrayList 받아오는거
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }
}
