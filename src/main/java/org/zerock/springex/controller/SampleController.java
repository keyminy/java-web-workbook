package org.zerock.springex.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello(){
        log.info("hello........");
    }
    
    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
    	log.info("ex3...........");
    	log.info("dueDate : " + dueDate);
    }
}