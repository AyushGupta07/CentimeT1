package com.centime.hellomicroservice;

import com.centime.hellomicroservice.controller.HelloWebController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(HelloWebController.class)
class HelloMicroServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHelloWorld() throws Exception {
        MockHttpServletResponse response = this.mockMvc.perform(get("/api/hello"))
                .andReturn().getResponse();
        Assertions.assertEquals("hello", response.getContentAsString());
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
