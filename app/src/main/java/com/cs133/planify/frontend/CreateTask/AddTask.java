package com.cs133.planify.frontend.CreateTask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cs133.planify.R;
import com.cs133.planify.backend.Controller;
import com.cs133.planify.backend.Event;
import com.cs133.planify.backend.Globals;
import com.cs133.planify.backend.Task;

public class AddTask extends Fragment {

    Controller mController = Globals.getController();;

    private EditText taskNameInput;
    private EditText taskDescriptionInput;
    private EditText taskDayInput;
    private EditText taskMonthInput;
    private EditText shareWithEmailInput;
    private CheckBox shareCheckBox;

    private String taskName;
    private String taskDescription;
    private int taskDay;
    private int taskMonth;
    private String shareWithEmail;
    private boolean share;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_task, container, false);



        taskNameInput = view.findViewById(R.id.taskNameInput);
        taskDescriptionInput = view.findViewById(R.id.taskDescriptionInput);
        taskDayInput = view.findViewById(R.id.taskDayInput);
        taskMonthInput = view.findViewById(R.id.taskMonthInput);
        shareWithEmailInput = view.findViewById(R.id.shareWithEmailInput);
        shareCheckBox = view.findViewById(R.id.shareCheckBox);
        Button submitTaskButton = view.findViewById(R.id.submitTaskButton);

        submitTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskName = taskNameInput.getText().toString();
                taskDescription = taskDescriptionInput.getText().toString();
                taskDay = Integer.parseInt(taskDayInput.getText().toString());
                taskMonth = Integer.parseInt(taskMonthInput.getText().toString());
                shareWithEmail = shareWithEmailInput.getText().toString();
                share = shareCheckBox.isChecked();

                // Now you have all the inputs in variables and you can do whatever you want with them
                // print them to the console
                System.out.println("taskName: " + taskName);
                System.out.println("taskDescription: " + taskDescription);
                System.out.println("taskDay: " + taskDay);
                System.out.println("taskMonth: " + taskMonth);
                System.out.println("shareWithEmail: " + shareWithEmail);
                System.out.println("share: " + share);

                //TODO: Send to Backend
                Task newTask= new Task(taskName,taskDay,taskMonth,taskDescription);

                try {
                    addTaskFromUI(newTask);
                    System.out.println("add task succeeded");
                } catch (Exception e){
                    throw new RuntimeException("add task failed");
                }
                if(shareCheckBox.isChecked()== true){
                    try {
                        shareTaskFromUI(newTask, shareWithEmail);
                    }
                    catch (Exception e) {
                        throw new RuntimeException("add task failed");
                    }
                }


            }
        });


        return view;
    }

    public void addTaskFromUI(Task newTask) throws Exception{
        Globals.mController.userAcc.addTask(newTask);
        Globals.mController.updateDB();
        Globals.mController.updateLocal();

    }
    //takes event object and shares it to the email
    public void shareTaskFromUI(Task newTask, String Email) throws Exception{
        Globals.mController.shareTask(newTask,Email);
        Globals.mController.updateDB();
        Globals.mController.updateLocal();
    }
}
