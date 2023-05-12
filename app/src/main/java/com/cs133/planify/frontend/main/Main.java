package com.cs133.planify.frontend.main;

import static android.util.Log.d;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.cs133.planify.R;
import com.cs133.planify.frontend.calendar.Calendar;
import com.cs133.planify.frontend.login.Login;
import com.cs133.planify.frontend.plan.PlanFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {

    private NavController navController;

    Calendar calendarFragment = new Calendar();
    //SettingsFragment todayFragment = new SettingsFragment();
    PlanFragment planFragment = new PlanFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //toast message
        d("Main", "Welcome to Planify!");

        //add listeners to the bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //add listeners to each item in the bottom navigation bar
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            //log view
            d("Main", "Bottom navigation bar item clicked");

            //get id of the clicked item
            int id = item.getItemId();

            //Log the id
            d("Main", "Clicked item id: " + id);

            //switch to the corresponding fragment
            switch (id) {
                case R.id.nav_calendar:
                    //log view
                    //load calendar fragment
                    d("Main", "Calendar item clicked");

                    //switch to calendar fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, calendarFragment).commit();
                    break;
                case R.id.nav_plan:
                    //log view
                    d("Main", "Plan item clicked");

                    //switch to plan fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, planFragment).commit();
                    break;
                case R.id.nav_settings:
                    //log view
                    d("Main", "Settings item clicked");

                    //switch to settings fragment
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, todayFragment).commit();
                    break;

            }

            return true;
        });




        d("Main", "Bottom navigation bar: " + bottomNavigationView);
        bottomNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //log view
                d("Main", "Bottom navigation bar clicked");

                //get id of the clicked item
                int id = view.getId();

                //Log the id
                d("Main", "Clicked item id: " + id);



            }
        });




    }


}