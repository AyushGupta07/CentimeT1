package com.centime.concatenatemicroservice;

import com.centime.concatenatemicroservice.controller.ConcatenateWebController;
import com.centime.concatenatemicroservice.model.Person;
import com.centime.concatenatemicroservice.service.ConcatenateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(ConcatenateWebController.class)
class ConcatenateMicroServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ConcatenateService concatenateService;

    @Test
    public void testConcatenatePerson() throws Exception {
        Person person = getPersonData();

        Mockito.when(concatenateService.concatenateName(Mockito.any())).thenCallRealMethod();
        MockHttpServletResponse response = this.mockMvc.perform(post("/api/concatenate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(person)))
                .andReturn().getResponse();

        Assertions.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        Assertions.assertEquals("Ayush Gupta", response.getContentAsString());

    }

    private Person getPersonData() {
        Person person = new Person();
        person.setName("Ayush");
        person.setSurname("Gupta");

        return person;
    }

}
