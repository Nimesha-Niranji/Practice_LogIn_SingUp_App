package com.example.practice_login_signup_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUserName, edPassword;
    Button btnLogin, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUserName = findViewById(R.id.editUserName);
        edPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnlogin);
        btnSignup = findViewById(R.id.btnsignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prf = getSharedPreferences("Details", Context.MODE_PRIVATE);
                String UsrName = prf.getString("USER_NAME",null);
                String Pwd = prf.getString("PASSWORD",null);

                String UN_frm_ed = edUserName.getText().toString();
                String PWD_frm_ed = edPassword.getText().toString();

                if(UsrName != null && UN_frm_ed != null && UsrName.equalsIgnoreCase(UN_frm_ed)){
                    if(Pwd != null && PWD_frm_ed != null && Pwd.equalsIgnoreCase(PWD_frm_ed) ){
                        Toast.makeText(MainActivity.this,"Login Successful.",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Login Failed.",Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Login Failed.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}