package com.example.liuliang.eva1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private EditText et;
    private Button btn;
    private Handler handler =new Handler()
    {
        @Override
        public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
            switch (msg.what)
            {
                case 1:
                    ByteArrayOutputStream bos=(ByteArrayOutputStream) msg.obj;
                    tv.setText(bos.toString());
                    break;
            }
            return super.sendMessageAtTime(msg,uptimeMillis);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }
    public void onClick(View v) {
        final   String str = et.getText().toString();
        new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    URL url=new URL(str);
                    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                    byte[] data=new byte[1024];
                    InputStream is=conn.getInputStream();
                    ByteArrayOutputStream baos=new ByteArrayOutputStream();
                    while(is.read(data)!=-1)
                    {
                        baos.write(data);
                    }
                    Message msg=new Message();
                    msg.what=1;
                    msg.obj=baos;
                    handler.sendMessage(msg);
                }catch(Exception e)
                {
                    System.out.println(e.getMessage().toString());
                }
            }
        }.start();
    }
}