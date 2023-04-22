package com.cs133.planify.backend;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;

import java.util.HashMap;
import java.util.Map;
public class Controller {
    Account userAcc;
    FirebaseAuth mAuth;
    DatabaseReference DBref;
    FirebaseDatabase userDB;

    DataSnapshot snapshot;
    String URL;

    Account ThisAccount;
    ArrayList AccountsList = new ArrayList<Account>();
    public void setAccount(Account newAcc){
        this.ThisAccount= newAcc;
    }
    //intialize controller must be run the first time an account as created, will create a child in database with information on user Account
    public void initalizeDatabase(){
        // uses mAuth to get user ID and creates a new mainCalendar object with ID empty calendar
        userAcc= new Account(mAuth.getUid(),new Calendar("mainCalendar"));
        //intializes database reference
        userDB= FirebaseDatabase.getInstance();
        DBref= userDB.getReference();
        // craetes map and uses it to initialize data locales
        DBref.updateChildren(Account.toMap(userAcc));
    }
    public void updateDB(){
        //updates all children values in database with current values in the calendar
        DBref.updateChildren(Account.toMap(userAcc));
    }

    public void updateLocal(){

    }


}
