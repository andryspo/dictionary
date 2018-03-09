package com.andryspo.controller;

import com.andryspo.domain.dto.login.LoginDto;
import com.andryspo.domain.dto.login.UserDataDto;
import com.andryspo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public UserDataDto login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }

}
