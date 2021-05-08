package com.example.liuliang.startproject_210ll.service;

import com.example.liuliang.startproject_210ll.bean.WeatherRewsult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by liuliang on 2017/3/15.
 */

public interface WeatherService {
    @GET("data/sk/{cityNumber}.html")
    Call<WeatherRewsult>getRewsult(@Path("cityNumber")String cityNumber);
}
