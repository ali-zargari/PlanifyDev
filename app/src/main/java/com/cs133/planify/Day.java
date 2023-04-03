public class Day {
    int month;
    int day;
    int year;
    ArrayList<Event> hours= new ArrayList <Event>();
    ArrayList<Event> total= new ArrayList<Event>();

    public day(int month, int day, int year){
        this.month=month;
        this.day=day;
        this.year=yaer;
        initialize();
    }

    //creates an empty day with no scheduled events
    private initialize(){
        for(int i=0;i<24; i++){
            hours.add(null);
        }
    }
    public boolean addEvent(Event newEvent){
        int start= newEvent.getStart;
        int end = newEvent.getEnd;
        //iterates once to check to see if all the spaces from start to end are empty
        for(int i=start; i= end; i++){
            if((hours.get(time)!=null){
                return false;
            }
        }
        // checks if theres any events with same name
        for(x in total){
            if(x.getName== newEvent.getName){
                return false;
            }
        }
        //iterates again to fill up all the events
        for(int i=start; i= end; i++){
            hours.set(i,newEvent);
        }
        //add event to total
        total.add(newEvent);
        return true;
    }
    //removes from all hours and the event
    public returnEvent(Event removedEvent){
        int start= removedEvent.getStart;
        int end = removedEvent.getEnd;
        for(int i=start; i= end; i++){
            hours.set(i,null);
        }
        totalEvent.remove(removedEvent);
    }
}
