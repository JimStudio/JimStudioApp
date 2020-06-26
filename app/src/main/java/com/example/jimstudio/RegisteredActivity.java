package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegisteredActivity extends AppCompatActivity {

    EditText username , password , confrompassword , Email;
    TextInputLayout username_text , comfrom_password_text , email_test;
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered);
        iten();
        hint_test();
        username.addTextChangedListener(new RegisterdTextWatcher(username));


//        bt_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String pas = password.getText().toString();
//                final String compass = confrompassword.getText().toString();
//                if (pas.equals(compass)){
//                    Toast.makeText(getApplicationContext() , "Pass" ,
//                            Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "No Pass" , Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    public void hint_test(){
        username.setHint(R.string.user);
        password.setHint(R.string.password);
        confrompassword.setHint(R.string.comfrom_password);
        Email.setHint(R.string.email);
    }

    public void iten(){
       username = (EditText)findViewById(R.id.re_user);
        password = (EditText) findViewById(R.id.re_password);
        confrompassword = (EditText) findViewById(R.id.re_confirmPassword);
        Email = (EditText) findViewById(R.id.re_email);
        bt_register = (Button) findViewById(R.id.re_bt);
        username_text = (TextInputLayout) findViewById(R.id.re_text_user);
        comfrom_password_text = (TextInputLayout) findViewById(R.id.re_test_password_comform);
        email_test = (TextInputLayout) findViewById(R.id.re_test_email);
    }

    public boolean validateName(){

        String username_validate = username.getText().toString().trim();
        if (username_validate.length() < 8 || username_validate.length() > 17){
            username.setError(getString(R.string.long_error));
            requestFocus(username);
            return false;
        }else{
            username_text.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            Log.d("My" , "ok");
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private class RegisterdTextWatcher implements TextWatcher {

        private View view;
        private RegisterdTextWatcher(View view){
            this.view = view;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            switch (view.getId()){

                case R.id.re_user:

                    validateName();
                    break;
            }
        }
    }
}


