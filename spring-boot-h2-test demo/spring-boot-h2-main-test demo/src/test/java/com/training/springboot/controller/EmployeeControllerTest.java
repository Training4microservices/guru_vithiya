package com.training.springboot.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import com.training.springboot.model.Employee;
import com.training.springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.training.springboot.controller.EmployeeController;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
        @Autowired
        private MockMvc mockMvc;
        @MockBean
        EmployeeService employeeService;
        @Test
        public void getAllEmployees() throws Exception{
                RequestBuilder request = MockMvcRequestBuilders
                        .get("/employees")
                        .accept(MediaType.APPLICATION_JSON);

                MvcResult result = mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andExpect(content().json(employeeService.getAllEmployees().toString()))
                        .andReturn();
                //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

        }
        @Test
        public void getEmployeeById() throws Exception
{
        mockMvc.perform( MockMvcRequestBuilders
      .get("/employees/{id}", 1)
      .accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
}

}
