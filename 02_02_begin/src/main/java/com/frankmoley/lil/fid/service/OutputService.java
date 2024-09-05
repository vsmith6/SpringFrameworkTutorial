package com.frankmoley.lil.fid.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.frankmoley.lil.fid.aspect.Countable;

@Service
public class OutputService {

	@Value("${app.name}")
	private String name;
    private final GreetingService greetingService;
    private final TimeService timeService;

    public OutputService(GreetingService greetingService, TimeService timeService){
        this.greetingService = greetingService;
        this.timeService = timeService;
       
    }
    @Countable
    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }

}
