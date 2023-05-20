package com.cs133.planify.backend;

public class Task {
    public String DBIdentifier;
    String Description;

    Boolean Completion;

    String Name;
    int month;
    int day;

    public Task(String NameString, String DescString){
        Name= NameString;
        DBIdentifier=( Name+ ((int) (Math.random() * 100000) + 1));
        Description= DescString;
        Completion= false;
    }
    public Task(){

    }

    public Task(String NameString, int day, int month, String DescString){
        Name= NameString;
        DBIdentifier=( Name+ ((int) (Math.random() * 100000) + 1));
        Description= DescString;
        Completion= false;
        this.month= month;
        this.day= day;
    }
    public Task(String NameString, int day, int month, String DescString,String DBIndentifier){
        Name= NameString;
        DBIdentifier=( DBIdentifier);
        Description= DescString;
        Completion= false;
        this.month= month;
        this.day= day;
    }

    public String getDescription() {
        return Description;
    }

    public String getIDString() {
        return DBIdentifier;
    }

    public void setIDString(String IDString) {
        this.DBIdentifier = IDString;
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
