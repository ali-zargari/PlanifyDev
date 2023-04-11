
package com.cs133.planify;
import java.util.ArrayList;
public class Account {
    ArrayList<CalendarData> calendars= new ArrayList<>();
    private String password;
    public String name;
    public CalendarData MainCalendar;
    public String getPassword() {
        return password;
    }
    public String getName(){
        return this.name;
    }


}
