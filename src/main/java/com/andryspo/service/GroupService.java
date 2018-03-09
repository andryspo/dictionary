package com.andryspo.service;

import com.andryspo.domain.dto.group.GroupDataDto;
import com.andryspo.domain.dto.group.GroupResponseDto;
import com.andryspo.domain.entity.WordGroup;

import java.util.List;

public interface GroupService {

    void addGroup(GroupDataDto groupDataDto);

    List<GroupResponseDto> getGroups();
}
