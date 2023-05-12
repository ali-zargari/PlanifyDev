package com.cs133.planify.backend;

public class Event {
    private String name;
    private String description;
    private int start;
    private int end;
    private boolean status;

    public Event(String name, int start, int end, String description){
        this.name= name;
        this.start= start;
        this.end= end;
        this.description = description;
    }

    public Event(String name, int start, int end, String description, boolean status){
        this.name= name;
        this.start= start;
        this.end= end;
        this.description = description;
        this.status = status;
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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
