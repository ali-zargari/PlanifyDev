
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
    //calls only on initailize for dataabse when account created
    public Account(String name, Calendar mainCalendar) {
        this.name = name;
        this.mainCalendar = mainCalendar;
        sharedCalendars= new ArrayList<>();
        sharedCalendars.add(new Calendar("ExampleCalendar"));
        tasks= new ArrayList<>();
        tasks.add( new Task("example","exampleTask"));

        events= new ArrayList<>();
        events.add(new Event("example", 0, 0, "example description"));

        //populate only for testing purposes
        testPopulate();
        // comment out on final product


    }
    //called whenever app loads
    public Account(String name){
        this.name = name;
        this.mainCalendar = null;
        sharedCalendars= new ArrayList<>();
        tasks= new ArrayList<>();
        events= new ArrayList<>();

    }

    public static Map<String, Object> toMap(Account thisAccount) {
        Map<String, Object> result = new HashMap<>();
        result.put("mainCalendar", thisAccount.getMainCalendar());
        result.put("name", thisAccount.getName());

        return result;
    }
    public static Map<String, Object> calendartoMap(Account thisAccount){
        Map<String, Object> result= new HashMap<>();
        for(Calendar x: thisAccount.getCalendars()){
            result.put(x.getId(),x);
        }
        return result;
    }

    public static Map<String, Object> tasksToMap(Account thisAccount){
        Map<String, Object> result= new HashMap<>();
        if(thisAccount.getTasks().isEmpty()){
            return result;
        }
        for(Task x: thisAccount.getTasks()){

            result.put(x.IDString,x);
        }
        return result;
    }

    public static Map<String, Object> eventsToMap(Account thisAccount){
        Map<String, Object> result= new HashMap<>();
        if(thisAccount.getEvents().isEmpty()){
            return result;
        }
        for(Event x : thisAccount.getEvents()){

            result.put(x.getIDString(),x);
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

    public boolean addTask(Task x) throws Exception{
        name= x.IDString;
        for(Task y :tasks){
            if(y.IDString== name){
                throw new Exception("task with that name already exists");
            }
        }
        tasks.add(x);
        return true;
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
    public boolean addEvent(Event x) throws Exception{
        String name= x.getIDString();
        for(Event y: events){
            if(y.getName()== name){
                throw new Exception(" event with that name already exists");
            }
        }
        events.add(x);
        return true;
    }
    public Event searchEvent(String name){
        for(Event x: events){
            if(x.getIDString()== name){
                return x;
            }
        }
        return null;
    }

    public void deleteEvent(String name){
        for(Event x: events){
            if(x.getIDString()== name){
                events.remove(x);
            }
        }
    }

    //populates events and tasks only for testing purposes
    public void testPopulate(){
        for( int i=0; i<10; i++){
            String testString= ("testEvent"+i);
            events.add(new Event(testString,1,1 ,"empty Desc"));
        }

        for( int i=0; i<10; i++){
            String testString= ("testTask"+i);
            tasks.add(new Task(testString,"empty Desc"));
        }

    }
}
