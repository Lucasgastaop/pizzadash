package com.pizzadash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class StatusController {
	
    @GetMapping 
    public String check() {
        return "PizzaDash API Online";
    }
    
}
