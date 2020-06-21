package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

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
        if (password.equals(confrompassword)){
            confrompassword.setError("Goodd");
        }
    }

    public void iten(){
//        username = (EditText)findViewById(R.id.re_username);
        password = (EditText) findViewById(R.id.re_password);
        confrompassword = (EditText) findViewById(R.id.re_confirmPassword);
        Email = (EditText) findViewById(R.id.re_email);
        bt_register = (Button) findViewById(R.id.re_bt);
    }
}
