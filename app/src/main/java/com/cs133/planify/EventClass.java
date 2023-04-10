package com.cs133.planify;

public class EventClass {
     String name;
     String description;
     int start;
     int end;
    public EventClass(String name,int start,int end,String description){
        this.name= name;
        this.start= start;
        this.end= end;
        this.description = description;
    }
    public int getStart(){
        return end;
    }
    public int getEnd(){
        return this.end;
    }

    public String getName(){
        return this.name;
    }
}
