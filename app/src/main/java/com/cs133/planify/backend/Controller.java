package com.cs133.planify.backend;
import java.util.ArrayList;
public class Controller {
    Account ThisAccount;
    ArrayList AccountsList = new ArrayList<Account>();
    public void setAccount(Account newAcc){
        this.ThisAccount= newAcc;
    }

    public Event searchEvent(){
        return null;
    }
    public Day searchDay(){
        return null;

    }
    public boolean addEvent(){
        return false;

    }
    public boolean addWeek(){
       return false;
    }
    public ArrayList<Event> getAllEvents(){
        return null;

    }
}
