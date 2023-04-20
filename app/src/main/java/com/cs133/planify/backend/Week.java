package com.cs133.planify.backend;
import java.util.ArrayList;
public class Week {
    int number;
    ArrayList<Day> days= new ArrayList<>();

    public void initialize(){
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
    }
    public Day getDay(int dayofweek){
        return days.get(dayofweek-1);
    }
    public Week(int number){
        this.number= number;
        initialize();
    }
}
