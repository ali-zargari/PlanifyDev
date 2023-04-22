
package com.cs133.planify.backend;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private ArrayList<Calendar> sharedCalendars= new ArrayList<Calendar>();
    private String password;
    private String name;
    private Calendar mainCalendar;




    public Account(){
        // Default constructor required for calls to DataSnapshot.getValue(Account.class)


    }

    public Account(String name, Calendar mainCalendar) {
        this.name = name;
        this.mainCalendar = mainCalendar;
    }

    public static Map<String, Object> toMap(Account thisAccount) {
        Map<String, Object> result = new HashMap<>();
        result.put("mainCalendar", thisAccount.getMainCalendar());
        result.put("calendars", thisAccount.getCalendars());
        result.put("name", thisAccount.getName());

        return result;
    }
    //function to be called to update the account calendar values every time a change is made on the database
    public void update(Map<String, Object> map){
        setMainCalendar((Calendar) map.get("mainCalendar"));
        setCalendars((ArrayList<Calendar>) map.get("calendars"));
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
