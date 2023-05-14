package com.cs133.planify.frontend.today;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Event;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.backend.Task;

import java.util.ArrayList;

public class TodayFragment extends Fragment {
    ArrayList<Task> taskList;
    ArrayList<Task> todayList;
    ArrayList<Event> eventList;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Controller mController= Globals.getController();
        eventList = mController.userAcc.getEvents();
        taskList = mController.userAcc.getTasks();

        //use java.util.Calendar to get today's date
        //compare today's date to the date of each task
        //if the dates match, add the task to todayList
        todayList = new ArrayList<Task>();


        System.out.println("TodayFragment: onCreate: taskList: " + taskList);
        System.out.println("TodayFragment: onCreate: eventList: " + eventList);

    }
}
