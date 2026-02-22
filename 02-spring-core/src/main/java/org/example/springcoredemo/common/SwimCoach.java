package org.example.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("SwimCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice swimming for 10 minutes!!!";
    }
}
