package com.cs133.planify.frontend.CreateTask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Event;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.backend.Task;

import java.util.ArrayList;

public class CreateTaskFragment extends Fragment {
    Controller mController;
    ArrayList<Task> TaskList;
    ArrayList<Event> EventList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Controller mController= Globals.getController();
        EventList= mController.userAcc.getEvents();
        TaskList= mController.userAcc.getTasks();


    }
    //take task and add to account
    public void addTaskFromUI(Task newTask) throws Exception{
        Globals.mController.userAcc.addTask(newTask);
        Globals.mController.updateDB();
    }
    //takes task and shares to email
    public void shareTaskFromUI(Task newTask, String Email) throws Exception{
        Globals.mController.shareTask(newTask,Email);
        Globals.mController.updateDB();
    }
}
