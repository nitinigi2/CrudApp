package com.springboot.novoice.commandlineexample;

import com.springboot.novoice.entity.User;
import com.springboot.novoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user = userService.save(new User("test", new Date(20-10-2011), "sample address", new ArrayList<>()));
        System.out.println(user);
    }
}
