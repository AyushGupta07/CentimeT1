package com.centime.greetingmicroservice.service;

import com.centime.greetingmicroservice.model.Person;
import com.centime.greetingmicroservice.util.HttpUrlCall;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;

@Service
public class GreetingService {

    public String greetPerson(Person person) {

        String nameResponse = HttpUrlCall.sendReqHttpPost(person,"http://ec2-65-0-133-148.ap-south-1.compute.amazonaws.com:8082/api/concatenate");

        String helloResponse = HttpUrlCall.sendReqHttpGet("http://ec2-43-205-95-52.ap-south-1.compute.amazonaws.com:8081/api/hello");

        return helloResponse + " " + nameResponse;
    }

    public void validateRequest(Person person) throws Exception {
        if(person.getName() == null || StringUtils.isEmpty(person.getName())) {
            throw new MissingServletRequestParameterException("name", "String");
        }
        if(person.getSurname() == null || StringUtils.isEmpty(person.getSurname())) {
            throw new MissingServletRequestParameterException("surname", "String");
        }
    }
}
