package com.cs133.planify.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cs133.planify.Controller;
import com.cs133.planify.R;
import com.cs133.planify.ui.main.Main;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Go to the main activity
        Button login_btn = findViewById(R.id.login_button);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open login page
                Intent intent = new Intent(Login.this, Main.class);
                startActivity(intent);

            }
        });

    }
}