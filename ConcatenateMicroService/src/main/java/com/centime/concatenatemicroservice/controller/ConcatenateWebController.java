package com.centime.concatenatemicroservice.controller;

import com.centime.concatenatemicroservice.model.Person;
import com.centime.concatenatemicroservice.service.ConcatenateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/concatenate")
public class ConcatenateWebController {

    @Autowired
    ConcatenateService concatenateService;

    @PostMapping
    public ResponseEntity<String> concatenateName(@RequestBody Person person){
        String response = concatenateService.concatenateName(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
