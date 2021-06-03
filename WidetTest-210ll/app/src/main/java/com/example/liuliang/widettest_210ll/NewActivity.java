package com.example.liuliang.widettest_210ll;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent intent=getIntent();
        String str=intent.getStringExtra("param1");
        int n=intent.getIntExtra("param2",10);
        System.out.println(str+"---"+String.valueOf(n));
        Toast.makeText(this, str+"---"+String.valueOf(n), Toast.LENGTH_SHORT).show();
        TextView tv=(TextView)findViewById(R.id.textView3);
        tv.setText(str+"---"+String.valueOf(n));

        Button btn=(Button)findViewById(R.id.button3);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button3:
                finish();;
                break;
        }
    }
}
