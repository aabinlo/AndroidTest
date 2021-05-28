package com.example.liuliang.widettest_210ll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private EditText et;
    private Button btngettext,btnsetimg;
    private ImageButton ibtn;
    private ImageView iv;

    private RadioButton rbnan,rbnv;
    private RadioGroup rg;
    private CheckBox cblan,cbzu,cbyou;
    private Button btngetgender,btngetfun;

    private String strfun="";

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

        rbnan=(RadioButton)findViewById(R.id.radioButton);
        rbnv=(RadioButton)findViewById(R.id.radioButton2);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        cblan=(CheckBox)findViewById(R.id.checkBox);
        cbzu=(CheckBox)findViewById(R.id.checkBox2);
        cbyou=(CheckBox)findViewById(R.id.checkBox3);
        btngetgender=(Button)findViewById(R.id.button4);
        btngetfun=(Button)findViewById(R.id.button5);

        btngetgender.setOnClickListener(this);
        btngetfun.setOnClickListener(this);

      rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
              switch (checkedId)
              {
                  case R.id.radioButton:
                      tv.setText("女");
                      break;
                   case R.id.radioButton2:
                  tv.setText("男");
                  break;
              }
          }
      });
        cblan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked) strfun+="篮球";
                        else strfun=strfun.replace("篮球+","");
                        tv.setText(strfun);


            }
        });
        cbzu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) strfun += "足球";
                else strfun = strfun.replace("足球+", "");
                tv.setText(strfun);
            }
        });
        cbyou.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) strfun+="游泳";
                else strfun=strfun.replace("游泳+","");
                tv.setText(strfun);

            }
        });
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
                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("param1",et.getText().toString());
                intent.putExtra("param2",3);
                startActivity(intent);
                break;

        }

    }
}
