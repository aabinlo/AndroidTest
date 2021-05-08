package com.example.liuliang.startproject_210ll.model;

import com.example.liuliang.startproject_210ll.bean.WeatherRewsult;
import com.example.liuliang.startproject_210ll.iface.WeatherIface;
import com.example.liuliang.startproject_210ll.iface.WeatherListener;
import com.example.liuliang.startproject_210ll.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuliang on 2017/3/14.
 */

public class WeatherModel implements WeatherIface{
    private Retrofit retrofit;
    private WeatherService weatherService;
    private String BASEURL="http://www.weather.com.cn/";
    public WeatherModel() {
        retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        weatherService= retrofit.create(WeatherService.class);
        Call<WeatherRewsult> call = weatherService.getRewsult(cityno);
        call.enqueue(new Callback<WeatherRewsult>() {
            @Override
            public void onResponse(Call<WeatherRewsult> call, Response<WeatherRewsult> response) {
                System.out.println("------onResponse");
                if(response.isSuccessful()&&response.body()!=null){
                    //调用监听事件接口的onResponse方法
                    listener.onResponse(response.body().getWeatherinfo());
                }
                else{
                    listener.onFall("解析错误！");
                }
            }

            @Override
            public void onFailure(Call<WeatherRewsult> call, Throwable t) {
                System.out.println("------onFailure");

                listener.onFall(t.toString());
            }

        });
    }
}
