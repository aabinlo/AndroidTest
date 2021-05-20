package com.example.liuliang.widettest_210ll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private EditText et;
    private Button btngettext,btnsetimg;
    private ImageButton ibtn;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        tv=(TextView)findViewById(R.id.textView3);
        et=(EditText)findViewById(R.id.editText);
        btngettext=(Button) findViewById(R.id.button);
        btnsetimg=(Button) findViewById(R.id.button2);
        iv=(ImageView) findViewById(R.id.imageView);
        ibtn=(ImageButton) findViewById(R.id.imageButton);
        btngettext.setOnClickListener(this);
        btnsetimg.setOnClickListener(this);
        ibtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String str=et.getText().toString();
                tv.setText(str);
                break;
            case R.id.button2:
                iv.setImageResource(R.drawable.ab);
                break;
            case  R.id.imageButton:

                break;

        }

    }
}
