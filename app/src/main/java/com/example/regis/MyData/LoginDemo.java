package com.example.regis.MyData;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.regis.logindemo.WelcomeActivity;

public class LoginDemo extends AppCompatActivity {
    Button register,Login;
    EditText user,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_demo);
        user=(EditText)findViewById(R.id.UserName);
        password=(EditText)findViewById(R.id.Password);
        Login=(Button)findViewById(R.id.LoginButton);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=user.getText().toString();
                String pass=password.getText().toString();
                DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext(),null,null,1);
                String staus=databaseHelper.checUser(name,pass);
                if(staus.equals("sucess")){
                    Intent intent=new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("username",name);
                    startActivity(intent);
                }
                else if(staus.equals("failure")){
                    Toast.makeText(getApplicationContext(),"try registering with us",Toast.LENGTH_LONG).show();
                }

            }
        });
        register=(Button)findViewById(R.id.RegisterButton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
}
