package com.cs133.planify.backend;

public class Event {
    private String name;
    private String description;
    private int month;
    private int day;
    private boolean status;

    private String IDString;

    public Event(String name, int month, int day, String description){
        this.name= name;
        this.month= month;
        this.day= day;
        this.description = description;
        this.status=false;
        IDString= (name+month+day+ ((int) (Math.random() * 100000)+1));
    }

    public Event(String name, int month, int day, String description, boolean status){
        this.name= name;
        this.month= month;
        this.day= day;
        this.description = description;
        this.status = status;
        IDString= (name+month+day+ ((int) (Math.random() * 100000)+1));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int start) {
        this.month = start;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int end) {
        this.day = day;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getIDString(){
        return IDString;
    }
}
