package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user = (EditText)findViewById(R.id.user_login_edit);
    EditText password = (EditText)findViewById(R.id.password_edit);
    Button Login = (Button)findViewById(R.id.login_bt);
    Button Registered = (Button)findViewById(R.id.registered_bt);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("")){

                }
            }
        });
    }

}
