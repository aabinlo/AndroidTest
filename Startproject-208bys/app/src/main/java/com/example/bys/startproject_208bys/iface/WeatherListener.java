package com.example.bys.startproject_208bys.iface;

import com.example.bys.startproject_208bys.bean.WeatherInfo;

/**
 * Created by BYS on 2017/3/14.
 */

public interface WeatherListener {
    void onResponse(WeatherInfo weatherinfo);
    void onFail(String msg);
}
