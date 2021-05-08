package com.example.liuliang.startproject_210ll.model;

import com.example.liuliang.startproject_210ll.bean.WeatherRewsult;
import com.example.liuliang.startproject_210ll.iface.WeatherIface;
import com.example.liuliang.startproject_210ll.iface.WeatherListener;
import com.example.liuliang.startproject_210ll.service.Weather51Service;
import com.example.liuliang.startproject_210ll.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuliang on 2017/3/14.
 */

public class Weather51Model implements WeatherIface {
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
        Call<WeatherRewsult> call=weatherService.getRewsult(cityno);
        call.enqueue(new Callback<WeatherRewsult>() {
            @Override
            public void onResponse(Call<WeatherRewsult> call, Response<WeatherRewsult> response) {
                if(response.isSuccessful()&&response.body()!=null)
                    listener.onResponse(response.body().getWeatherinfo());
                else
                    listener.onFall("onResponse fail");
            }

            @Override
            public void onFailure(Call<WeatherRewsult> call, Throwable t) {
                listener.onFall(t.toString());
            }
        });
    }
}
