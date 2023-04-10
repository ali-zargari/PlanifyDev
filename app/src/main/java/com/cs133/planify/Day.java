package com.cs133.planify;
import java.util.ArrayList;
public class Day {
    int month;
    int day;
    int year;
    ArrayList<EventClass> hours= new ArrayList <EventClass>();
    ArrayList<EventClass> total= new ArrayList<EventClass>();

    public Day(int month, int day, int year){
        this.month=month;
        this.day=day;
        this.year=year;
        initialize();
    }

    //creates an empty day with no scheduled events
    private void initialize(){
        for(int i=0;i<24; i++){
            hours.add(null);
        }
    }
    public boolean addEvent(EventClass newEvent){
        int start= newEvent.getStart();
        int end = newEvent.getEnd();
        //iterates once to check to see if all the spaces from start to end are empty
        for(int i=start; i==end; i++){
            if((hours.get(i)!= null)){
                return false;
            }
        }
        // checks if theres any events with same name
        for(int i=0; i<total.size(); i++){
            if(total.get(i).getName()== newEvent.getName()){
                return false;
            }
        }
        //iterates again to fill up all the events
        for(int i=start; i==end; i++){
            hours.set(i,newEvent);
        }
        //add event to total
        total.add(newEvent);
        return true;
    }
    //removes from all hours and the event
    public void returnEvent(EventClass removedEvent){
        int start= removedEvent.getStart();
        int end = removedEvent.getEnd();
        for(int i=start; i==end; i++){
            hours.set(i,null);
        }
        total.remove(removedEvent);
    }
}
