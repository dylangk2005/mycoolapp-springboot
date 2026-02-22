package org.example.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach(){
        //System.out.println("TennisCoach constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice tennis for 20 minutes!!!";
    }
}
