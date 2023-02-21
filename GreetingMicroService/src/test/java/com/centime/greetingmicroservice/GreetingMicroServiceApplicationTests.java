package com.centime.greetingmicroservice;

import com.centime.greetingmicroservice.controller.GreetingWebController;
import com.centime.greetingmicroservice.model.Person;
import com.centime.greetingmicroservice.service.GreetingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(GreetingWebController.class)
class GreetingMicroServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GreetingService greetingService;

    @Test
    public void testSayHelloWorld() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(get("/api/greeting"))
                .andReturn().getResponse();
        Assertions.assertEquals("Up", response.getContentAsString());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGreetPersonWithoutSurname() throws Exception {
        Person person = getPersonDataWithoutSurname();
        doCallRealMethod().when(greetingService).validateRequest(any());

        MockHttpServletResponse response = this.mockMvc.perform(post("/api/greeting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    public void testGreetPersonWithoutName() throws Exception {
        Person person = getPersonDataWithoutName();
        doCallRealMethod().when(greetingService).validateRequest(any());

        MockHttpServletResponse response = this.mockMvc.perform(post("/api/greeting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    public void testGreetPersonWithName() throws Exception {
        Person person = getPersonData();

        Mockito.when(greetingService.greetPerson(Mockito.any())).thenReturn("hello person");
        MockHttpServletResponse response = this.mockMvc.perform(post("/api/greeting")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        Assertions.assertEquals("hello person", response.getContentAsString());

    }

    private Person getPersonDataWithoutSurname() {
        Person person = new Person();
        person.setName("Ayush");

        return person;
    }

    private Person getPersonDataWithoutName() {
        Person person = new Person();
        person.setSurname("Gupta");

        return person;
    }

    private Person getPersonData() {
        Person person = new Person();
        person.setName("Ayush");
        person.setSurname("Gupta");

        return person;
    }

}
