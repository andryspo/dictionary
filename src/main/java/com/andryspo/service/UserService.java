package com.andryspo.service;

import com.andryspo.domain.entity.User;

public interface UserService {

    User getUserFromSession();

    User getByLogin(String login);

    void save(User user);
}
