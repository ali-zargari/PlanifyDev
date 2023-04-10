package com.cs133.planify;

import java.util.ArrayList;
public class Calendar{
    ArrayList<Week> weeks;
    int weeknumber=5;
    public Calendar(String name){
         weeks = new ArrayList<>();
         weeks.add(new Week(1));
         weeks.add(new Week(2));
         weeks.add(new Week(3));
         weeks.add(new Week(4));
         weeks.add(new Week(5));

    }
    public void progress(){
        weeks.remove(0);
        weeknumber++;
        weeks.add(new Week(weeknumber));
    }
}