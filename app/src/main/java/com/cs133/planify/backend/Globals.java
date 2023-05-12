package com.cs133.planify.backend;

public class Globals {
     public static Controller mController;

     public static void setController( Controller inputController){
          mController= inputController;
     }
     public static Controller getController(){
          return mController;
     }
}
