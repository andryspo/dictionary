package com.andryspo.service.impl;

import com.andryspo.constants.errors.SessionErrors;
import com.andryspo.domain.entity.User;
import com.andryspo.exception.SessionExpiredException;
import com.andryspo.repository.UserRepo;
import com.andryspo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserSessionData userSessionData;

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserFromSession() {
        LOGGER.info("getting user from session");

        User user = userRepo.findUserByLogin(userSessionData.getLogin());

        if(user == null) {
            LOGGER.info("session expired");
            throw new SessionExpiredException(SessionErrors.SESSION_EXPIRED_ERROR);
        }

        return user;
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public User getByLogin(String login) {
        return userRepo.findUserByLogin(login);
    }
}
