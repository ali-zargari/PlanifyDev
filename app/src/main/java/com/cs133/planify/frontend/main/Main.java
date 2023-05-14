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
import com.cs133.planify.backend.Account;
import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.frontend.CreateTask.AddTask;
import com.cs133.planify.frontend.calendar.Calendar;
import com.cs133.planify.frontend.login.Login;
import com.cs133.planify.frontend.overview.OverviewFragment;
import com.cs133.planify.frontend.plan.PlanFragment;
import com.cs133.planify.frontend.settings.SettingsFragment;
import com.cs133.planify.frontend.today.TodayFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {

    private NavController navController;
    Controller mController;

    Calendar calendarFragment = new Calendar();
    //SettingsFragment todayFragment = new SettingsFragment();
    PlanFragment planFragment = new PlanFragment();
    OverviewFragment overviewFragment = new OverviewFragment();
    TodayFragment todayFragment = new TodayFragment();
    AddTask addTaskFragment = new AddTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mController= Globals.getController();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mController.userAcc.testPopulate();

        //Account account = mController.userAcc;
        d("Main", "Account: " + mController.email);

        for(int i = 0; i < mController.userAcc.getEvents().size(); i++) {
            d("Main", "Event " + i + ": " + mController.userAcc.getEvents().get(i).getName());
        }

        //toast message
        d("Controller", "Welcome to Planify!");

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

                case R.id.nav_today:
                    //log view
                    d("Main", "Today item clicked");

                    //switch to today fragment

                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, todayFragment).commit();
                    break;


                case R.id.nav_overview:
                    //log view
                    d("Main", "Overview item clicked");

                    //switch to overview fragment

                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, overviewFragment).commit();
                    break;

                case R.id.nav_settings:
                    //log view
                    d("Main", "Settings item clicked");

                    //switch to settings fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, addTaskFragment).commit();
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