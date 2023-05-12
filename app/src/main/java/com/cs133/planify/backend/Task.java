package com.cs133.planify.backend;

public class Task {
    public String IDString;
    String Description;

    Boolean Completion;

    String Name;

    public Task(String NameString, String DescString){
        Name= NameString;
        IDString=( Name+ ((int) (Math.random() * 100000) + 1));
        Description= DescString;
        Boolean Completion= false;
    }

}
