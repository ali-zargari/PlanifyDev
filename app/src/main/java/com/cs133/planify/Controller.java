package com.cs133.planify;
import java.util.ArrayList;
public class Controller {
    Account ThisAccount;
    ArrayList AccountsList = new ArrayList<Account>();
    public void setAccount(Account newAcc){
        this.ThisAccount= newAcc;
    }
    public boolean CheckPassword(Account account, String guess){
        if (account.getPassword()== guess) {
            return true;
        }
        return false;
    }

    public Account SearchAccount(String name){
        for(int i=0;  i<AccountsList.size();i++){
            Account searching= (Account) AccountsList.get(i);
            if(searching.getName()==name ){
                return searching;
            }
        }
        return null;
    }






    
    public EventClass searchEvent(){
        return null;
    }
    public Day searchDay(){
        return null;

    }
    public boolean addEvent(){
        return false;

    }
    public boolean addWeek(){
       return false;
    }
    public ArrayList<EventClass> getAllEvents(){
        return null;

    }
}
