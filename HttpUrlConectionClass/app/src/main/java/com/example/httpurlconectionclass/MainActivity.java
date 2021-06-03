package com.example.httpurlconectionclass;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv_result;
    private EditText et_path;
    private Button button;

    protected static final int SUCCESS = 1;
    protected static final int ERROR = 2;
    private HttpURLConnection httpURLConnection;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SUCCESS:
                    String text = (String)msg.obj;
                    tv_result.setText(text);
                    break;
                case ERROR:
                    Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = (TextView)findViewById(R.id.textView);
        et_path = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String path = et_path.getText().toString().trim();
        new Thread(){
            @Override
            public void run() {
                try{
                    URL url = new URL(path);
                    httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    int code = httpURLConnection.getResponseCode();
                    if(code == 200){
                        InputStream is = httpURLConnection.getInputStream();
                        String result = StreamTools.readStream(is);
                        Message msg = Message.obtain();
                        msg.obj = result;
                        msg.what = SUCCESS;
                        handler.sendMessage(msg);
                        System.out.println("=========>"+code);
                    }
                }catch (Exception e){
                    Message msg = Message.obtain();
                    msg.what = ERROR;
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }
}
