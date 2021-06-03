package com.example.bys.startproject_208bys.model;

import com.example.bys.startproject_208bys.bean.WeatherResult;
import com.example.bys.startproject_208bys.iface.WeatherIface;
import com.example.bys.startproject_208bys.iface.WeatherListener;
import com.example.bys.startproject_208bys.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BYS on 2017/3/14.
 */

public class Weather51Model implements WeatherIface{

    private Retrofit retrofit;
    private String BASEURL="http://weather.51wnl.com/weatherinfo/";
    private WeatherService weatherService;
    public Weather51Model(){
        //retrofit使用3-1
        retrofit=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Override
    public void getWeather(String cityno, final WeatherListener listener) {
        //retrofit使用3-2
        weatherService=retrofit.create(WeatherService.class);
        Call<WeatherResult> call=weatherService.getResult(cityno);
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                if(response.isSuccessful()&&response.body()!=null)
                   listener.onResponse(response.body().getWeatherinfo());
                else
                    listener.onFail("onResponse fail");
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
