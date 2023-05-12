package com.cs133.planify.backend;

import android.content.Intent;
import android.service.controls.Control;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import com.cs133.planify.frontend.login.Login;
import com.cs133.planify.frontend.main.Main;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.FirebaseError;
import java.util.List;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.HashMap;
import java.util.Map;
public class Controller {
    Account userAcc;
    FirebaseAuth mAuth;
    DatabaseReference DBref;
    FirebaseDatabase userDB;

    DataSnapshot snapshot;
    String URL;
    public String emailString;

    Account ThisAccount;
    ArrayList AccountsList = new ArrayList<Account>();
    public Controller( String email){
        emailString= email;
        emailString = emailString.replace("@","");
        emailString = emailString.replace(".","");


        System.out.println("email name is " + emailString);

    }

    public void setAccount(Account newAcc){
        this.ThisAccount= newAcc;
    }
    //intialize controller must be run the first time an account as created, will create a child in database with information on user Account
    public static Boolean initalizeDatabase(Controller inputController){
        String emailString= inputController.emailString;
        // uses mAuth to get user ID and creates a new mainCalendar object with ID empty calendar
        System.out.println(emailString);
        Account userAcc= new Account(emailString,new Calendar("mainCalendar"));
        //intializes database reference
        FirebaseDatabase userDB= FirebaseDatabase.getInstance();

        DatabaseReference DBref= userDB.getReference().child("Users").child(emailString);
        // craetes map and uses it to initialize data locales
        DBref.updateChildren(Account.toMap(userAcc));
        DBref= userDB.getReference().child("Users").child(emailString).child("sharedCalendars");
        DBref.updateChildren(Account.calendartoMap(userAcc));
        DBref= userDB.getReference().child("Users").child(emailString).child("tasks");
        DBref.updateChildren(Account.tasksToMap(userAcc));
        DBref= userDB.getReference().child("Users").child(emailString).child("Events");
        DBref.updateChildren(Account.tasksToMap(userAcc));
        inputController.setAccount(userAcc);
        updateLocal(inputController);

       // for testing: share( new Calendar("test shared calendar"), "test7@gmail.com");
        return true;
    }
    // initializes the controller and connects to the database and is to be run every time that is not the first time
    public static Boolean loadDatabase(Controller inputController){
        String emailString= inputController.emailString;

        Account userAcc= new Account(emailString);
        FirebaseDatabase userDB= FirebaseDatabase.getInstance();
       DatabaseReference DBref= userDB.getReference().child("Users").child(emailString);
       inputController.setAccount(userAcc);
        updateLocal(inputController);
        //load database success
        return true;
    }


    public static Boolean updateDB(Controller inputController){
        //updates all children values in database with current values in the calendar
        Account userAcc= inputController.userAcc;
        String emailString= inputController.emailString;
        FirebaseDatabase userDB = FirebaseDatabase.getInstance();
        DatabaseReference DBref= userDB.getReference().child("Users").child(emailString);
        DBref.updateChildren(Account.toMap(userAcc));
        DBref= userDB.getReference().child("Users").child(emailString).child("sharedCalendars");
        DBref.updateChildren(Account.calendartoMap(userAcc));
        DBref= userDB.getReference().child("Users").child(emailString).child("tasks");
        DBref.updateChildren(Account.tasksToMap(userAcc));
        DBref= userDB.getReference().child("Users").child(emailString).child("Events");
        DBref.updateChildren(Account.tasksToMap(userAcc));
        updateLocal(inputController);
        return true;
    }

    public static void updateLocal(Controller inputController) {
        String emailString = inputController.emailString;
        Account userAcc= inputController.userAcc;
        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Calendar mainCalendar = dataSnapshot.child("Users").child(emailString).child("Calendar").getValue( Calendar.class);
                userAcc.setMainCalendar(mainCalendar);

                String name = dataSnapshot.child("Users").child(emailString).child("name").getValue( String.class);
                userAcc.setMainCalendar(mainCalendar);

                for (DataSnapshot child : dataSnapshot.child("Users").child(emailString).child("calendars").getChildren()) {
                    userAcc.addCalendar(child.getValue(Calendar.class));
                }
                for (DataSnapshot child : dataSnapshot.child("Users").child(emailString).child("tasks").getChildren()) {
                    try{
                        userAcc.addTask(child.getValue(Task.class));
                    }
                    catch( Exception IE)
                    {
                        System.out.println(IE.getMessage());
                    }
                }
                for (DataSnapshot child : dataSnapshot.child("Users").child(emailString).child("events").getChildren()) {

                    try{
                        userAcc.addEvent(child.getValue(Event.class));
                    }
                    catch( Exception IE)
                    {
                        System.out.println(IE.getMessage());
                    }
                }

                    System.out.println("grabbing data success");
                // ..
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println("grabbing data failed");
            }
        };
        inputController.DBref.addValueEventListener(postListener);
    }
    // takes user email and a seleccted calnedar, will deposit a copy of that  calendar in the user email , if there is a calendar of the same id it will be overwritten
    public boolean shareCalendar( Calendar newCalendar, String email){
        email = email.replace("@","");
        email = email.replace(".","");
      FirebaseDatabase mDB= FirebaseDatabase.getInstance();
      DatabaseReference mRef = mDB.getReference().child("Users").child(email).child("sharedCalendars").child(newCalendar.getId());
      mRef.setValue(newCalendar);
      System.out.println("Share Success");
      return true;
        }

    public boolean shareTask(Task newTask, String email){
        email = email.replace("@","");
        email = email.replace(".","");
        FirebaseDatabase mDB= FirebaseDatabase.getInstance();
        DatabaseReference mRef = mDB.getReference().child("Users").child(email).child("tasks").child(newTask.IDString);
        mRef.setValue(newTask);
        System.out.println("Share Success");
        return true;
    }

    public boolean shareEvent(Event newEvent, String email){
        email = email.replace("@","");
        email = email.replace(".","");
        FirebaseDatabase mDB= FirebaseDatabase.getInstance();
        DatabaseReference mRef = mDB.getReference().child("Users").child(email).child("tasks").child(newEvent.getIDString());
        mRef.setValue(newEvent);
        System.out.println("Share Success");
        return true;
    }




}





