package com.cs133.planify.frontend.today;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Event;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.backend.Task;

import java.util.ArrayList;

public class TodayFragment extends Fragment {
    ArrayList<Task> TaskList;
    ArrayList<Event> EventList;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Controller mController= Globals.getController();
        EventList= mController.userAcc.getEvents();
        TaskList= mController.userAcc.getTasks();


    }
}
