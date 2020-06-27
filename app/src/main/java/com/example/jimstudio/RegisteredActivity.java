package com.example.jimstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.text.Editable;
import android.text.TextUtils;
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

    EditText username , password , confrompassword , email;
    TextInputLayout username_text , comfrom_password_text , password_test , email_test;
    Button bt_register;
    Intent Main_Layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered);
        iten();
        hint_test();
        username.addTextChangedListener(new RegisterdTextWatcher(username));
        password.addTextChangedListener(new RegisterdTextWatcher(password));
        confrompassword.addTextChangedListener(new RegisterdTextWatcher(confrompassword));
        email.addTextChangedListener(new RegisterdTextWatcher(email));


        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateName() || !validatePassword() || !validateConfrompassword() || !validateEmail()){
                    return;
                }else{
                    Main_Layout = new Intent(RegisteredActivity.this , MainActivity.class);
                    startActivity(Main_Layout);
                    finish();
                }
            }
        });

    }

    public void hint_test(){
        username.setHint(R.string.user);
        password.setHint(R.string.password);
        confrompassword.setHint(R.string.comfrom_password);
        email.setHint(R.string.email);
    }

    public void iten(){
       username = (EditText)findViewById(R.id.re_user);
        password = (EditText) findViewById(R.id.re_password);
        confrompassword = (EditText) findViewById(R.id.re_confirmPassword);
        email = (EditText) findViewById(R.id.re_email);
        bt_register = (Button) findViewById(R.id.re_bt);
        username_text = (TextInputLayout) findViewById(R.id.re_text_user);
        password_test = (TextInputLayout) findViewById(R.id.re_text_password);
        comfrom_password_text = (TextInputLayout) findViewById(R.id.re_test_password_comform);
        email_test = (TextInputLayout) findViewById(R.id.re_test_email);
    }

    public boolean validateName(){

        String username_validate = username.getText().toString().trim();
        if (username_validate.length() < 8 || username_validate.length() > 17){
            username_text.setError(getString(R.string.long_error));
            requestFocus(username);
            return false;
        }else{
            username_text.setErrorEnabled(false);
        }
        return true;
    }

    public boolean validatePassword(){
        String password_validate = password.getText().toString().trim();
        if (password_validate.length() < 8 || password_validate.length() > 17){
            password_test.setError(getString(R.string.long_error));
            requestFocus(password_test);
            return false;
        }else{
            password_test.setErrorEnabled(false);
        }
        return true;
    }

    public boolean validateConfrompassword(){
        String pas = password.getText().toString().trim();
         String compass = confrompassword.getText().toString().trim();

        if (pas.equals(compass)){
            comfrom_password_text.setErrorEnabled(false);
            return true;
        }else{
            comfrom_password_text.setError(getString(R.string.err_different_password));
            requestFocus(comfrom_password_text);

        }
        return false;
    }
    public boolean validateEmail(){
        String validate_email = email.getText().toString().trim();
        if (validate_email.isEmpty() || !isValidEmail(validate_email)){
            email_test.setError(getString(R.string.err_msg_email));
            requestFocus(email_test);
        }else{
            email_test.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
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

                case R.id.re_password:
                    validatePassword();
                    break;

                case R.id.re_confirmPassword:
                    validateConfrompassword();
                    break;

                case R.id.re_email:
                    validateEmail();
                    break;
            }
        }
    }
}


