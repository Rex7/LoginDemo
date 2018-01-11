package com.example.regis.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.regis.MyData.R;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
       Bundle bundle=getIntent().getExtras();
        String data= (String) bundle.get("username");
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText(data);
    }
}
