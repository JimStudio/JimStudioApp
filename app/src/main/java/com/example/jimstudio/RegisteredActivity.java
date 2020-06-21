package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisteredActivity extends AppCompatActivity {

    EditText username , password , confrompassword , Email;
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered);
        iten();
        password.setHint("Password");
        confrompassword.setHint("Conform Password");


        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pas = password.getText().toString();
                final String compass = confrompassword.getText().toString();
                if (pas.equals(compass)){
                    Toast.makeText(getApplicationContext() , "Pass" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "No Pass" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void iten(){
//        username = (EditText)findViewById(R.id.re_username);
        password = (EditText) findViewById(R.id.re_password);
        confrompassword = (EditText) findViewById(R.id.re_confirmPassword);
        Email = (EditText) findViewById(R.id.re_email);
        bt_register = (Button) findViewById(R.id.re_bt);
    }
}
