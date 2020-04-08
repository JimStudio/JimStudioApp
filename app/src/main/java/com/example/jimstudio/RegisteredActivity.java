package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class RegisteredActivity extends AppCompatActivity {

    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered);
        iten();
        
    }

    public void iten(){
        username = (EditText)findViewById(R.id.re_username);
    }
}
