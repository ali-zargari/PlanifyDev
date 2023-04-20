package com.cs133.planify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs133.planify.frontend.login.Login;
import com.cs133.planify.frontend.register.Register;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        //find button with id login_button
        Button login_btn = findViewById(R.id.have_account_button);
        System.out.println("login button: " + login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open login page
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

            }
        });

        Button register_btn = findViewById(R.id.register_button);
        System.out.println("register button: " + register_btn);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open register page
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        });

    }

}