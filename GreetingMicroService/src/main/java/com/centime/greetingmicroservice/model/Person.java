package com.centime.greetingmicroservice.model;

import javax.validation.constraints.NotEmpty;

public class Person {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Name is required.")
    public String getSurname() {
        return surname;
    }

    @NotEmpty(message = "Surname is required.")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
