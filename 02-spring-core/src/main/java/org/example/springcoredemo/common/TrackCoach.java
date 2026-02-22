package org.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach(){
       // System.out.println("TrackCoach constructor");
    }
    public String getDailyWorkout(){
        return "Practice running for 30 minutes!!!";
    }
}
