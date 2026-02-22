package org.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("CricketCoach constructor");
    }

//    @PostConstruct
//    public void init(){
//        System.out.println("CricketCoach init method");
//    }
//
//    @PreDestroy
//    public void destroy(){
//        System.out.println("CricketCoach destroy method");
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }
}
