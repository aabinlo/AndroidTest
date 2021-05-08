package com.example.liuliang.startproject_210ll.iface;

/**
 * Created by liuliang on 2017/3/14.
 */

public interface WeatherIface {
    void getWeather(String cityno, WeatherListener listener);
}
