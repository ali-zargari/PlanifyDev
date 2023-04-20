package com.cs133.planify.backend;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private String id;
    private List<Month> months;

    public Calendar() {
        // Default constructor required for calls to DataSnapshot.getValue(Calendar.class)
    }

    public Calendar(String id) {
        this.id = id;
        this.months = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Month> getMonths() {
        return months;
    }

    public void setMonths(List<Month> months) {
        this.months = months;
    }

    public void addMonth(Month month) {
        months.add(month);
    }



    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month of year: " + month);
        }

        switch (month) {
            case 2:
                return (isLeapYear(year) ? 29 : 28);
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

}
