package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user_name;
    EditText password;
    Button Login;
    Button Registered ;
    int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_name.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(), "Hello" , Toast.LENGTH_SHORT).show();
                }else if (counter == 0){
                         int time = 3000;
                        //锁死按钮
                        Login.setEnabled(false);
                        Toast.makeText(getApplicationContext(), "Please wait 30 minutes and try again." , Toast.LENGTH_SHORT).show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Login.setEnabled(true);
                            }}, time);
                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong Credentials，Remain:" + counter--, Toast.LENGTH_SHORT).show();
                    }
                }
        });

        Registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public  void  item(){
        user_name = (EditText)findViewById(R.id.user_login_edit);
        password = (EditText)findViewById(R.id.password_edit);
        Login = (Button)findViewById(R.id.login_bt);
        Registered = (Button)findViewById(R.id.registered_bt);
    }

}
