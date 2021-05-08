package com.example.liuliang.startproject_210ll.iface;

import com.example.liuliang.startproject_210ll.bean.WeatherInfo;

/**
 * Created by liuliang on 2017/3/14.
 */

public interface WeatherListener {
    void onResponse(WeatherInfo weatherInfo);
    void onFall(String msg);

}
