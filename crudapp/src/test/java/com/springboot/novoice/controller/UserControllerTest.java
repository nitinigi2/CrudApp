package com.springboot.novoice.controller;

import com.springboot.novoice.entity.User;
import com.springboot.novoice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    List<User> mockUsers = Arrays.asList(new User(1L, "abc", "09-12-2019", "dfr", new ArrayList<>()));

    @Test
    public void retrieveUsers() throws Exception {
        //System.out.println(mockUsers);
        Mockito.when(userService.findAll()).thenReturn(mockUsers);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        String expected = "[{id:1,name:abc,dob:09-12-2019,address:dfr,post:[]}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}