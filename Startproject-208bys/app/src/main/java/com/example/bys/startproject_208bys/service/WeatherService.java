package com.example.bys.startproject_208bys.service;

import com.example.bys.startproject_208bys.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by BYS on 2017/3/15.
 */

public interface WeatherService {
    @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult>getResult(@Path("cityNumber")String cityNumber);



}
