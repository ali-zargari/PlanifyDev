package com.cs133.planify.backend;

import java.util.ArrayList;
import java.util.List;

public class Month {
    private int monthNumber;
    private List<Day> days;

    public Month() {
        // Default constructor required for calls to DataSnapshot.getValue(Month.class)
    }

    public Month(int monthNumber) {
        this.monthNumber = monthNumber;
        this.days = new ArrayList<>();
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public void addDay(Day day) {
        days.add(day);
    }
}
