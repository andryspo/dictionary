package com.andryspo.mapper;

import com.andryspo.domain.dto.login.UserDataDto;
import com.andryspo.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public final class UserMapper implements Mapper<User, UserDataDto> {

    @Override
    public User mapToEntity(UserDataDto userDataDto) {

        return new User(userDataDto.getLogin());
    }

    @Override
    public UserDataDto mapToDto(User user) {
        return new UserDataDto(user.getLogin(), user.getWordGroups());
    }
}
