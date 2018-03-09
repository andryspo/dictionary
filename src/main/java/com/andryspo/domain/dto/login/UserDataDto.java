package com.andryspo.domain.dto.login;

import com.andryspo.domain.dto.group.GroupResponseDto;
import com.andryspo.domain.entity.WordGroup;

import java.util.List;
import java.util.stream.Collectors;

public class UserDataDto {

    private String login;

    private List<GroupResponseDto> groupsList;

    public UserDataDto(String login, List<WordGroup> groupsList) {
        this.login = login;
        this.groupsList = groupsList.stream().map(e -> new GroupResponseDto(e.getId(), e.getTitle())).collect(Collectors.toList());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<GroupResponseDto> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupResponseDto> groupsList) {
        this.groupsList = groupsList;
    }
}
