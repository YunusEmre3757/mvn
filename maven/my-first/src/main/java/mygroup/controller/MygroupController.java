package mygroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mygroup.MygroupService;

@RestController
public class MygroupController {

    private final MygroupService mygroupService;

    @Autowired
    public MygroupController(MygroupService mygroupService) {
        this.mygroupService = mygroupService;
    }
    
    @GetMapping("/")
    public String home() {
        return "Mygroup Web Application is running!";
    }
    
    @GetMapping("/greeting")
    public String greeting() {
        return mygroupService.getGreeting();
    }
} 