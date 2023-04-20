package com.cs133.planify.backend;
public class Day {
    private int dayOfMonth;
    private String note;

    public Day() {
        // Default constructor required for calls to DataSnapshot.getValue(Day.class)
    }

    public Day(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        this.note = "";
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
