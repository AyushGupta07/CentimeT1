package com.centime.greetingmicroservice.service;

import com.centime.greetingmicroservice.model.Person;
import com.centime.greetingmicroservice.util.HttpUrlCall;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GreetingService {

    public static final Gson gson = new Gson();

    public String greetPerson(Person person) {

        if(person.getName() == null || StringUtils.isEmpty(person.getName())) {
            return "name is missing.";
        }
        if(person.getSurname() == null || StringUtils.isEmpty(person.getSurname())) {
            return "surname is missing.";
        }

        String nameResponse = HttpUrlCall.sendReqHttpPost(person,"http://ec2-65-0-133-148.ap-south-1.compute.amazonaws.com:8082/api/concatenate");

        String helloResponse = HttpUrlCall.sendReqHttpGet("http://ec2-43-205-95-52.ap-south-1.compute.amazonaws.com:8081/api/hello");

        return helloResponse + " " + nameResponse;
    }
}
