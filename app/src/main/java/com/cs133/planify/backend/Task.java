package com.cs133.planify.backend;

public class Task {
    public String IDString;
    String Description;

    Boolean Completion;

    public Task(String IDstring, String DescString){
        IDString= IDstring;
        Description= DescString;
        Boolean Completion= false;
    }

}
