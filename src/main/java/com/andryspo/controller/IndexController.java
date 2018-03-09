package com.andryspo.controller;

import com.andryspo.domain.entity.User;
import com.andryspo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String index() {

        System.out.printf("sss");
        return "index";
    }

//    @PostConstruct
//    private void createUser() {
//        User user = new User();
//        user.setLogin("andryspo");
//        user.setPassword("123");
//
//        userRepo.save(user);
//    }

}
