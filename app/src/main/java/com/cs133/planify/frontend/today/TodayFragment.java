package com.cs133.planify.frontend.today;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs133.planify.R;
import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Event;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.backend.Task;
import com.cs133.planify.frontend.overview.TaskAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class TodayFragment extends Fragment {
    ArrayList<Task> taskList;
    ArrayList<Task> todayList;
    ArrayList<Event> eventList;

    private RecyclerView tasksRecyclerView;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Controller mController= Globals.getController();
        eventList = mController.userAcc.getEvents();
        taskList = mController.userAcc.getTasks();

        //use java.util.Calendar to get today's date
        //compare today's date to the date of each task
        //if the dates match, add the task to todayList
        todayList = new ArrayList<Task>();

        // Get today's date
        Calendar cal = Calendar.getInstance();
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        int currentMonth = cal.get(Calendar.MONTH) + 1; // Java's Calendar.MONTH is 0-based, so we add 1 to get the correct month

        // Loop through all tasks in taskList
        for (Task task : taskList) {
            // Compare the task's date with today's date
            if (currentDay == task.getDay() && currentMonth == task.getMonth()) {
                // If the dates match, add the task to the todayList
                todayList.add(task);
            }
        }

        System.out.println("TodayFragment: onCreate: taskList: " + taskList);
        System.out.println("TodayFragment: onCreate: eventList: " + eventList);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        System.out.println("OverviewFragment: onCreateView: todayList: " + todayList);

        tasksRecyclerView = view.findViewById(R.id.recyclerview);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TaskAdapter taskAdapter = new TaskAdapter(todayList);
        tasksRecyclerView.setAdapter(taskAdapter);

        return view;
    }
}
