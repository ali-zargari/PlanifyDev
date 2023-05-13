package com.cs133.planify.frontend.CreateEvent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Event;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.backend.Task;

import java.util.ArrayList;

public class CreateEventFragment extends Fragment{
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
        //takes event object and adds to accoutn
        public void addTaskFromUI(Event newEvent) throws Exception{
            Globals.mController.userAcc.addEvent(newEvent);
            Globals.mController.updateDB();
        }
        //takes event object and shares it to the email
        public void shareTaskFromUI(Event newEvent, String Email) throws Exception{
            Globals.mController.shareEvent(newEvent,Email);
            Globals.mController.updateDB();
        }
    }


