package com.example.liuliang.startproject_210ll.service;


import com.example.liuliang.startproject_210ll.bean.WeatherRewsult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by liuliang on 2017/3/15.
 */

public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherRewsult> getResult(@Query("cityCode")String cityNumber, @Query("weatherType")int weatherType);


}
