package com.training.springboot.controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.training.springboot.service.DefaultWelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.training.springboot.controller.WelcomeController;

@WebMvcTest(WelcomeController.class)


public class WelcomeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DefaultWelcomeService defaultWelcomeService;
    @Test


    public void welcomecontroller() throws Exception {
        //call GET "/welcomecontroller"  application/json

        RequestBuilder request = MockMvcRequestBuilders
                .get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("A warm and long greeting from training Team!!"))
                .andReturn();
    }
}
