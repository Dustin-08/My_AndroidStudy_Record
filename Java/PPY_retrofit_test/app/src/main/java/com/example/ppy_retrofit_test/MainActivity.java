package com.example.ppy_retrofit_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {
    Button apigetBtn, apistoretBtn;
    TextView apiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // id 선언
        apigetBtn = findViewById(R.id.apigetBtn);
        apiResult = findViewById(R.id.apiResult);
        apistoretBtn = findViewById(R.id.apistoreBtn);

        apigetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // API 요청
                getWelcomeMessage();
            }
        });
        apistoretBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // API 요청
                getStoreMessage();
            }
        });
    }
    // API 요청 메서드
    private void getWelcomeMessage() {
        // Retrofit 객체 생성
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://freeptk.iptime.org:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Retrofit 인터페이스 생성
        WelcomeApi api = retrofit.create(WelcomeApi.class);

        // API 요청
        Call<WelcomeResponse> call = api.getWelcomeMessage();
        enqueueCall(call);

//        call.enqueue(new Callback<WelcomeResponse>() {
//            @Override
//            public void onResponse(Call<WelcomeResponse> call, Response<WelcomeResponse> response) {
//                if(response.isSuccessful()) {
//                    WelcomeResponse welcomeResponse = response.body();
//                    if (welcomeResponse != null) {
//                        String welcomeMessage = welcomeResponse.getMessage();
//                        Toast.makeText(getApplicationContext(), "서버 응답: " + welcomeMessage, Toast.LENGTH_SHORT).show();
//                        apiResult.setText("서버 응답: " + welcomeMessage);
//                    } else {
//                        Toast.makeText(getApplicationContext(), "응답이 비어있습니다.", Toast.LENGTH_SHORT).show();
//                        apiResult.setText("응답이 비어있습니다.");
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<WelcomeResponse> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "API 호출 실패: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                apiResult.setText("API 호출 실패: " + t.getMessage());
//            }
//        });
    }
    private void getStoreMessage() {
        // Retrofit 객체 생성
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://freeptk.iptime.org:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Retrofit 인터페이스 생성
        WelcomeApi api = retrofit.create(WelcomeApi.class);

        // API 요청
        Call<WelcomeResponse> call = api.getStoreMessage();

        enqueueCall(call);
    }
    // call을 받아와서 apiResult TextView에 출력
    private void enqueueCall(Call<WelcomeResponse> call) {
        call.enqueue(new Callback<WelcomeResponse>() {
            @Override
            public void onResponse(Call<WelcomeResponse> call, Response<WelcomeResponse> response) {
                if(response.isSuccessful()) {
                    WelcomeResponse welcomeResponse = response.body();
                    if (welcomeResponse != null) {
                        String welcomeMessage = welcomeResponse.getMessage();
                        Toast.makeText(getApplicationContext(), "서버 응답: " + welcomeMessage, Toast.LENGTH_SHORT).show();
                        apiResult.setText("서버 응답: " + welcomeMessage);
                    } else {
                        Toast.makeText(getApplicationContext(), "응답이 비어있습니다.", Toast.LENGTH_SHORT).show();
                        apiResult.setText("응답이 비어있습니다.");
                    }
                }
            }

            @Override
            public void onFailure(Call<WelcomeResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "API 호출 실패: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                apiResult.setText("API 호출 실패: " + t.getMessage());
            }
        });
    }

}