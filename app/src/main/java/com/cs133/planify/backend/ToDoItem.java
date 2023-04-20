package com.cs133.planify.backend;

public class ToDoItem {
    private String name;
    private String description;
    private String date;
    private String time;
    private String priority;

    public ToDoItem(String name, String description, String date, String time, String priority) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
