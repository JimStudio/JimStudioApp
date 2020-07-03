package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user_name , password;
    Button Login , Registered ;
    CheckBox checkBox;
    private int counter = 5;
    Handler handler = new Handler();
    Intent Layout , Home_Layout;
    private float time = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item();
        password.setHint("Password");

        SharedPreferences preferences = getSharedPreferences("checkbox" , MODE_PRIVATE);
        String chackbox = preferences.getString("remember","");
        if (chackbox.equals("true")){
            Home_Layout = new Intent(MainActivity.this , Home.class);
            startActivity(Home_Layout);
            finish();
        }else if (chackbox.equals("false")){
        }


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_name.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Home_Layout = new Intent(MainActivity.this , Home.class);
                    startActivity(Home_Layout);
                    finish();
                }else if (counter == 0){

                        //锁死按钮
                        Login.setEnabled(false);
                        Toast.makeText(getApplicationContext(), "Please wait 30 minutes and try again." , Toast.LENGTH_SHORT).show();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Login.setEnabled(true);
                            }}, (long) time);
                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong Credentials，Remain:" + counter--, Toast.LENGTH_SHORT).show();
                    }
                }
        });

        Registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Layout = new Intent(MainActivity.this , RegisteredActivity.class);
                startActivity(Layout);
                finish();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox" , MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember","true");
                    editor.apply();
                    Log.d("On click" , "ok");
                }else if (!buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox" , MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember" , "false");
                    editor.apply();
                    Log.d("not on click" , "no");
                }
            }
        });
    }




    public  void  item(){
        user_name = (EditText)findViewById(R.id.user_login);
        password = (EditText)findViewById(R.id.password_edit);
        Login = (Button)findViewById(R.id.login_bt);
        Registered = (Button)findViewById(R.id.registered_bt);
        checkBox = (CheckBox) findViewById(R.id.check_box);
    }

}
