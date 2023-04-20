
package com.cs133.planify.backend;
import java.util.ArrayList;
public class Account {
    private ArrayList<Calendar> sharedCalendars= new ArrayList<Calendar>();
    private String password;
    private String name;
    private Calendar mainCalendar;


    public Account(){
        // Default constructor required for calls to DataSnapshot.getValue(Account.class)


    }

    public Account(String name, String password, Calendar mainCalendar) {
        this.name = name;
        this.password = password;
        this.mainCalendar = mainCalendar;
    }

    public ArrayList<Calendar> getCalendars() {
        return sharedCalendars;
    }

    public void setCalendars(ArrayList<Calendar> calendars) {
        this.sharedCalendars = calendars;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Calendar getMainCalendar() {
        return mainCalendar;
    }

    public void setMainCalendar(Calendar mainCalendar) {
        this.mainCalendar = mainCalendar;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void addCalendar(Calendar calendar) {
        sharedCalendars.add(calendar);
    }

    public void removeCalendar(Calendar calendar) {
        sharedCalendars.remove(calendar);
    }



}
