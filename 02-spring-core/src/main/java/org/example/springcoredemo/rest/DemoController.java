package org.example.springcoredemo.rest;

import org.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependency
    private Coach myCoach;
    private Coach myOtherCoach;

    //define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                            @Qualifier("cricketCoach") Coach theAnotherCoach) {
        //System.out.println("DemoController constructor");
        myCoach = theCoach;
        myOtherCoach = theAnotherCoach;
    }

    // setter injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Check if my coach == another coach: " + (myCoach == myOtherCoach);
    }
}
