package com.example.ppy_retrofit_test;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WelcomeApi {
    @GET("/") // 기존에는 "/"이었습니다. "/store"로 변경합니다.
    Call<WelcomeResponse> getWelcomeMessage();

    @GET("/store") // 새로운 API 엔드포인트를 추가합니다.
    Call<WelcomeResponse> getStoreMessage();
}
