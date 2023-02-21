package com.centime.greetingmicroservice.controller;

import com.centime.greetingmicroservice.model.Person;
import com.centime.greetingmicroservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/greeting")
public class GreetingWebController {

    @Autowired
    GreetingService greetingService;

    @GetMapping
    public String getServiceStatus() {
        return "Up";
    }

    @PostMapping
    public ResponseEntity<String> greetPerson(@Valid @RequestBody Person person) throws Exception{
        greetingService.validateRequest(person);
        String response =  greetingService.greetPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
