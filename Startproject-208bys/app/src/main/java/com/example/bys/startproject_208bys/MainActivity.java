package com.example.bys.startproject_208bys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bys.startproject_208bys.bean.WeatherInfo;
import com.example.bys.startproject_208bys.iface.WeatherListener;
import com.example.bys.startproject_208bys.model.Weather51Model;
import com.example.bys.startproject_208bys.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherListener,View.OnClickListener{
    @Override
    public void onResponse(WeatherInfo weatherinfo) {
        if(weatherinfo!=null){
            if(butn==1){
                tvcityname.setText(weatherinfo.getCity());
            }else {
                tvcityname.setText(weatherinfo.getCity() + weatherinfo.getSD() + weatherinfo.getTemp() + weatherinfo.getWD() + weatherinfo.getWS());
            }
        }else {
            tvcityname.setText("未知");
        }
    }
    @Override
    public void onFail(String msg) {
        tvcityname.setText(msg);

    }
    private EditText etcity;
    private TextView tvcityname;
    private Button btn1,btn2;
    private int butn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private  void init(){
        etcity=(EditText)findViewById(R.id.editText);
        tvcityname=(TextView)findViewById(R.id.textView);
        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button://中国天气
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getWeather(etcity.getText().toString(),this);
                butn=1;
                break;
            case R.id.button2://51
                WeatherModel weatherModel1=new WeatherModel();
                weatherModel1.getWeather(etcity.getText().toString(),this);
                butn=2;
                break;

        }

    }
}
