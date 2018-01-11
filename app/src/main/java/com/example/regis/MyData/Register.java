package com.example.regis.MyData;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText username,password,confirmPassword;
    Button submit;
    DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=(EditText)findViewById(R.id.UserName);
        password=(EditText)findViewById(R.id.Password) ;
        confirmPassword=(EditText)findViewById(R.id.ConfirmPassword) ;
        submit=(Button)findViewById(R.id.register) ;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper=new DatabaseHelper(getApplicationContext(),null,null,1);
                UserReg userReg=new UserReg();
                userReg.setUserName(username.getText().toString());

                long val=helper.registerUser(userReg);
                if (val>0){
                    startActivity(new Intent(getApplicationContext(),LoginDemo.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"User not registered , try again",Toast.LENGTH_LONG).show();
                }

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
