package com.andryspo.service;

import com.andryspo.domain.dto.login.LoginDto;
import com.andryspo.domain.dto.login.UserDataDto;

public interface LoginService {

    UserDataDto login(LoginDto loginDto);
}
