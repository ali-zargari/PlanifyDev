package com.cs133.planify.backend;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import com.cs133.planify.frontend.login.Login;
import com.cs133.planify.frontend.main.Main;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
    String emailString;

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
    public Boolean initalizeDatabase(){
        // uses mAuth to get user ID and creates a new mainCalendar object with ID empty calendar
        System.out.println(emailString);
        userAcc= new Account(emailString,new Calendar("mainCalendar"));
        //intializes database reference
        userDB= FirebaseDatabase.getInstance();

        DBref= userDB.getReference().child("Users").child(emailString);
        // craetes map and uses it to initialize data locales
        DBref.updateChildren(Account.toMap(userAcc));
        updateLocal();
        return true;
    }
    // initializes the controller and connects to the database and is to be run every time that is not the first time
    public Boolean loadDatabase(){
        userAcc= new Account(emailString,new Calendar("mainCalendar"));

        userDB= FirebaseDatabase.getInstance();
        DBref= userDB.getReference().child("Users").child(emailString);
        updateLocal();
        //load database success
        return true;
    }


    public Boolean updateDB(){
        //updates all children values in database with current values in the calendar
        DBref.updateChildren(Account.toMap(userAcc));
        return true;
    }

    public void updateLocal() {
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Calendar mainCalendar = dataSnapshot.child("Users").child(emailString).getValue( Calendar.class);
                userAcc.setMainCalendar(mainCalendar);

                GenericTypeIndicator<List<Calendar>> t = new GenericTypeIndicator<List<Calendar>>() {};
                List<Calendar> calendars= dataSnapshot.child("Users").child(emailString).getValue( t );
                if(calendars !=null) {
                    ArrayList<Calendar> newcalendars = new ArrayList<>(calendars);
                    userAcc.setCalendars(newcalendars);
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
        DBref.addValueEventListener(postListener);
    }


}





