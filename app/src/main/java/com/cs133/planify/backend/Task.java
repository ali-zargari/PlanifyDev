package com.cs133.planify.backend;

public class Task {
    public String IDString;
    String Description;

    Boolean Completion;

    String Name;
    int month;
    int day;

    public Task(String NameString, String DescString){
        Name= NameString;
        IDString=( Name+ ((int) (Math.random() * 100000) + 1));
        Description= DescString;
        Completion= false;
    }

    public Task(String NameString, int day, int month, String DescString){
        Name= NameString;
        IDString=( Name+ ((int) (Math.random() * 100000) + 1));
        Description= DescString;
        Completion= false;
        this.month= month;
        this.day= day;
    }

    public String getDescription() {
        return Description;
    }

    public String getIDString() {
        return IDString;
    }

    public void setIDString(String IDString) {
        this.IDString = IDString;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCompletion(Boolean completion) {
        Completion = completion;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return Name;
    }

    public boolean getCompletion() {
        return Completion;
    }
}
