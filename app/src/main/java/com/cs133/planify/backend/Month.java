package com.cs133.planify.backend;

import java.util.Arrays;
import java.util.List;

public class Month {
    private int monthNumber;
    private int year;
    private List<Day> days;

    public Month() {
        // Default constructor required for calls to DataSnapshot.getValue(Month.class)
    }


    public Month(int monthNumber, int year) {
        this.days = Arrays.asList(new Day[Calendar.getDaysInMonth(monthNumber, year)]);
        this.monthNumber = monthNumber;
        for(int i = 0; i < days.size(); i++) {
            days.set(i, new Day(i));
        }
    }


    public Month(int monthNumber) {
        this.monthNumber = monthNumber;
        this.days = Arrays.asList(new Day[Calendar.getDaysInMonth(monthNumber, year)]);
        this.year = 2020;
        for(int i = 0; i < days.size(); i++) {
            days.set(i, new Day(i));
        }
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

    public void setDays(Day[] days) {
        this.days = Arrays.asList(days);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
