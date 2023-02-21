package com.centime.concatenatemicroservice.service;

import com.centime.concatenatemicroservice.model.Person;
import org.springframework.stereotype.Service;

@Service
public class ConcatenateService {

    public String concatenateName(Person person) {
        return person.getName() + " " + person.getSurname();
    }
}
