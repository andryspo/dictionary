package com.andryspo.service.impl;

import com.andryspo.constants.errors.LoggingInErrors;
import com.andryspo.domain.dto.login.LoginDto;
import com.andryspo.domain.dto.login.UserDataDto;
import com.andryspo.domain.entity.User;
import com.andryspo.exception.InvalidPasswordException;
import com.andryspo.exception.UserNotExistException;
import com.andryspo.mapper.UserMapper;
import com.andryspo.repository.UserRepo;
import com.andryspo.service.LoginService;
import com.andryspo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserSessionData userSessionData;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDataDto login(LoginDto loginDto) {
        LOGGER.info("logging in {} ", loginDto.getLogin());
        User user = validateUser(loginDto);
        userSessionData.setLogin(user.getLogin());

        return userMapper.mapToDto(user);
    }

    private User validateUser(LoginDto loginDto) {

        User user = userService.getByLogin(loginDto.getLogin());

        if(user == null) {
            throw new UserNotExistException(LoggingInErrors.USER_NOT_EXIST);
        }
        if(!user.getPassword().equals(loginDto.getPassword())) {
            throw new InvalidPasswordException(LoggingInErrors.PASSWORD_DOESNT_MATCH);
        }

        return user;
    }
}
