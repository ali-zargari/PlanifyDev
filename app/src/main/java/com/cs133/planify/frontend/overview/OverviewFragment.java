package com.cs133.planify.frontend.overview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs133.planify.R;
import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Event;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.backend.Task;

import java.util.ArrayList;

public class OverviewFragment extends Fragment {
    Controller mController;
    ArrayList<Task> taskList;
    ArrayList<Event> eventList;
    private RecyclerView tasksRecyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Controller mController= Globals.getController();
        eventList = mController.userAcc.getEvents();
        taskList = mController.userAcc.getTasks();


        //logcat test
        System.out.println("OverviewFragment: onCreate: taskList: " + taskList);
        System.out.println("OverviewFragment: onCreate: eventList: " + eventList);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        System.out.println("OverviewFragment: onCreateView: taskList: " + taskList);

        tasksRecyclerView = view.findViewById(R.id.recyclerview);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TaskAdapter taskAdapter = new TaskAdapter(taskList);
        tasksRecyclerView.setAdapter(taskAdapter);

        return view;
    }

    public void markTaskCompleteUI(Task newTask){
        Globals.mController.userAcc.markTaskasTrue(newTask);
        //uncomment below function for it to automatically remove all tasks when marked as true
        //Globals.mController.userAcc.purgeCompleted();
        Globals.mController.updateDB();
        Globals.mController.updateLocal();
    }
}
