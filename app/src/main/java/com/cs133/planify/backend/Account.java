
package com.cs133.planify.backend;
import java.util.ArrayList;
public class Account {
    private ArrayList<Calendar> calendars= new ArrayList<>();
    private String password;
    private String name;
    private Calendar MainCalendar;


    public Account(){
        // Default constructor required for calls to DataSnapshot.getValue(Account.class)


    }
    public ArrayList<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(ArrayList<Calendar> calendars) {
        this.calendars = calendars;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Calendar getMainCalendar() {
        return MainCalendar;
    }

    public void setMainCalendar(Calendar mainCalendar) {
        MainCalendar = mainCalendar;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void addCalendar(Calendar calendar) {
        calendars.add(calendar);
    }

    public void removeCalendar(Calendar calendar) {
        calendars.remove(calendar);
    }



}
