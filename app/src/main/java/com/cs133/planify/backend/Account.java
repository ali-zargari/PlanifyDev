
package com.cs133.planify.backend;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    public ArrayList<Calendar> sharedCalendars= new ArrayList<Calendar>();
    private String password;
    private String name;
    private Calendar mainCalendar;

    private ArrayList<Task> tasks;

    private ArrayList<Event> events;




    public Account(){
        // Default constructor required for calls to DataSnapshot.getValue(Account.class)


    }

    public Account(String name, Calendar mainCalendar) {
        this.name = name;
        this.mainCalendar = mainCalendar;
        sharedCalendars= new ArrayList<>();
        sharedCalendars.add(new Calendar("ExampleCalendar"));
        tasks= new ArrayList<>();
        tasks.add( new Task("example","exampleTask"));

        events= new ArrayList<>();
        events.add(new Event("example", 0, 0, "example description"));



    }

    public static Map<String, Object> toMap(Account thisAccount) {
        Map<String, Object> result = new HashMap<>();
        result.put("mainCalendar", thisAccount.getMainCalendar());
        result.put("name", thisAccount.getName());

        return result;
    }
    public static Map<String, Object> calendartoMap(Account thisAccount){
        Map<String, Object> result= new HashMap<>();
        for(int i =0 ; i< thisAccount.getCalendars().size(); i++){
            Calendar current= thisAccount.getCalendars().get(i);
            result.put(current.getId(),current);
        }
        return result;
    }

    public static Map<String, Object> tasksToMap(Account thisAccount){
        Map<String, Object> result= new HashMap<>();
        if(thisAccount.getTasks().isEmpty()){
            return result;
        }
        for(int i =0 ; i< thisAccount.getCalendars().size(); i++){
            Task current= thisAccount.getTasks().get(i);
            result.put(current.IDString,current);
        }
        return result;
    }

    public static Map<String, Object> eventsToMap(Account thisAccount){
        Map<String, Object> result= new HashMap<>();
        if(thisAccount.getEvents().isEmpty()){
            return result;
        }
        for(int i =0 ; i< thisAccount.getCalendars().size(); i++){
            Event current= thisAccount.getEvents().get(i);
            result.put(current.getName(),current);
        }
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

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void deleteTask(String name){
        for(Task x: tasks){
            if(x.IDString== name){
                tasks.remove(x);
            }
        }
    }

    public void addTask(Task x){
        tasks.add(x);
    }


    public Task searchTask(String name){
        for(Task x: tasks){
            if(x.IDString== name){
                return x;
            }
        }
        return null;
    }

    public ArrayList<Event> getEvents(){
        return events;
    }
    public void addEvent(Event x){
        events.add(x);
    }
    public Event searchEvent(String name){
        for(Event x: events){
            if(x.getName()== name){
                return x;
            }
        }
        return null;
    }

    public void deleteEvent(String name){
        for(Event x: events){
            if(x.getName()== name){
                events.remove(x);
            }
        }
    }
}
