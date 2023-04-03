public class Week {
    ArrayList<Day> days= new ArrayList<>();
    public week(){
        intialize();
    }
    public initialize(){
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
        days.add(new Day(0,0,0));
    }
    public day getDay(int dayofweek){
        return days.get(dayofweek-1);
    }
}
